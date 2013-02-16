package consumer;

import service.HouseService;

public class Consumer {

	HouseService house;

	public void start() {
		System.out.println();
		System.out.println("Words:" + house.words());
		System.out.println("Lord:" +house.currentLord());
	}
}
