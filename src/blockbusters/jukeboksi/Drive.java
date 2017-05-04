package blockbusters.jukeboksi;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.utility.Delay;

public class Drive {

	private EV3LargeRegulatedMotor leftMotor;
	private EV3LargeRegulatedMotor rightMotor;
	
	public Drive(EV3LargeRegulatedMotor left, EV3LargeRegulatedMotor right){
		this.leftMotor = left;
		this.rightMotor = right;
		
		this.leftMotor.setSpeed(200);
		this.leftMotor.stop();
		this.rightMotor.setSpeed(200);
		this.rightMotor.stop();
	}
	
	public void forward()
	{
		leftMotor.backward();
		rightMotor.backward();
	}
	
	public void backward()
	{
		leftMotor.forward();
		rightMotor.forward();
	}
	
	public void turnLeft()
	{
		leftMotor.forward();
		rightMotor.backward();
	}
	
	public void turnRight()
	{
		leftMotor.backward();
		rightMotor.forward();
	}
	
	public void stop()
	{
		leftMotor.stop();
		rightMotor.stop();
	}
	
}
