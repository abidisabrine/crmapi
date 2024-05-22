package de.tekup.api.models;

import java.util.List;

import org.hibernate.annotations.Columns;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

	@Email
	private String email;

	@Length(min = 6, max = 50)
	private String fullname;
	private String username;
	

	@Length(min = 8, max = 200)
	private String password;

	@NotBlank(message = "phone is required")
	private String phone;
	// private List<RoleController> roles;
}
