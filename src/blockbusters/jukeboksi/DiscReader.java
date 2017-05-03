package blockbusters.jukeboksi;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

public class DiscReader {

	
	private EV3ColorSensor discReader;
	private EV3MediumRegulatedMotor discPlayer;
	
	
	public DiscReader(EV3ColorSensor discReader, EV3MediumRegulatedMotor discPlayer){
		this.discReader = discReader;
		this.discPlayer = discPlayer;
	}
	
	public void nextSong() {
		discPlayer.rotate(-90);
	}
	
	public void lastSong() {
		discPlayer.rotate(90);
	}
	
	public int getSongID() {
		
		int song = 0;
		
		switch (discReader.getColorID()) 
		{
			case Color.GREEN:
				song = 1;
				break;
				
				
			case Color.RED:
				song = 2;
				break;
				
			case Color.BLUE:
				song = 3;
				break;
				
			case Color.WHITE:
				song = 4;
				break;
				
			default:
				song = -1;
				break;
		}

		return 0;
	}	
}
