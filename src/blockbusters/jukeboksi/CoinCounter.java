package blockbusters.jukeboksi;

import java.awt.Color;

public class CoinCounter extends Thread {
	
	int coins = 0;
	int credits = 0;
	private EV3ColorSensor coinReader;
	
	public CoinCounter (EV3ColorSensor coinreader) {
		this.coinReader = coinreader;
	}
	
	getCoins int () {
		
		return coins;
		
	}
	
	getCredits int () {

		return credits;
		
	}
	
	useCredits boolean () {
		
		if (credits > 0) {
			credits = credits - 1;
			return true;
		} else {
			return false;
		}
		
	}
	
	run() {
		
		while (true){
			
			if (!coinReader = Color.GREEN) {
				coins++;
				credits++;
			}
			sleep 50;
		}
		
	}
}
