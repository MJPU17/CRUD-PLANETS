package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface CRUDOperation {
	
	public void create(Object info);
	public boolean update(long id, Object info);
	public boolean delete(long id);
	public ArrayList<?> findAll();
	public Object findOne(long id);
	

}
