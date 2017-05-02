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
			LCD.drawString("I am very glad, as I'm", 0, 2);
			LCD.drawString("finally returning back home", 0, 3);
			LCD.drawString("Eduard Khil", 0, 4);

			LCD.drawString("Credits: " + credits, 0, 7);
			break;
		case 2:
			LCD.drawString("Now playing:", 0, 1);
			LCD.drawString("Epic Sax Guy", 0, 2);
			LCD.drawString("Sergey Stepanov", 0, 3);

			LCD.drawString("Credits: " + credits, 0, 7);
			break;
		case 3:
			LCD.drawString("Now playing:", 0, 1);
			LCD.drawString("The time is now", 0, 2);
			LCD.drawString("John Cena", 0, 3);

			LCD.drawString("Credits: " + credits, 0, 7);
			break;
		case 4:
			LCD.drawString("Now playing:", 0, 1);
			LCD.drawString("Korobeiniki", 0, 2);
			LCD.drawString("Russian Folk Song", 0, 3);

			LCD.drawString("Credits: " + credits, 0, 7);
			break;
		case 5:
			LCD.drawString("Now playing", 0, 1);
			LCD.drawString("Overworld", 0, 2);
			LCD.drawString("Legend of Zelda", 0, 3);

			LCD.drawString("Credits: " + credits, 0, 7);
			break;
		case 6:
			LCD.drawString("Now playing", 0, 1);
			LCD.drawString("", 0, 2);
			LCD.drawString("", 0, 3);

			LCD.drawString("Credits: " + credits, 0, 7);
			break;
		case 7:
			LCD.drawString("Now playing", 0, 1);
			LCD.drawString("", 0, 2);
			LCD.drawString("", 0, 3);

			LCD.drawString("Credits: " + credits, 0, 7);
			break;
		case 8:
			LCD.drawString("Now playing", 0, 1);
			LCD.drawString("", 0, 2);
			LCD.drawString("", 0, 3);

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
