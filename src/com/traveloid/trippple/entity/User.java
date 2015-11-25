package com.traveloid.trippple.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collection;

import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Entity;

@Entity
public class User implements Serializable {

	/**
	 * Necessaire pour Serializable
	 */
	private static final long serialVersionUID = 7320015751377606756L;
	
	@Id
	private long id;
	
	private String firstName;
	private String lastName;
	private String email;
	private byte[] password;
	private byte[] salt = null;

	@ManyToMany
	@JoinTable(name="Bags")
	private Collection<Trip> bag;
	
	@ManyToMany
	@JoinTable(name="Orders")
	private Collection<Trip> ordered;
	
	@OneToMany(mappedBy="")
	private Campus campus;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getPassword() {
		return password;
	}
	
	private byte[] genSalt() throws NoSuchAlgorithmException {
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[8];
        random.nextBytes(salt);
        return salt;
	}

	public void setPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.reset();
		
		if(this.salt == null) {
			this.salt = this.genSalt();
		}
		
		digest.update(this.salt);
		this.password = digest.digest(password.getBytes("UTF-8"));
	}

	public Collection<Trip> getBag() {
		return bag;
	}

	public void setBag(Collection<Trip> bag) {
		this.bag = bag;
	}
	
	public Collection<Trip> getOrdered() {
		return ordered;
	}

	public void setOrdered(Collection<Trip> ordered) {
		this.ordered = ordered;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

}
