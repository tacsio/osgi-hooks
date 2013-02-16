package house;

import service.HouseService;

public class LannisterHouse implements HouseService {

	@Override
	public String words() {
		return "Hear Me Roar!";
	}

	@Override
	public String currentLord() {
		return "Tywin Lannister";
	}

}
