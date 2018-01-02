package com.jatin.notify;

public class MagazineConsumer implements Runnable {

	Magazine magazine = new Magazine();

	public MagazineConsumer(Magazine commonMagazine) {
		this.magazine = commonMagazine;
	}

	@Override
	public void run() {

		for (;;) {

			magazine.recieveNew();

		}

	}

}
