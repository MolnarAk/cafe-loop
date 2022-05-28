package hu.ma.cfl.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
	
	// CRUD
	
	// Create
	// Read
	// Update
	// Delete
	
	T create(T entity);
	
	Optional<T> findById(int id);
	
	List<T> findAll(); // TODO mi van akkor, ha rengeteg entitást olvasnánk be?
	
	T update(T entity); // TODO PCL
	
	void deleteById(int id); // Biztosan mindenre meg szeretnénk engedni a törlést? Virtuális törlés
	
}
