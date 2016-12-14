package br.com.clock.service;

import br.com.clock.model.HoursInformapation;

public interface IClockService {
	
	public HoursInformapation clock(Integer hour, Integer minute);

}
