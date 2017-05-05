package blockbusters.jukeboksi;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

/**
 * 
 * @author Joona Ikonen
 *
 */

public class Screen {

	/**Piirretään näytölle oikea info
	 * 
	 * @param page
	 */
	public void songPlaying(String artistName, String songName){
		LCD.clear();
		LCD.drawString("Now playing:", 0, 1);
		LCD.drawString(songName, 0, 2);
		LCD.drawString(artistName, 0, 4);
		
	}
	public void songSelect(String artistName, String songName){
		LCD.clear();
		LCD.drawString("Select song:", 0, 1);
		LCD.drawString(songName, 0, 2);
		LCD.drawString(artistName, 0, 4);
	}
	public void noCredits(){
		LCD.clear();
		LCD.drawString("Enter", 0, 1);
		LCD.drawString("coin(s)", 0, 2);
		
	}
	public void creditAmount(int creditCount){
		
		LCD.drawString("Credits: " + creditCount, 0, 7);
	}
	
	
	public void showSaldo(int coinCount){
		LCD.clear();
		LCD.drawString("Koneen saldo", 0, 1);
		LCD.drawString(coinCount + " kolikkoa", 0, 2);
		LCD.drawString("", 0, 3);
		if(coinCount > 5){
		LCD.drawString("Empty the bank!", 0, 6);
		}
	}

}
