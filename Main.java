import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.util.Delay;
import lejos.util.Stopwatch;
import lejos.util.Timer;

public class Main {
	
	public static void main(String[] args) {
		Stopwatch clock = new Stopwatch();
		DriveTrain dt = DriveTrain.getInstance();
		Claw claw = Claw.getInstance();

		int startDelay = 1000;
		int dropBallTime = 1600;

		Button.waitForAnyPress();
		claw.open();
		Delay.msDelay(startDelay);
		clock.reset();
		claw.close();
		while (!claw.ballInClaw()) {
			// wait for ball
		}
		int timeToDrive = 20000 - clock.elapsed() - dropBallTime;
		int dist = dt.toDeg(50);
		int speed = (dist * 1000) / timeToDrive;
		dt.setSpeed(speed, speed);
		Delay.msDelay(timeToDrive);
		dt.stop();
		claw.open();
		Delay.msDelay(5000); // wait to lift claw
		claw.close();
		Delay.msDelay(2000); // let claw get up
	}
}
