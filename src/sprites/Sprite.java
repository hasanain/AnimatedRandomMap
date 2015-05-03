package sprites;

import java.awt.Image;

public abstract class Sprite {

	public enum State {
		MOVING_LEFT, MOVING_RIGHT, MOVING_UP, MOVING_DOWN, IDLE

	}

	protected State state;
	protected int frame;

	public Sprite() {
		state = State.IDLE;
		frame = 0;
	}

	public abstract Image getImage();

	public boolean isFinished() {

		return false;
	}

	public abstract int getWidth();

	public abstract int getHeight();

	public State getState() {

		return this.state;
	}

	public void setState(State state) {
		this.state = state;

	}

	public void reset() {

	}

}
