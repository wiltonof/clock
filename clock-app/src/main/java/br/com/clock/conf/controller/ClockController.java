package br.com.clock.conf.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.clock.conf.ApiController;

@RestController
public class ClockController extends ApiController {

	@RequestMapping(value = CLOCK_ENDPOINT, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public String clock( @PathVariable String hour,@PathVariable String minute ){

		System.out.println(hour);
		System.out.println(minute);
		
		return "{angle:90}";
	}
}
