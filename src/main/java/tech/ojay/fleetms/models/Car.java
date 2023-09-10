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
	private String energySource;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CarType getCarType() {
		return carType;
	}
	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	public Integer getCartypeid() {
		return cartypeid;
	}
	public void setCartypeid(Integer cartypeid) {
		this.cartypeid = cartypeid;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Date getAcquisitionDate() {
		return acquisitionDate;
	}
	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CarBrand getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}
	public Integer getCarbrandid() {
		return carbrandid;
	}
	public void setCarbrandid(Integer carbrandid) {
		this.carbrandid = carbrandid;
	}
	public String getEnergySource() {
		return energySource;
	}
	public void setEnergySource(String energySource) {
		this.energySource = energySource;
	}
	public String getFuelCapacity() {
		return fuelCapacity;
	}
	public void setFuelCapacity(String fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}
	public CarStatus getCarStatus() {
		return carStatus;
	}
	public void setCarStatus(CarStatus carStatus) {
		this.carStatus = carStatus;
	}
	public Integer getCarstatusid() {
		return carstatusid;
	}
	public void setCarstatusid(Integer carstatusid) {
		this.carstatusid = carstatusid;
	}
	public String getNetWeight() {
		return netWeight;
	}
	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}
	public Personnel getInCharge() {
		return inCharge;
	}
	public void setInCharge(Personnel inCharge) {
		this.inCharge = inCharge;
	}
	public Integer getPersonnelid() {
		return personnelid;
	}
	public void setPersonnelid(Integer personnelid) {
		this.personnelid = personnelid;
	}
	public CarModel getCarModel() {
		return carModel;
	}
	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}
	public Integer getCarmodelid() {
		return carmodelid;
	}
	public void setCarmodelid(Integer carmodelid) {
		this.carmodelid = carmodelid;
	}
	public Location getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	public Integer getLocationid() {
		return locationid;
	}
	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
