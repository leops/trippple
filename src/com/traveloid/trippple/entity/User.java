package com.traveloid.trippple.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name="Users")
public class User implements Serializable {

	/**
	 * Necessaire pour Serializable
	 */
	private static final long serialVersionUID = 7320015751377606756L;
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String salt = null;

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

	public String getPassword() {
		return password;
	}
	
	private static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	private static byte[] hexToBytes(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	private String encrypt(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.reset();
		
		byte[] salt;
		if(this.salt == null) {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			salt = new byte[8];
			random.nextBytes(salt);
			this.salt = bytesToHex(salt);
		} else {
			salt = hexToBytes(this.salt);
		}
		
		digest.update(salt);
		return bytesToHex(digest.digest(password.getBytes("UTF-8")));
	}

	public void setPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.password = encrypt(password);
	}
	
	public Boolean comparePassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return this.password == encrypt(password);
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
