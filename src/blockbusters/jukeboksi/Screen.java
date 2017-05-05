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
	public void showPage(int page, String songName, String artistName, int creditCount) {

		Delay.msDelay(50);
		LCD.clear();
		switch (page) {
		case 1:
			LCD.drawString("Now playing:", 0, 1);
			LCD.drawString(songName, 0, 2);
			LCD.drawString(artistName, 0, 4);

			LCD.drawString("Credits: " + creditCount, 0, 7);
			break;

		case 2:
			LCD.drawString("Select song:", 0, 1);
			LCD.drawString(songName, 0, 2);
			LCD.drawString(artistName, 0, 4);

			LCD.drawString("Credits: " + creditCount, 0, 7);
			break;

		case 3:
			LCD.drawString("Enter", 0, 1);
			LCD.drawString("coin(s)", 0, 2);

			LCD.drawString("Credits: " + creditCount, 0, 7);
			break;

		}
	}
	public void showSaldo(int coinCount){
		LCD.drawString("Koneen saldo", 0, 1);
		LCD.drawString(coinCount + " kolikkoa", 0, 2);
		LCD.drawString("", 0, 3);
		if(coinCount > 5){
		LCD.drawString("Empty the bank!", 0, 6);
		}
	}

}
