package blockbusters.jukeboksi;
	
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.utility.Delay;

/**
 * CoinCounter k�ytt�� v�risensoria havaitsemaan kolikon pudotuksen.
 * Luokka pit�� kirjaa k�ytett�vist� kolikoista (krediiteist�), sek� sy�tetyiden kolikoiden m��r�st�.
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
	 * Palauttaa sy�tettyjen kolikoiden m��r�n.
	 * 
	 * @return Kolikoiden m��r�
	 */
	public int getCoins () {
		
		return coins;
		
	}
	
	/**
	 * Palauttaa krediittien m��r�n.
	 * 
	 * @return Krediittien m��r�
	 */
	public int getCredits() {

		return credits;
		
	}
	
	/**
	 * K�ytt�� yhden krediitin, jos k�yt�ss� olevien krediittien m��r� on yli nolla.
	 * 
	 * @return true jos krediittej� oli k�ytett�viss�, muuten false
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
				sleep (50);
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