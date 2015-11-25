package com.traveloid.trippple.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Campus implements Serializable {

	/**
	 * Necessaire pour Serializable
	 */
	private static final long serialVersionUID = 3779463447477547830L;

	@Id
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
