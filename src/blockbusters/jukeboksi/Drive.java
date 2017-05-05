/**
 * Drive-luokka ohjaa robottia.
 * @author Ville Linde
 * @version 1.0
 */

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
	
	/**
	 * Aloittaa liikuttamaan robottia eteenp‰in.
	 */
	public void forward()
	{
		leftMotor.backward();
		rightMotor.backward();
	}
	
	/**
	 * Aloittaa liikuttamaan robottia taaksep‰in.
	 */
	public void backward()
	{
		leftMotor.forward();
		rightMotor.forward();
	}
	
	/**
	 * Aloittaa k‰‰nt‰m‰‰n robottia vasemmalle.
	 */
	public void turnLeft()
	{
		leftMotor.forward();
		rightMotor.backward();
	}
	
	/**
	 * Aloittaa k‰‰nt‰m‰‰n robottia oikealle.
	 */
	public void turnRight()
	{
		leftMotor.backward();
		rightMotor.forward();
	}
	
	/**
	 * Pys‰ytt‰‰ robotin.
	 */
	public void stop()
	{
		leftMotor.stop();
		rightMotor.stop();
	}
	
}
