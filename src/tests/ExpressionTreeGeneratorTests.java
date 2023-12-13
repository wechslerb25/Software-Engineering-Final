package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.PlusToken;
import picasso.parser.tokens.operations.StarToken;
import picasso.util.ErrorWindow;

/**
 * Tests of creating an expression tree from a string expression. Will have
 * compiler errors until some code is created.
 * 
 * @author Sara Sprenkle
 * 
 */
public class ExpressionTreeGeneratorTests {

	private ExpressionTreeGenerator parser;
	
	@BeforeAll
	public static void disablePopups() {
		ErrorWindow.setSilenced(true);
	}

	@BeforeEach
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void constantExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("[1,-1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
	}

	@Test
	public void variableExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x");
		assertEquals(new X(), e);
	}

	@Test
	public void additionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x + y");
		assertEquals(new Addition(new X(), new Y()), e);

		// no spaces!
		e = parser.makeExpression("x+y");
		assertEquals(new Addition(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1] + y");
		assertEquals(new Addition(new RGBColor(1, .3, -1), new Y()), e);

		e = parser.makeExpression("x + y + [ -.51, 0, 1]");
		assertEquals(new Addition(new Addition(new X(), new Y()), new RGBColor(-.51, 0, 1)), e);
	}
	
	@Test
	public void negateExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("!x");
		assertEquals(new Negate(new X()), e);

		e = parser.makeExpression("!(x+y)");
		assertEquals(new Negate(new Addition(new X(), new Y())), e);

		e = parser.makeExpression("!x+y");
		assertEquals(new Addition(new Negate(new X()), new Y()), e);

		e = parser.makeExpression("![1,1,1]");
		assertEquals(new Negate(new RGBColor(1,1,1)), e);
	}
	
	@Test
	public void comparisonExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x < y");
		assertEquals(new LessThan(new X(), new Y()), e);

		e = parser.makeExpression("x > y & y <= [0,0,0]");
		assertEquals(new And(new GreaterThan(new X(), new Y()), new LessEquals(new Y(), new RGBColor(0,0,0))), e);

		e = parser.makeExpression("x < 0 == y");
		assertEquals(new Equals(new LessThan(new X(), new RGBColor(0,0,0)), new Y()), e);

		e = parser.makeExpression("x < y | y > x + 0.5");
		assertEquals(new Or(new LessThan(new X(), new Y()), new GreaterThan(new Y(), new Addition(new X(), new RGBColor(0.5,0.5,0.5)))), e);
	}

	@Test
	public void parenthesesExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("( x + y )");
		assertEquals(new Addition(new X(), new Y()), e);

		e = parser.makeExpression("( x + (y + [ 1, 1, 1] ) )");
		assertEquals(new Addition(new X(), new Addition(new Y(), new RGBColor(1, 1, 1))), e);
	}
	
	@Test
	public void arithmeticStackTests() {
		Stack<Token> stack = parser.infixToPostfix("x + y * x");

		Stack<Token> expected = new Stack<>();
		expected.push(new IdentifierToken("x"));
		expected.push(new IdentifierToken("y"));
		expected.push(new IdentifierToken("x"));
		expected.push(new StarToken());
		expected.push(new PlusToken());

		assertEquals(expected, stack);
	}

	@Test
	public void floorFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("floor( x )");
		assertEquals(new Floor(new X()), e);

		e = parser.makeExpression("floor( x + y )");
		assertEquals(new Floor(new Addition(new X(), new Y())), e);
	}
	@Test
	public void expFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("exp( x )");
		assertEquals(new Exp(new X()), e);

		e = parser.makeExpression("exp( x + y )");
		assertEquals(new Exp(new Addition(new X(), new Y())), e);
	}
	@Test
	public void cosFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("cos( x )");
		assertEquals(new Cosine(new X()), e);

		e = parser.makeExpression("cos( x + y )");
		assertEquals(new Cosine(new Addition(new X(), new Y())), e);
	}

	@Test
	public void tanFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("tan(x)");
		assertEquals(new Tan(new X()), e);

		e = parser.makeExpression("tan( x + y )");
		assertEquals(new Tan(new Addition(new X(), new Y())), e);

	}
	
	@Test
	public void sinFunctionTests() {
		ExpressionTreeNode e = parser.makeExpression("sin(x)");
		assertEquals(new Sin(new X()), e);

		e = parser.makeExpression("sin( x + y )");
		assertEquals(new Sin(new Addition(new X(), new Y())), e);

	}
}
