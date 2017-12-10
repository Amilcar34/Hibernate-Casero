package com.amilcar.modelo;

public class Persona {

	private int id;
	private String nombre;
	private String apellido;
	private double altura;
	private double peso;

	public Persona(int id, String nombre, String apellido, double altura, double peso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.altura = altura;
		this.peso = peso;
	}

	public Persona() {}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public double getAltura() {
		return altura;
	}

	public double getPeso() {
		return peso;
	}	
	
	
}
