package br.com.clock.service.impl;

import org.springframework.stereotype.Service;

import br.com.clock.dataprovider.ClockDataProvider;
import br.com.clock.model.HoursInformapation;
import br.com.clock.service.IClockService;

@Service
public class ClockService implements IClockService {

	
	private Double calcAngle(HoursInformapation hoursInformapation){
		Double angleHour 	= (hoursInformapation.getHour() * 30) + (hoursInformapation.getMinute() * 0.5);
		Double angleMinute	= (hoursInformapation.getMinute() * 6.0);
		
		Double angle = angleMinute - angleHour;
			
		if(angle < 0){
			angle = angle * (-1);
		}
		if(angle > 180 && angle < 360){
			angle = 360 - angle;
		}
		return angle;
	}

	@Override
	public HoursInformapation clock(Integer hour, Integer minute) {
		
		if(validate(hour, minute)){			
			ClockDataProvider clockDataProvider = ClockDataProvider.getInstance();
			HoursInformapation hi = clockDataProvider.find(hour, minute);
			
			if(hour > 12){
				hour = hour - 12;
			}
			if( hi == null){
				hi = new HoursInformapation();
				hi.setHour(hour);
				hi.setMinute(minute);
				hi.setAngle(calcAngle(hi));
				clockDataProvider.add(hi);
			}
	
			return hi;
		}else{
			return null;
		}
	}
	
	private boolean validate(Integer hour, Integer minute){
		if(hour < 0 || hour > 23){
			return false;
		}else if(minute < 0 || minute > 59 ){
			return false;
		}else{
			return true;
		}
	}
}
