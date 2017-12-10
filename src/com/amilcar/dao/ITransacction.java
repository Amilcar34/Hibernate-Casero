/**
 * 
 */
package com.amilcar.dao;

import java.sql.SQLException;
import java.util.List;
import com.amilcar.modelo.Persona;


/**
 * @author Amilcar
 *
 */
public interface ITransacction extends IConnection{
	
	List<Persona> getPersonas();
	
	Persona getPersonaById(int id);
	
}
