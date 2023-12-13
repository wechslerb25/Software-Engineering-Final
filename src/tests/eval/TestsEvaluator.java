/**
 * 
 */
package tests.eval;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import java.io.PrintStream;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import picasso.util.ErrorWindow;

/**
 * Evaluates the tests and prints success or failure.
 * @author Reese Nelson
 */
public class TestsEvaluator {

	private static final String TESTS_PACKAGE = "tests";
	private static final String[] TEST_FILE_NAMES = {
			"ErrorParsedEvaluatedTests", "EvaluatorTests",
			"ExpressionTreeGeneratorTests",
			"SemanticAnalyzerTest", "TokenizerTest"};
	
	public static void main(String[] args) {
		TestsEvaluator evaluator = new TestsEvaluator();
		evaluator.run();
	}
	
	public void run() {
		boolean passed = true;
		ErrorWindow.setSilenced(true);
		for (String name : TEST_FILE_NAMES) {
			Class<?> tSuite;
			try {
				tSuite = Class.forName(TESTS_PACKAGE + "." + name);
				boolean success = evalTest(tSuite);
				if(!success) {
					passed = false;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if(passed) {
			System.out.println("Passed All Tests!");
		}
		else {
			System.out.println("Failed Test Cases.");
		}
		ErrorWindow.setSilenced(false);
	}
	
	public boolean evalTest(Class<?> testClass) {
		final LauncherDiscoveryRequest request = setUpTestRequest(testClass);
		
		final Launcher launcher = LauncherFactory.create();
		final SummaryGeneratingListener listener = new SummaryGeneratingListener();
		launcher.registerTestExecutionListeners(listener);
		
		System.out.println("~~~~~~~~~~ Testing the " + testClass.getName() + " Test Class ~~~~~~~~~~");
		launcher.execute(request);

		TestExecutionSummary summary = listener.getSummary();
		if (summary.getTestsFailedCount() == 0) {
			System.out.println("Passed");
			return true;
		}
		else {
			System.err.println("Failed");
			if (summary.getFailures().size() > 0) {
				displayFailedTestsResult(summary, System.out);
			}
		}
		return false;
	}
	
	private LauncherDiscoveryRequest setUpTestRequest(Class<?> testClass) {
		final LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
				.selectors(selectClass(testClass)).build();
		return request;
	}
	
	private void displayFailedTestsResult(TestExecutionSummary summary, PrintStream out) {
		out.println("Test cases failed (" + summary.getTestsFailedCount() + "): ");
		for (TestExecutionSummary.Failure failure : summary.getFailures()) {
			out.println(" - " + failure.getTestIdentifier().getDisplayName());
		}
	}
	
}
