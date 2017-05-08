package blockbusters.jukeboksi;
	
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.utility.Delay;

/**
 * CoinCounter käyttää värisensoria havaitsemaan kolikon pudotuksen.
 * Luokka pitää kirjaa käytettävistä kolikoista (krediiteistä), sekä syötettyiden kolikoiden määrästä.
 * 
 * @author Jonne Leinonen
 * @version 1.0
 *
 */

public class CoinCounter extends Thread {
	
	int coins = 0;
	int credits = 0;
	private EV3ColorSensor coinReader;
	
	public CoinCounter (EV3ColorSensor coinreader) {
		this.coinReader = coinreader;
	}
	
	/**
	 * Palauttaa syötettyjen kolikoiden määrän.
	 * 
	 * @return Kolikoiden määrä
	 */
	public int getCoins () {
		
		return coins;
		
	}
	
	/**
	 * Palauttaa krediittien määrän.
	 * 
	 * @return Krediittien määrä
	 */
	public int getCredits() {

		return credits;
		
	}
	
	/**
	 * Käyttää yhden krediitin, jos käytössä olevien krediittien määrä on yli nolla.
	 * 
	 * @return true jos krediittejä oli käytettävissä, muuten false
	 */
	 public boolean useCredits() {
		
		if (credits > 0) {
			credits = credits - 1;
			return true;
		} else {
			return false;
		}
		
	}

	public void run() {
		
		while (true) {
			
			try {
				sleep (25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
			int lul = coinReader.getColorID();
			if (lul != Color.GREEN) {
				credits++;
				coins++;
				Delay.msDelay(400);
			} 
			
		}
		
	}

}