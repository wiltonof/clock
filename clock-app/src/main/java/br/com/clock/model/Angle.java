package br.com.clock.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "angle")
@XmlAccessorType(XmlAccessType.NONE)
public class Angle {

	private Double angle;
	
	public Angle(HoursInformapation hoursInformapation) {
		this.angle = hoursInformapation.getAngle();		
	}

	public Double getAngle() {
		return angle;
	}

	public void setAngle(Double angle) {
		this.angle = angle;
	}
	
}
