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
	@JoinColumn(name="roleid", insertable=false, updatable=false)
	private Role role;
	private Integer roleid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date hireDate;
}
