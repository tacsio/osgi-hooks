package consumer;

import service.HouseService;

public class Consumer {

	HouseService house;

	public void start() {
		System.out.println(house.words());
		System.out.println(house.currentLord());
	}
}
