package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import kodlamaio.hrms.core.entities.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name="staffs")

public class Staff extends User{
	
	@Column(name="first_name",nullable = false)
	@NotBlank
	@NotNull(message="required")
	private String firstName;
	
	@Column(name="last_name",nullable = false)
	@NotBlank
	@NotNull(message="required")
	private String lastName;
	
	@Column(name="nationality_id",nullable = false)
	@NotBlank
	@NotNull(message="required")
	private String nationalityId;

	public Staff(String email,String password, boolean status,String firstName, String lastName, String nationalityId) {
		super(email,password,status);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
	}
	
	
}