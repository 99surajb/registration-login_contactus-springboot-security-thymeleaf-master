package com.example.registrationlogindemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="contactus")
public class Contactus
{
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	/*
	 * @Column(nullable=true, unique=false) private String firstName;
	 * 
	 * @Column(nullable=true, unique=false) private String lastName;
	 */
    @Column(nullable=true)
    private String name;

    @Column(nullable=true, unique=false)
    private String email;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="Message")
    private String Message;

	@Column(nullable=true, unique=false)
	private String firstName;

	@Column(nullable=true, unique=false)
	private String lastName;

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

	
}
