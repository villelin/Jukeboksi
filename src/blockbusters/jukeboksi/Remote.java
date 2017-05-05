package blockbusters.jukeboksi;

import lejos.hardware.Button;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

/**
 * 
 * @author Joona Ikonen
 *
 */

public class Remote extends Thread {

	private EV3IRSensor infraredSensor;
	private int remoteCommand = 0;
	private int remoteDrive = 0;
	private int remotelast = 0;

	public Remote(EV3IRSensor sensor) {
		this.infraredSensor = sensor;
	}

	/**
	 * Palauttaa tämänhetkisen painalluksen kaukosäätimeltä tai näppäimistöltä
	 * @return Palauttaa tämänhetkisen painalluksen
	 */
	public int getRemoteCommand() {

		return remotelast;
	}

	/**
	 * Kuuntelee jatkuvasti kaukosäätimen kanavia 1 ja 4 sekä näppäimistöä.
	 * Päivittää muuttujan remotelast arvoa painalluksen mukaan.
	 */
	public void run() {
		while (true) {
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
			remoteCommand = infraredSensor.getRemoteCommand(0);
			remoteDrive = infraredSensor.getRemoteCommand(3);

			if (remoteCommand != 0) {
				switch (remoteCommand) {
				case 1: // leftTop
					remotelast = 1;
					break;
				case 2: // leftBottom
					remotelast = 2;
					break;
				case 3: // rightTop
					remotelast = 3;
					break;
				case 4: // rightBottom
					remotelast = 4;
					break;
				default:
					remotelast = 0;
					break;
				}
			} else if (remoteDrive != 0) {
				switch (remoteDrive) {
				case 1: // leftTop
					remotelast = 9;
					break;
				case 2: // leftBottom
					remotelast = 10;
					break;
				case 3: // rightTop
					remotelast = 11;
					break;
				case 4: // rightBottom
					remotelast = 12;
					break;
				case 5: // topLeft + topRight
					remotelast = 13;
					break;
				case 8: // bottomLeft + bottomRight
					remotelast = 14;
				default:
					remotelast = 0;
					break;
				}
			} else {
				switch (Button.getButtons()) {
				case 0:
					remotelast = 0;
					break;
				case Button.ID_LEFT:

					remotelast = 5;
					break;
				case Button.ID_RIGHT:
					remotelast = 6;
					break;
				case Button.ID_DOWN:
					remotelast = 2;
					break;
				case Button.ID_UP:
					remotelast = 1;
					break;
				case Button.ID_ENTER:
					remotelast = 7;
					break;
				case Button.ID_ESCAPE:
					remotelast = 8;
					break;
				}

			}
		}

	}
}
