package com.traveloid.trippple.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

@Entity
@Table(name="Trips")
public class Trip implements Serializable, JSONAware {

	/**
	 * Necessaire pour Serializable
	 */
	private static final long serialVersionUID = -2295692331115445380L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@ManyToOne
    @JoinColumn(name="origin_id")
	private Campus origin;
	
	@ManyToOne
    @JoinColumn(name="destination_id")
	private Campus destination;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Campus getOrigin() {
		return origin;
	}

	public void setOrigin(Campus origin) {
		this.origin = origin;
	}

	public Campus getDestination() {
		return destination;
	}

	public void setDestination(Campus destination) {
		this.destination = destination;
	}

	@Override
	public String toJSONString() {
		JSONObject obj = new JSONObject();
		
		obj.put("id", this.id);
		obj.put("origin", this.origin);
		obj.put("destination", this.destination);

		return obj.toString();
	}

}
