package br.com.doalti;

public class Celula {
	
	public static final int stepFogo = 2;
	public static final int stepCinzas = 5;
	private int stepAtual = 1;
	private Estado estado;
	
	public int getStepAtual() {
		return stepAtual;
	}
	public void setStepAtual(int stepAtual) {
		this.stepAtual = stepAtual;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}