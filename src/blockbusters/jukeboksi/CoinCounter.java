package blockbusters.jukeboksi;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

public class CoinCounter extends Thread {
	
	int coins = 0;
	int credits = 0;
	private EV3ColorSensor coinReader;
	
	public CoinCounter (EV3ColorSensor coinreader) {
		this.coinReader = coinreader;
	}
	
	
	public int getCoins () {
		
		return coins;
		
	}
	
	public int getCredits() {

		return credits;
		
	}
	
	 public boolean useCredits() {
		
		if (credits > 0) {
			credits = credits - 1;
			return true;
		} else {
			return false;
		}
		
	}
	ejfqdbfdj
	public void run() {
		
		while (true) {
			
			int lul = coinReader.getColorID();
			if (lul != 1) {
				credits++;
				coins++;
			} 
			
		}
		
	}

}