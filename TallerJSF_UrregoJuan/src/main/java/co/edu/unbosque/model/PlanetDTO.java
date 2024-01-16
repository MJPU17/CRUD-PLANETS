package co.edu.unbosque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planet")
public class PlanetDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "planetname",nullable = false)
	private String name;
	@Column(name = "gravity",nullable = false)
	private double gravity;
	@Column(name = "translation",nullable = false)
	private int translation;
	@Column(name = "distancetosun",nullable = false)
	private double distanceToSun;
	
	public PlanetDTO() {}

	public PlanetDTO(String name, double gravity, int translation,double distanceToSun) {
		this.name = name;
		this.gravity = gravity;
		this.translation = translation;
		this.distanceToSun= distanceToSun;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	public int getTranslation() {
		return translation;
	}

	public void setTranslation(int translation) {
		this.translation = translation;
	}
	
	public double getDistanceToSun() {
		return distanceToSun;
	}
	
	public void setDistanceToSun(double distanceToSun) {
		this.distanceToSun = distanceToSun;
	}
	
}
