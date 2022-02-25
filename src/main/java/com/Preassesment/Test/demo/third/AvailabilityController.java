package com.Preassesment.Test.demo.third;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailabilityController {

	@Autowired
	AvailabilityDAO availabilityService;

	@PostMapping("/getAvailability")
	public ResponseEntity<ReqResPojo> findStoreAvailability(@RequestBody ReqResPojo request) {

		int availableQuantity = availabilityService.checkAvailability(request.getProductId());
		if (availableQuantity > 0) {
			request.setAvailability(availableQuantity);
			return new ResponseEntity<ReqResPojo>(request, HttpStatus.OK);
		} else {
			return new ResponseEntity<ReqResPojo>(HttpStatus.NO_CONTENT);
		}
	}

}