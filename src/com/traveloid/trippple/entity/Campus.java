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
@Table(name = "Campuses")
public class Campus implements Serializable, JSONAware {
	/**
	 * Necessaire pour Serializable
	 */
	private static final long serialVersionUID = 3779463447477547830L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private double x;
	private double y;

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public double getX() {
		return x;
	}

	public void setX(final double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(final double y) {
		this.y = y;
	}

	@Override
	@SuppressWarnings({
			"unchecked", "boxing"
	})
	public String toJSONString() {
		final JSONObject obj = new JSONObject();

		obj.put("id", id);
		obj.put("name", name);
		obj.put("x", x);
		obj.put("y", y);

		return obj.toString();
	}

}
