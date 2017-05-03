package blockbusters.jukeboksi;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;


public class Screen {

	private int credits;
	// private int page;

	public void showPage(int page) {

		int raha;
		
		Delay.msDelay(50);
		LCD.clear();
		switch (page) {
		case 1:
			LCD.drawString("Now playing:", 0, 1);
			LCD.drawString(JukeBoksi.songName, 0, 2);
			LCD.drawString(JukeBoksi.artistName, 0, 4);
			
			
			LCD.drawString("Credits: " + credits, 0, 7);
			break;


		case 9:
			// raha = CoinCounter.getCoins();
			LCD.drawString("Koneen saldo", 0, 1);
			LCD.drawString(" euroa", 0, 2);
			LCD.drawString("", 0, 3);

			LCD.drawString("Credits: " + credits, 0, 7);
			break;
		}
	}

	public void updateCredits() {
		// credits = CoinCounter.getCredits();

	}
}
