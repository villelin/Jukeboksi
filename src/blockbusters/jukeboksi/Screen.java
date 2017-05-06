package blockbusters.jukeboksi;

import lejos.hardware.lcd.LCD;

/**
 * Screen-luokka hallitsee ainoana luokkana näytölle kirjoitettavaa tekstiä.
 * 
 * @author Joona Ikonen
 * @version 1.0
 */

public class Screen {

	/**
	 * Piirretään näytölle nyt soivan kappaleen tiedot.
	 * 
	 * @param artistName
	 * @param songName
	 */
	public void songPlaying(String artistName, String songName) {
		LCD.clear();
		LCD.drawString("Now playing:", 0, 1);
		LCD.drawString(songName, 0, 2);
		LCD.drawString(artistName, 0, 4);

	}

	/**
	 * Piirretään näytölle valittavan kappaleen tiedot.
	 * 
	 * @param artistName
	 * @param songName
	 */
	public void songSelect(String artistName, String songName) {
		LCD.clear();
		LCD.drawString("Select song:", 0, 1);
		LCD.drawString(songName, 0, 2);
		LCD.drawString(artistName, 0, 4);
	}

	/**
	 * Piirretään näytölle ilmoitus krediittien määrän ollessa 0.
	 */
	public void noCredits() {
		LCD.clear();
		LCD.drawString("Enter", 0, 1);
		LCD.drawString("coin(s)", 0, 2);

	}

	/**
	 * Piirretään näytölle tämänhetkinen krediittitilanne.
	 * 
	 * @param creditCount
	 */
	public void creditAmount(int creditCount) {

		LCD.drawString("Credits: " + creditCount, 0, 7);
	}

	/**
	 * Piirretään näytölle koneessa olevien kolikkojen määrä.
	 * 
	 * @param coinCount
	 */
	public void showSaldo(int coinCount) {
		LCD.clear();
		LCD.drawString("Koneen saldo", 0, 1);
		LCD.drawString(coinCount + " kolikkoa", 0, 2);
		LCD.drawString("", 0, 3);
		if (coinCount > 5) {
			LCD.drawString("Empty the bank!", 0, 6);
		}
	}

}
