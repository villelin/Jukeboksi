package blockbusters.jukeboksi;

import lejos.hardware.Button;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

public class Remote extends Thread {

	private EV3IRSensor infraredSensor;
	private int remoteCommand = 0;
	private int remotelast = 0;

	public Remote(EV3IRSensor sensor) {
		this.infraredSensor = sensor;
	}

	public int getRemoteCommand() {

		return remotelast;
	}

	public void run() {
		while (true) {
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
			remoteCommand = infraredSensor.getRemoteCommand(0);

			if (remoteCommand != 0) {
				switch (remoteCommand) {
				case 1:
					remotelast = 1;
					break;
				case 2:
					remotelast = 2;
					break;
				case 3:
					remotelast = 3;
					break;
				case 4:
					remotelast = 4;
					break;
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
