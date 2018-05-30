import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class Claw {
	private NXTRegulatedMotor motor;
	private TouchSensor ts;
	
	private static final int OPEN = 118;
	private static final int CLOSED = 0;
	
	private static final Claw INSTANCE = new Claw();

	private Claw() {
		motor = Motor.C;
		ts = new TouchSensor(SensorPort.S1);
	}
	
	public static Claw getInstance() {
		return INSTANCE;
	}
	
	public void open() {
		motor.rotateTo(OPEN, true);
	}
	
	public void close() {
		motor.rotateTo(CLOSED, true);
	}
	
	public boolean ballInClaw() {
		return ts.isPressed();
	}

}
