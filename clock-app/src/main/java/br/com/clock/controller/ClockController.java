package br.com.clock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.clock.conf.ApiController;
import br.com.clock.model.Angle;
import br.com.clock.service.IClockService;

@RestController
public class ClockController extends ApiController {
	
	@Autowired
	private IClockService  clockService;

	@RequestMapping(value = CLOCK_ENDPOINT, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Angle> clock( @PathVariable String hour,@PathVariable String minute ){

		Angle angle = new Angle(clockService.clock(Integer.parseInt(hour), Integer.parseInt(minute)));
	
		if(angle != null){
			return new ResponseEntity<Angle>(angle, HttpStatus.OK);
		}else{
			return new ResponseEntity<Angle>(angle, HttpStatus.FAILED_DEPENDENCY);
		}
	}
}
