package co.edu.unbosque.beans;

import java.util.ArrayList;

import co.edu.unbosque.model.PlanetDTO;
import co.edu.unbosque.model.persistence.PlanetDAO;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;

@ManagedBean
@RequestScoped
public class PlanetBean {
	
	private PlanetDAO pdao;
	private ArrayList<PlanetDTO> planets;
	
	public PlanetBean() {
		pdao=new PlanetDAO();
		planets=pdao.findAll();
	}
	public ArrayList<PlanetDTO> getPlanets() {
		return planets;
	}

	public void setPlanets(ArrayList<PlanetDTO> planets) {
		this.planets = planets;
	}

}
