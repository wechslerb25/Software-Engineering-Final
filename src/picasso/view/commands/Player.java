package picasso.view.commands;

import java.time.Duration;
import java.time.Instant;

import picasso.model.Pixmap;
import picasso.util.Command;

/**
 * Repeatedly evaluate the expression while updating the time variable.
 * 
 * @author Reese Nelson
 */
public class Player implements Command<Pixmap> {
	
	private static Player ourInstance;
	private final Evaluator evaluator;
	private static final int DELAY = 50; //20 fps
	private Duration playTime;
	private Instant startTime;
	private boolean playing;
//threaded command here not in frame
	private Player(Evaluator evaluator) {
		this.evaluator = evaluator;
		this.playing = false;
		this.playTime = Duration.ZERO;
		this.startTime = Instant.now();
	}

	@Override
	public void execute(Pixmap target) {
			updatePlayTime();
			evaluator.execute(target);
			System.out.println("test");
	}
	
	public Duration getPlayTime() {
		return playTime;
	}
	
	private void updatePlayTime() {
		playTime = Duration.between(startTime, Instant.now());
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
