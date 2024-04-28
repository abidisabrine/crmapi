package de.tekup.api.models;


import org.hibernate.annotations.Columns;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "accounts")
@Data
@AllArgsConstructor // contructeur contient tout les argumrnts 
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Length(min = 8, max = 50)
	private String fullname;
	
	private String address;
	
	@Email
	private String email;
	
	@NotBlank(message ="phone is required" )
	private String phone;
	
}
