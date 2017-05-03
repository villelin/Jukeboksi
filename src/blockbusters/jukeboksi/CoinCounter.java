package blockbusters.jukeboksi;

<<<<<<< HEAD
=======
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
>>>>>>> 3d791d55c86612faeef37033e776196b17998de4

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
	
	public void run() {
		
		while (true)
			
			
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

