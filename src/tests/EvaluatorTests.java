/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.model.Pixmap;
import picasso.parser.ParseException;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.util.ErrorWindow;

/**
 * Tests of the evaluation of expression trees
 * 
 * @author Sara Sprenkle
 * 
 */
public class EvaluatorTests {

	@BeforeAll
	public static void disablePopups() {
		ErrorWindow.setSilenced(true);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testConstantEvaluation() {
		ExpressionTreeNode e = new RGBColor(1, -1, 1);
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(1, -1, 1), e.evaluate(i, i));
		}
	}

	@Test
	public void testXEvaluation() {
		X x = new X();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), x.evaluate(i, i));
		}
	}

	@Test
	public void testFloorEvaluation() {
		Floor myTree = new Floor(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));

		// additional tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, 0));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1.5, 2.7));
		assertEquals(new RGBColor(-3, -3, -3), myTree.evaluate(-2.3, -3.8));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double floorOfTestVal = Math.floor(testVal);
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}

	@Test
	public void testCosEvaluation() {
		Cosine myTree = new Cosine(new X());

		double[] testVals = { -1.0, 0.12, 1.0 };

		for (double val : testVals) {
			double cosVal = Math.cos(val);
			assertEquals(new RGBColor(cosVal, cosVal, cosVal), myTree.evaluate(val, val));
		}
	}

	@Test
	public void testExpEvaluation() {
		Exp myTree = new Exp(new X());
		double e = Math.E;

		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0, 0));
		assertEquals(e, myTree.evaluate(1, 0).getRed(), 0.01);
		assertEquals(e, myTree.evaluate(1, 0).getGreen(), 0.01);
		assertEquals(e, myTree.evaluate(1, 0).getBlue(), 0.01);
	}
	
	@Test
	public void testAbsEvaluation() {
		AbsoluteValue myTree = new AbsoluteValue(new X());

		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, 0));
		assertEquals(new RGBColor(0.5, 0.5, 0.5), myTree.evaluate(0.5, 0.5));
		assertEquals(new RGBColor(0.5, 0.5, 0.5), myTree.evaluate(-0.5, -0.5));
	}
	
	@Test
	public void testAtanEvaluation() {
		Atan myTree = new Atan(new X());
		double pi = Math.PI;
		
		assertEquals(pi/4, myTree.evaluate(1, 1).getRed(), 0.001);
	}
	
	@Test
	public void testCeilEvaluation() {
		Ceil myTree = new Ceil(new X());

		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0.5, 0.5));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, 0));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(-0.5, -0.5));
	}
	
	@Test
	public void testLogEvaluation() {
		Log myTree = new Log(new X());
		double e = Math.E;

		assertEquals(1, myTree.evaluate(e, e).getRed(),0.001);
	}

	@Test
	public void testSinEvaluation() {
		Sin myTree = new Sin(new X());
		assertEquals(0, myTree.evaluate(-Math.PI, -Math.PI).getRed(), 0.01);
		assertEquals(0, myTree.evaluate(-Math.PI, -Math.PI).getGreen(), 0.01);
		assertEquals(0, myTree.evaluate(-Math.PI, -Math.PI).getBlue(), 0.01);

		for (double i = -Math.PI; i <= Math.PI; i += 2 * Math.PI) {
			assertEquals(0, myTree.evaluate(-i, -i).getRed(), 0.01);
			assertEquals(0, myTree.evaluate(-i, -i).getGreen(), 0.01);
			assertEquals(0, myTree.evaluate(-i, -i).getBlue(), 0.01);
		}
	}

	@Test
	public void testTanEvaluation() {
		Tan myTree = new Tan(new X());
		double vals[] = { -1.0, 0.12, 1.0, 0.5, 0, Math.PI / 2 };
		double tan_val;
		for (double val : vals) {
			tan_val = Math.tan(val);
			assertEquals(new RGBColor(tan_val, tan_val, tan_val), myTree.evaluate(val, val));
		}
		return;
	}

	@Test
	public void testAdditionEvaluation() {
		Addition myTree = new Addition(new X(), new Y());

		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0.5, 0.5));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-0.5, -0.5));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(-0.5, 0.5));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0.5, -0.5));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1, 0));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0, 1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-1, 0));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(-1.5, -1.5, -1.5), myTree.evaluate(-2, 0.5)); // this test is accurate assuming the
																				// range clamping does not happen at
																				// this step.
	}

	@Test
	public void testSubtractionEvaluation() {
		Subtraction myTree = new Subtraction(new X(), new Y());

		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0.5, 0.5));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(-0.5, -0.5));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-0.5, 0.5));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0.5, -0.5));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1, 0));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(0, 1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-1, 0));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(-2.5, -2.5, -2.5), myTree.evaluate(-2, 0.5)); // this test is accurate assuming the
																				// range clamping does not happen at
																				// this step.
	}

	@Test
	public void testMultiplicationEvaluation() {
		Multiplication myTree = new Multiplication(new X(), new Y());

		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(2, 0.5));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0.5, 2));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(1, 0));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-1, 1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(-1, -1));
		assertEquals(new RGBColor(-0.25, -0.25, -0.25), myTree.evaluate(-0.5, 0.5));
	}

	@Test
	public void testDivisionEvaluation() {
		Division myTree = new Division(new X(), new Y());

		assertEquals(new RGBColor(4, 4, 4), myTree.evaluate(2, 0.5));
		assertEquals(new RGBColor(0.25, 0.25, 0.25), myTree.evaluate(0.5, 2));
		assertTrue(Double.isInfinite(myTree.evaluate(1, 0).getRed()));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-1, 1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(-1, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-0.5, 0.5));

	}

	@Test
	public void testModuloEvaluation() {
		Modulo myTree = new Modulo(new X(), new Y());

		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(4, 0.5));
		assertEquals(new RGBColor(0.5, 0.5, 0.5), myTree.evaluate(0.5, 2));
		assertTrue(Double.isNaN(myTree.evaluate(1, 0).getRed()));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(-1, 1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(7, 3));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(4, -2));
	}

	@Test
	public void testClampEvaluation() {
		Clamp myTree = new Clamp(new X());

		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1.9, 2.0));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(5.0, 2.0));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-1.9, 2.0));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-12.9, -2.0));

	}

	@Test
	public void testExponentialEvaluation() {
		Exponentiate myTree = new Exponentiate(new X(), new Y());

		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1, 0.5));
		assertEquals(new RGBColor(0.5, 0.5, 0.5), myTree.evaluate(0.5, 1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-1, 1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, 0.5));
	}

	@Test
	public void testWrapEvaluation() {
		Wrap myTree = new Wrap(new X());

		assertEquals(new RGBColor(-0.5, -0.5, -0.5), myTree.evaluate(1.5, 2.0));
		assertEquals(new RGBColor(0.75, 0.75, 0.75), myTree.evaluate(2.75, 2.0));
		assertEquals(0.2, myTree.evaluate(-1.8, 2).getRed(), 0.01);
		assertEquals(0.2, myTree.evaluate(-1.8, 2).getGreen(), 0.01);
		assertEquals(0.2, myTree.evaluate(-1.8, 2).getBlue(), 0.01);
		assertEquals(-0.6, myTree.evaluate(-2.6, 2).getRed(), 0.01);
		assertEquals(-0.6, myTree.evaluate(-2.6, 2).getGreen(), 0.01);
		assertEquals(-0.6, myTree.evaluate(-2.6, 2).getBlue(), 0.01);

	}

	@Test
	public void testExponentiateEvaluation() {
		Exponentiate myTree = new Exponentiate(new X(), new Y());

		assertEquals(new RGBColor(2, 2, 2), myTree.evaluate(4, 0.5));
		assertEquals(new RGBColor(0.25, 0.25, 0.25), myTree.evaluate(0.5, 2));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(2, 0));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-1, 1));
		assertEquals(new RGBColor(8, 8, 8), myTree.evaluate(2, 3));
		assertEquals(new RGBColor(0.25, 0.25, 0.25), myTree.evaluate(4, -1));
	}

	@Test
	public void testNegateEvaluation() {
		Negate myTree = new Negate(new X());

		assertEquals(new RGBColor(-4, -4, -4), myTree.evaluate(4, 2));
		assertEquals(new RGBColor(0.5, 0.5, 0.5), myTree.evaluate(-0.5, 2));
	}

	@Test
	public void testLessThanEvaluation() {
		LessThan myTree = new LessThan(new X(), new Y());

		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0.5, 1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(0.7, -0.1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(0, 0));
		LessThan myTree2 = new LessThan(new X(), new RGBColor(0, 1, 0.5));
		assertThrows(ParseException.class, () -> {
			myTree2.evaluate(0, 0.5);
		});
	}

	@Test
	public void testLessEqualsToEvaluation() {
		LessEquals myTree = new LessEquals(new X(), new Y());

		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0.5, 1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(0.7, -0.1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0, 0));
		LessEquals myTree2 = new LessEquals(new X(), new RGBColor(0, 1, 0.5));
		assertThrows(ParseException.class, () -> {
			myTree2.evaluate(0, 0.5);
		});
	}

	@Test
	public void testGreaterThanEvaluation() {
		GreaterThan myTree = new GreaterThan(new X(), new Y());

		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(0.5, 1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0.7, -0.1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(0, 0));
		GreaterThan myTree2 = new GreaterThan(new X(), new RGBColor(0, 1, 0.5));
		assertThrows(ParseException.class, () -> {
			myTree2.evaluate(0, 0.5);
		});
	}

	@Test
	public void testGreaterEqualsToEvaluation() {
		GreaterEquals myTree = new GreaterEquals(new X(), new Y());

		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(0.5, 1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0.7, -0.1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0, 0));
		GreaterEquals myTree2 = new GreaterEquals(new X(), new RGBColor(0, 1, 0.5));
		assertThrows(ParseException.class, () -> {
			myTree2.evaluate(0, 0.5);
		});
	}

	@Test
	public void testEqualsEvaluation() {
		Equals myTree = new Equals(new X(), new Y());

		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(0.5, 1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(0.7, -0.1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0, 0));
		Equals myTree2 = new Equals(new X(), new RGBColor(0, 1, 0.5));
		assertThrows(ParseException.class, () -> {
			myTree2.evaluate(0, 0.5);
		});
	}

	@Test
	public void testNotEqualsEvaluation() {
		NotEquals myTree = new NotEquals(new X(), new Y());

		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0.5, 1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(0.7, -0.1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(0, 0));
		NotEquals myTree2 = new NotEquals(new X(), new RGBColor(0, 1, 0.5));
		assertThrows(ParseException.class, () -> {
			myTree2.evaluate(0, 0.5);
		});
	}

	@Test
	public void testAndEvaluation() {
		And myTree = new And(new X(), new Y());

		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1, 1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(1, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-1, -1));
		assertThrows(ParseException.class, () -> {
			myTree.evaluate(0, 0.5);
		});
		And myTree2 = new And(new X(), new RGBColor(0, 1, 0.5));
		assertThrows(ParseException.class, () -> {
			myTree2.evaluate(0, 0.5);
		});
	}

	@Test
	public void testOrEvaluation() {
		Or myTree = new Or(new X(), new Y());

		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1, 1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-1, -1));
		assertThrows(ParseException.class, () -> {
			myTree.evaluate(0, 0.5);
		});
		Or myTree2 = new Or(new X(), new RGBColor(0, 1, 0.5));
		assertThrows(ParseException.class, () -> {
			myTree2.evaluate(0, 0.5);
		});
	}

	@Test
	public void testClampFunction() {
		Clamp myTree = new Clamp(new X());

		assertEquals(new RGBColor(1.0, 1.0, 1.0), myTree.evaluate(1.5, 4.0));
		assertEquals(new RGBColor(-1.0, -1.0, -1.0), myTree.evaluate(-2.4, -20));
	}

	@Test
	public void testCurrentState() {
		assertThrows(ParseException.class, () -> {
			CS.getCurrentState();
		});
		Pixmap P = new Pixmap(10, 10);
		CS.setCurrentState(P);
		assertEquals((new RGBColor(-1, -1, -1)).toJavaColor(), CS.getCurrentState().getColor(0, 0));
	}

	@Test
	public void testString() {
		StringClass sc = new StringClass("images/BlackWhiteTomlinson.png");
		assertEquals(new RGBColor(-1, -1, -1), sc.evaluate(-1, -1));

	}

	// TODO: More tests of evaluation

}
