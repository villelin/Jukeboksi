package blockbusters.jukeboksi;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;


public class Screen {


	public void showPage(int page) {


		
		Delay.msDelay(50);
		LCD.clear();
		switch (page) {
		case 1:
			LCD.drawString("Now playing:", 0, 1);
			LCD.drawString(JukeBoksi.songName, 0, 2);
			LCD.drawString(JukeBoksi.artistName, 0, 4);
			
			
			LCD.drawString("Credits: " + JukeBoksi.creditCount, 0, 7);
			break;
			
		case 2:
			LCD.drawString("Select song:", 0, 1);
			LCD.drawString(JukeBoksi.songName, 0, 2);
			LCD.drawString(JukeBoksi.artistName, 0, 4);
			
			
			LCD.drawString("Credits: " + JukeBoksi.creditCount, 0, 7);

		case 3:
			LCD.drawString("Enter", 0, 1);
			LCD.drawString("coin(s)", 0, 2);
			
			LCD.drawString("Credits: " + JukeBoksi.creditCount, 0, 7);

		case 9:
			// raha = CoinCounter.getCoins();
			LCD.drawString("Koneen saldo", 0, 1);
			LCD.drawString(JukeBoksi.coinCount + " kolikkoa", 0, 2);
			LCD.drawString("", 0, 3);

			LCD.drawString("Credits: " + JukeBoksi.creditCount, 0, 7);
			break;
		}
	}

}
