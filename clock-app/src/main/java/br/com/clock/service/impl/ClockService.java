package br.com.clock.service.impl;

import org.springframework.stereotype.Service;

import br.com.clock.model.HoursInformapation;

@Service
public class ClockService {

	
	private Double calcAngle(HoursInformapation hoursInformapation){
		
		Double angleHour 	= (hoursInformapation.getHour() * 30) + (hoursInformapation.getMinut() * 0.5);
		Double angleMinute	= (hoursInformapation.getMinut() * 6.0);
		
		Double angle = angleMinute - angleHour;
		
		
		if(angle < 0){
			angle = angle * (-1);
		}
		if(angle > 180 && angle < 360){
			angle = 360 - angle;
		}
		return angle;
	}
	
	public static void main(String[] args) {
		ClockService cs = new ClockService();
		HoursInformapation hi1 = new HoursInformapation();
		hi1.setId(1);
		hi1.setHour(3);
		hi1.setMinut(42);
		System.out.println(cs.calcAngle(hi1));
		
		HoursInformapation hi2 = new HoursInformapation();
		hi2.setId(1);
		hi2.setHour(2);
		hi2.setMinut(45);
		System.out.println(cs.calcAngle(hi2));
		
		HoursInformapation hi3 = new HoursInformapation();
		hi3.setId(1);
		hi3.setHour(3);
		hi3.setMinut(45);
		System.out.println(cs.calcAngle(hi3));
		
		HoursInformapation hi4 = new HoursInformapation();
		hi4.setId(1);
		hi4.setHour(2);
		hi4.setMinut(42);
		System.out.println(cs.calcAngle(hi4));
		
		HoursInformapation hi5 = new HoursInformapation();
		hi5.setId(1);
		hi5.setHour(3);
		hi5.setMinut(0);
		System.out.println(cs.calcAngle(hi5));
		
		HoursInformapation hi6 = new HoursInformapation();
		hi6.setId(1);
		hi6.setHour(3);
		hi6.setMinut(33);
		System.out.println(cs.calcAngle(hi6));
		
		HoursInformapation hi7 = new HoursInformapation();
		hi7.setId(1);
		hi7.setHour(12);
		hi7.setMinut(0);
		System.out.println(cs.calcAngle(hi7));
	}
}
