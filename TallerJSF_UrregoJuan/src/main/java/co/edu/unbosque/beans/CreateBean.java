package co.edu.unbosque.beans;

import co.edu.unbosque.model.PlanetDTO;
import co.edu.unbosque.model.persistence.PlanetDAO;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class CreateBean {
	
	private PlanetDAO pdao;
	private String pname;
	private double pgravity;
	private int ptranslation;
	private double pdistance;
	
	public CreateBean() {
		pdao=new PlanetDAO();
	}

	public PlanetDAO getPdao() {
		return pdao;
	}

	public void setPdao(PlanetDAO pdao) {
		this.pdao = pdao;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPgravity() {
		return pgravity;
	}

	public void setPgravity(double pgravity) {
		this.pgravity = pgravity;
	}

	public int getPtranslation() {
		return ptranslation;
	}

	public void setPtranslation(int ptranslation) {
		this.ptranslation = ptranslation;
	}

	public double getPdistance() {
		return pdistance;
	}

	public void setPdistance(double pdistance) {
		this.pdistance = pdistance;
	}
	
	public void save() {
		pdao.create(new PlanetDTO(pname, pgravity, ptranslation, pdistance));
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Planet successfully create."));
	}

}
