package house;

import service.HouseService;

public class StarkHouse implements HouseService {

	@Override
	public String words() {
		return "Winter is Coming!";
	}

	@Override
	public String currentLord() {
		return "Ned Stark";
	}

}
