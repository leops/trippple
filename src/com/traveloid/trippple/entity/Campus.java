package com.traveloid.trippple.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

@Entity
@Table(name="Campuses")
public class Campus implements Serializable, JSONAware {
	/**
	 * Necessaire pour Serializable
	 */
	private static final long serialVersionUID = 3779463447477547830L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toJSONString() {
		JSONObject obj = new JSONObject();
		
		obj.put("id", this.id);
		obj.put("name", this.name);

		return obj.toString();
	}

}
