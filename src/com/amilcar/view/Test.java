package com.amilcar.view;

import java.util.ArrayList;
import java.util.Iterator;

import com.amilcar.controller.PersonaController;
import com.amilcar.modelo.Persona;

public final class Test {

	public static void main(String[] args) {

		
		ArrayList<Persona> lista = (ArrayList<Persona>) new PersonaController().getPersonas();
		
		Iterator<Persona> it = lista.iterator();
		
		while(it.hasNext()){
			Persona per = (Persona)it.next();
			System.out.println(per.getNombre());
		}
		
		System.out.println();
		System.out.println(new PersonaController().getPersonaById(1).getNombre());
		System.out.println(new PersonaController().getPersonaById(4).getNombre());

		
		
	}

}
