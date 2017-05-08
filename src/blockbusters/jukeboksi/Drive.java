package blockbusters.jukeboksi;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.utility.Delay;

/**
 * Drive-luokka ohjaa robottia.
 * @author Ville Linde
 * @version 1.0
 */

public class Drive {

	/**
	 * leJOS-rajapinnan iso moottori
	 */
	private EV3LargeRegulatedMotor leftMotor;
	
	/**
	 * leJOS-rajapinnan iso moottori
	 */
	private EV3LargeRegulatedMotor rightMotor;
	
	public Drive(EV3LargeRegulatedMotor left, EV3LargeRegulatedMotor right){
		this.leftMotor = left;
		this.rightMotor = right;
		
		this.leftMotor.setSpeed(200);
		this.leftMotor.stop();
		this.rightMotor.setSpeed(200);
		this.rightMotor.stop();
	}
	
	/**
	 * Aloittaa liikuttamaan robottia eteenpäin.
	 */
	public void forward()
	{
		leftMotor.backward();
		rightMotor.backward();
	}
	
	/**
	 * Aloittaa liikuttamaan robottia taaksepäin.
	 */
	public void backward()
	{
		leftMotor.forward();
		rightMotor.forward();
	}
	
	/**
	 * Aloittaa kääntämään robottia vasemmalle.
	 */
	public void turnLeft()
	{
		leftMotor.forward();
		rightMotor.backward();
	}
	
	/**
	 * Aloittaa kääntämään robottia oikealle.
	 */
	public void turnRight()
	{
		leftMotor.backward();
		rightMotor.forward();
	}
	
	/**
	 * Pysäyttää robotin.
	 */
	public void stop()
	{
		leftMotor.stop();
		rightMotor.stop();
	}
	
}
