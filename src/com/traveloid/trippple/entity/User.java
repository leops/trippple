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
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

import com.traveloid.trippple.util.TextUtils;

@Entity
@Table(name = "Users")
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
	private String password;
	private String salt = null;

	@ManyToMany
	@JoinTable(name = "Bags")
	private Collection<Trip> bag;

	@ManyToMany
	@JoinTable(name = "Orders")
	private Collection<Trip> ordered;

	@OneToMany(mappedBy = "")
	private Campus campus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getPassword() {
		return password;
	}

	private String encrypt(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.reset();

		byte[] binSalt;
		if(this.salt == null) {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			binSalt = new byte[8];
			random.nextBytes(binSalt);
			this.salt = TextUtils.bytesToHex(binSalt);
		} else {
			binSalt = TextUtils.hexToBytes(this.salt);
		}

		digest.update(binSalt);
		return TextUtils.bytesToHex(digest.digest(text.getBytes("UTF-8")));
	}

	public void setPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.password = encrypt(password);
	}

	public boolean comparePassword(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return this.password == encrypt(text);
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
