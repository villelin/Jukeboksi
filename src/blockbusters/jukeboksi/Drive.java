package blockbusters.jukeboksi;

import lejos.hardware.motor.EV3LargeRegulatedMotor;

public class Drive {

	private EV3LargeRegulatedMotor leftMotor;
	private EV3LargeRegulatedMotor rightMotor;
	
	public Drive(EV3LargeRegulatedMotor left, EV3LargeRegulatedMotor right){
		this.leftMotor = left;
		this.rightMotor = right;
	}
	
}
