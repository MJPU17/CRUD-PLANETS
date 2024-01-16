package co.edu.unbosque.beans;

import co.edu.unbosque.model.persistence.PlanetDAO;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class DeletedBean {
	
	private PlanetDAO pdao;
	private long selectedId;
	
	public DeletedBean() {
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
	
	public void saveId(long id) {
		selectedId=id;
	}

	public void delete() {
		if(selectedId!=-1) {
			pdao.delete(selectedId);
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Planet successfully delete."));
			selectedId=-1;
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("The planet has already been eliminated. Press the exit button."));
		}
	}
	
}
