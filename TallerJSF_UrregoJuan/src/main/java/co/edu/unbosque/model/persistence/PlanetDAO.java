package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.PlanetDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PlanetDAO implements CRUDOperation{
	
	public EntityManagerFactory emf;
	public EntityManager em;
	
	public PlanetDAO() {
		emf = Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
	}
	
	public void open() {
		if(!emf.isOpen() || !em.isOpen()) {
			emf = Persistence.createEntityManagerFactory("default");
			em = emf.createEntityManager();
		}
	}

	@Override
	public void create(Object info) {
		open();
		try {
			em.getTransaction().begin();
			em.persist(info);
			em.getTransaction().commit();
		}catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			if(emf!=null)emf.close();
			if(em!=null)em.close();
		}
	}

	@Override
	public boolean update(long id, Object info) {
		open();
		try {
			em.getTransaction().begin();
			PlanetDTO selectedPlanet=em.find(PlanetDTO.class, id);
			PlanetDTO newData=(PlanetDTO)info;
			selectedPlanet.setName(newData.getName());
			selectedPlanet.setGravity(newData.getGravity());
			selectedPlanet.setTranslation(newData.getTranslation());
			selectedPlanet.setDistanceToSun(newData.getDistanceToSun());
			em.persist(selectedPlanet);
			em.getTransaction().commit();
			return true;
		}catch (Exception ex) {
			System.err.println(ex.getMessage());
		}finally {
			if(emf!=null)emf.close();
			if(em!=null)em.close();
		}
		return false;
	}	

	@Override
	public boolean delete(long id) {
		open();
		try {
			em.getTransaction().begin();
			em.remove(em.find(PlanetDTO.class, id));
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			if(emf!=null)emf.close();
			if(em!=null)em.close();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<PlanetDTO> findAll() {
		open();
		try {
			return (ArrayList<PlanetDTO>)em.createQuery("select p from PlanetDTO p").getResultList();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			if(emf!=null)emf.close();
			if(em!=null)em.close();
		}
		return new ArrayList<PlanetDTO>();
	}

	@Override
	public Object findOne(long id) {
		open();
		try {
			PlanetDTO selectedPlanet=em.find(PlanetDTO.class, id);
			return selectedPlanet;
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			if(emf!=null)emf.close();
			if(em!=null)em.close();
		}
		return null;
	}
	
	
}
