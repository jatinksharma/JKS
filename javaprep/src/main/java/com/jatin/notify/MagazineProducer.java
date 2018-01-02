package com.jatin.notify;

public class MagazineProducer implements Runnable {

	Magazine magazine = new Magazine();

	public MagazineProducer(Magazine commonMagazine) {
		this.magazine = commonMagazine;
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {

			magazine.publishNew(i);

		}

	}

}
