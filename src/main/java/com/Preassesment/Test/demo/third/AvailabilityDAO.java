package com.Preassesment.Test.demo.third;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AvailabilityDAO {
	private static List<Supply> supplyList = new ArrayList<>();
	private static List<Demand> demandList = new ArrayList<>();

	static {
		supplyList.add(new Supply("Product1", 10.0));
		supplyList.add(new Supply("Product2", 5.0));
	}
	static {
		demandList.add(new Demand("Product1", 2.0));
		demandList.add(new Demand("Product2", 5.0));
	}

	public int checkAvailability(String productId) {

		/*
		 * Default value of availability is set to zero in case if request contains any
		 * other product Id which is not there is static lists of Supply or demand In
		 * this case API will return 204 No Content. Further this can improved to give a
		 * response of Product not found but that is not the ask of this particular
		 * question
		 */

		int availability = 0;

		Supply supplyInstance = supplyList.stream().filter(supply -> productId.equals(supply.getProductId())).findAny()
				.orElse(null);
		Demand demandInstance = demandList.stream().filter(demand -> productId.equals(demand.getProductId())).findAny()
				.orElse(null);

		if (supplyInstance != null && demandInstance != null)
			availability = (int) (supplyInstance.getQuantity() - demandInstance.getQuantity());
		return availability;

	}

}
