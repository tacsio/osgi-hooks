package consumer;

import lemma.HouseService;

public class Consumer {

	HouseService house;

	public void start() {
		System.out.println(house.lemma());
	}
}
