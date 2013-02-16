package house;

import service.HouseService;

public class ArrynHouse implements HouseService{

	@Override
	public String words() {
		return "As High as Honor";
	}

	@Override
	public String currentLord() {
		return "Jon Arryn";
	}

}
