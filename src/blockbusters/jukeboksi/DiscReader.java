package blockbusters.jukeboksi;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

/**
 * DiscReader kääntää levyä ja palauttaa "lukijan" näkemän kappaleen numeron. Levyllä oleva väri määrittää sitä vastaavan kappaleen numeron.
 * 
 * @author Mikael Anttila
 * @version 1.0
 *
 */

public class DiscReader {

	
	private EV3ColorSensor discReader;
	private EV3MediumRegulatedMotor discPlayer;
	
	
	public DiscReader(EV3ColorSensor discReader, EV3MediumRegulatedMotor discPlayer){
		this.discReader = discReader;
		this.discPlayer = discPlayer;
	}
	
	/**
	 * Kääntää levyä seuraavan kappaleen kohdalle.
	 */
	public void nextSong() {
		discPlayer.rotate(-90);
	}
	
	/**
	 * Kääntää levyä edellisen kappaleen kohdalle.
	 */
	public void lastSong() {
		discPlayer.rotate(90);
	}
	
	/**
	 * Palauttaa lukijan näkemän kappaleen numeron.
	 * 
	 * @return Kappaleen numero
	 */
	public int getSongID() {
		
		int song = 0;
		
		switch (discReader.getColorID()) 
		{
			case Color.YELLOW:
				song = 0;
				break;
		
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
			
			case Color.MAGENTA:
				song = 5;
				break;
				
			default:
				song = -1;
				break;
		}
		
		return song;
		
	}	
}
