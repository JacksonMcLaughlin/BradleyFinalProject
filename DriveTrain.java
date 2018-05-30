import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;

public class DriveTrain {
	private static DriveTrain INSTANCE = new DriveTrain();

	public static DriveTrain getInstance() {
		return INSTANCE;
	}

	private NXTRegulatedMotor left;
	private NXTRegulatedMotor right;
	
	public static final double CM_PER_DEG = 0.03675;

	private DriveTrain() {
		left = Motor.A;
		right = Motor.B;
		left.resetTachoCount();
		right.resetTachoCount();
	}
	
	public void setSpeed(int leftSpeed, int rightSpeed) {
		left.setSpeed(leftSpeed);
		if (leftSpeed > 0) {
			left.forward();
		} else {
			left.backward();
		}
		right.setSpeed(rightSpeed);
		if (rightSpeed > 0) {
			right.forward();
		} else {
			right.forward();
		}
	}
	
	public NXTRegulatedMotor getLeft() {
		return left;
	}
	
	public NXTRegulatedMotor getRight() {
		return right;
	}
	
	public int getLeftCount() {
		return left.getTachoCount();
	}

	public int getRightCount() {
		return right.getTachoCount();
	}
	
	public void stop() {
		left.stop(true);
		right.stop();
	}
	
	public int toDeg(double cm) {
		return (int) (cm / CM_PER_DEG);
	}
	public double toCm(int deg) {
		return deg * CM_PER_DEG;
	}
}