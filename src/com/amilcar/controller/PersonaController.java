package com.amilcar.controller;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amilcar.dao.IConnection;
import com.amilcar.dao.ITransacction;
import com.amilcar.modelo.Persona;

public final class PersonaController implements ITransacction {

	@Override
	public List<Persona> getPersonas() {

		List<Persona> lista = new ArrayList<Persona>();

		Connection con = new IConnection() {
		}.getConnection();

		if (con != null) {
			try {
				ResultSet rs;
				Statement st;
				st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM personas");

				Class person = Class.forName("com.amilcar.modelo.Persona");
				Object obj = person.newInstance();
				Field[] campos = person.getDeclaredFields();

				while (rs.next()) {
					Persona p = new Persona();

					for (Field f : campos) {
						Field c = p.getClass().getDeclaredField(f.getName());
						c.setAccessible(true);
						c.set(p, rs.getObject(f.getName()));
					}
					lista.add(p);
				}

			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException
					| SecurityException | SQLException e) {
				e.printStackTrace();
			}

		}
		return lista;

	}

	@Override
	public Persona getPersonaById(int id) {

		Connection con = null;
		Persona p = new Persona();

		try {
			con = new IConnection() {
			}.getConnection();

			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from personas where id = ?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			Class classPersona = Class.forName("com.amilcar.modelo.Persona");

			Field[] campos = p.getClass().getDeclaredFields();

			Object objPersona = classPersona.newInstance();

			// trabajamos con reflection para setear el objeto Persona
			while (rs.next()) {
				for (Field item : campos) {
					Field c = p.getClass().getDeclaredField(item.getName());
					c.setAccessible(true);
					c.set(p, rs.getObject(item.getName()));
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return p;

	}

}
