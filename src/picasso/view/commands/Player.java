package picasso.view.commands;

import java.time.Duration;
import java.time.Instant;

import picasso.model.Pixmap;
import picasso.parser.IdentifierAnalyzer;
import picasso.parser.language.expressions.Constant;
import picasso.util.Command;

/**
 * Evaluate the expression while updating the time variable. Meant to be executed by a RepeatedThreadedCommand.
 * 
 * @author Reese Nelson
 */
public class Player implements Command<Pixmap> {
	
	private static Player ourInstance;
	private final Evaluator evaluator;
	private static Duration playTime;
	private Instant startTime;

	private Player(Evaluator evaluator) {
		this.evaluator = evaluator;
		playTime = Duration.ZERO;
		this.startTime = Instant.now();
	}

	@Override
	public void execute(Pixmap target) {
			updatePlayTime();
			evaluator.execute(target);
	}
	
	public static Duration getPlayTime() {
		return playTime;
	}
	
	private void updatePlayTime() {
		playTime = Duration.between(startTime, Instant.now());
		double t = ((double) playTime.toMillis() / 10000);
	    double l = (Math.round((t % 2) * 100) / 100.0) - 1;
	    double b = Math.round(Math.cos(t * Math.PI) * 100) / 100.0;
		
		IdentifierAnalyzer.idToExpression.put("r", new Constant(l));
		IdentifierAnalyzer.idToExpression.put("b", new Constant(b));
	}
	
	/**
	 * Make sure that there is only one player for the application.
	 * 
	 * @return the player
	 */
	public static Player getInstance(Evaluator evaluator) {
		if (ourInstance == null) {
			ourInstance = new Player(evaluator);
		}
		return ourInstance;
	}
}
