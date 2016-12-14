package br.com.clock.dataprovider;

import java.util.ArrayList;
import java.util.List;

import br.com.clock.model.HoursInformapation;

public class ClockDataProvider {
	private static ClockDataProvider instance = null;
	private List<HoursInformapation> hoursInformapations = null;

	private ClockDataProvider() {
		hoursInformapations = new ArrayList<HoursInformapation>();
	}
	
	public static ClockDataProvider getInstance(){
		if(instance == null){
			instance = new ClockDataProvider();
		}
		
		return instance;
	}
	
	public void add(HoursInformapation hoursInformapation){
		hoursInformapations.add(hoursInformapation);
	}
	
	public HoursInformapation find(Integer hour, Integer minute){
		
		for( HoursInformapation hoursInformapation : hoursInformapations ){
			if(hoursInformapation.getHour() == hour && hoursInformapation.getMinute() == minute){
				return hoursInformapation;
			}			
		}
		
		return null;
	}
}
