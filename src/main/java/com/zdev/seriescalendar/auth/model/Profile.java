package com.zdev.seriescalendar.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "firstName",nullable = false)
    private String firstName;
    
    @Column(name = "lastName",nullable = false)
    private String lastName;
    
    @Column(name = "age",nullable = false)
    private int age;
    
    @Email
    @Column(name = "email",nullable = false, unique = true)
    private String email;
    
    @Column(name = "phone",nullable = false)
    private String phone;
    
    @Column(name = "is_admin",nullable = false)
    private boolean is_admin;
    
    @Column(name = "city",nullable = false)
    private String city;
    
    @Column(name = "country",nullable = false)
    private String country;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "FK_USERID", updatable = false, nullable = false)
    private CustomUser user;
    
    public Profile() {
    	
    }
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isIs_admin() {
		return is_admin;
	}

	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CustomUser getUser() {
		return user;
	}

	public void setUsername(CustomUser user) {
		this.user = user;
	}
    
    
    
    
    
    
}
