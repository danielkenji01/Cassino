package model;

public class Competidor {

	private int id;
	
	private int pontos;
	
	public Competidor(int id) {
		this.id = id;
		this.pontos = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public void pontuar() {
		pontos++;
	}
	
	public boolean venceu() {
		return pontos == 5;
	}

}