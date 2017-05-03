package blockbusters.jukeboksi;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;

public class DiscReader {

	
	private EV3ColorSensor discReader;
	private EV3MediumRegulatedMotor discPlayer;
	
	
	public DiscReader(EV3ColorSensor discReader, EV3MediumRegulatedMotor discPlayer){
		this.discReader = discReader;
		this.discPlayer = discPlayer;
	}
}
