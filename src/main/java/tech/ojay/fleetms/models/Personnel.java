package tech.ojay.fleetms.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Personnel extends Person {
	@ManyToOne
	@JoinColumn(name="personneltypeid", insertable=false, updatable=false)
	private PersonnelType personnelType;
	private Integer personneltypeid;
	private String photo;
	private String username;
	
	@ManyToOne
	@JoinColumn(name="role_id", insertable=false, updatable=false)
	private Role role;
	private Long role_id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date hireDate;

	public PersonnelType getPersonnelType() {
		return personnelType;
	}

	public void setPersonnelType(PersonnelType personnelType) {
		this.personnelType = personnelType;
	}

	public Integer getPersonneltypeid() {
		return personneltypeid;
	}

	public void setPersonneltypeid(Integer personneltypeid) {
		this.personneltypeid = personneltypeid;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
}
