/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

/**
 * Tests of the evaluation of expression trees
 * 
 * @author Sara Sprenkle
 * 
 */
public class EvaluatorTests {

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
	public void testExpEvaluation() {
		Exp myTree = new Exp(new X());
		double e = Math.E;

		assertEquals(new RGBColor(1,1,1), myTree.evaluate(0, 0));
		assertEquals(e, myTree.evaluate(1, 0).getRed(), 0.01);
		assertEquals(e, myTree.evaluate(1, 0).getGreen(), 0.01);
		assertEquals(e, myTree.evaluate(1, 0).getBlue(), 0.01);
	}

	@Test
	public void testSinEvaluation() {
		Sin myTree = new Sin(new X());
		
		assertEquals(0, myTree.evaluate(-Math.PI,-Math.PI).getRed(), 0.01);
		assertEquals(0, myTree.evaluate(-Math.PI,-Math.PI).getGreen(), 0.01);
		assertEquals(0, myTree.evaluate(-Math.PI,-Math.PI).getBlue(), 0.01);
		
		for (double i = -Math.PI; i <= Math.PI; i+= 2*Math.PI) {
			assertEquals(0, myTree.evaluate(-i,-i).getRed(), 0.01);
			assertEquals(0, myTree.evaluate(-i,-i).getGreen(), 0.01);
			assertEquals(0, myTree.evaluate(-i,-i).getBlue(), 0.01);
		}
	}
	/*
    	@Test
	public void testTanEvaluation() {
		Tan myTree = new Tan(new X());
		double vals[] = { -1.0, 0.12, 1.0};
		double tan_val;
		for (double val : vals) {
			tan_val = Math.floor(val);
			assertEquals(new RGBColor(tan_val, tan_val, tan_val), myTree.evaluate(val, val));
		}
		return;
	}
	*/
	
	@Test
	public void testPlusEvaluation() {
		Plus myTree = new Plus(new X(), new Y());

		assertEquals(new RGBColor(1,1,1), myTree.evaluate(0.5, 0.5));
		assertEquals(new RGBColor(-1,-1,-1), myTree.evaluate(-0.5, -0.5));
		assertEquals(new RGBColor(0,0,0), myTree.evaluate(-0.5, 0.5));
		assertEquals(new RGBColor(0,0,0), myTree.evaluate(0.5, -0.5));
		assertEquals(new RGBColor(1,1,1), myTree.evaluate(1, 0));
		assertEquals(new RGBColor(1,1,1), myTree.evaluate(0, 1));
		assertEquals(new RGBColor(-1,-1,-1), myTree.evaluate(-1, 0));
		assertEquals(new RGBColor(-1,-1,-1), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(-1.5,-1.5,-1.5), myTree.evaluate(-2, 0.5)); //this test is accurate assuming the range clamping does not happen at this step.
	}
	// TODO: More tests of evaluation

}
