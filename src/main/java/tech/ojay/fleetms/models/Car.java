package tech.ojay.fleetms.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Car {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	private String name;
	@ManyToOne
	@JoinColumn(name="cartypeid", insertable=false, updatable=false)
	private CarType carType;
	private Integer cartypeid;	
	private String carNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date acquisitionDate;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="carbrandid", insertable=false, updatable=false)
	private CarBrand carBrand;
	private Integer carbrandid;
	private String power;
	private String fuelCapacity;
	
	@ManyToOne
	@JoinColumn(name="carstatusid", insertable=false, updatable=false)
	private CarStatus carStatus;
	private Integer carstatusid;	
	
	private String netWeight;

	@ManyToOne
	@JoinColumn(name="personnelid", insertable=false, updatable=false)
	private Personnel inCharge;
	private Integer personnelid;
	
	@ManyToOne
	@JoinColumn(name="carmodelid", insertable=false, updatable=false)
	private CarModel carModel;	
	private Integer carmodelid;

	@ManyToOne
	@JoinColumn(name="locationid", insertable=false, updatable=false)	
	private Location currentLocation;
	private Integer locationid;
	private String remarks;	
}
