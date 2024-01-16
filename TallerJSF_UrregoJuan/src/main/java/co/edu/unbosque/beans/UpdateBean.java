package co.edu.unbosque.beans;

import co.edu.unbosque.model.PlanetDTO;
import co.edu.unbosque.model.persistence.PlanetDAO;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class UpdateBean {

	private PlanetDAO pdao;
	private long selectedId;
	private String selectedName;
	private double selectedGravity;
	private int selectedTranslation;
	private double selectedDistance;
	
	public UpdateBean() {
		pdao=new PlanetDAO();
		selectedId=-1;
	}

	public PlanetDAO getPdao() {
		return pdao;
	}

	public void setPdao(PlanetDAO pdao) {
		this.pdao = pdao;
	}

	public long getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(long selectedId) {
		this.selectedId = selectedId;
	}
	
	public String getSelectedName() {
		return selectedName;
	}

	public void setSelectedName(String selectedName) {
		this.selectedName = selectedName;
	}

	public double getSelectedGravity() {
		return selectedGravity;
	}

	public void setSelectedGravity(double selectedGravity) {
		this.selectedGravity = selectedGravity;
	}

	public int getSelectedTranslation() {
		return selectedTranslation;
	}

	public void setSelectedTranslation(int selectedTranslation) {
		this.selectedTranslation = selectedTranslation;
	}

	public double getSelectedDistance() {
		return selectedDistance;
	}

	public void setSelectedDistance(double selectedDistance) {
		this.selectedDistance = selectedDistance;
	}

	public void savePlanet(long id) {
		selectedId=id;
		PlanetDTO planet=(PlanetDTO)pdao.findOne(id);
		selectedName=planet.getName();
		selectedGravity=planet.getGravity();
		selectedTranslation=planet.getTranslation();
		selectedDistance=planet.getDistanceToSun();
	}
	
	public void update() {
		if(selectedId!=-1) {
			pdao.update(selectedId, new PlanetDTO(selectedName, selectedGravity, selectedTranslation, selectedDistance));
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Planet successfully update."));
		}
	}
	
}
