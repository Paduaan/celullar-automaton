package br.com.doalti;

import java.util.Random;

public class Matriz {

	private int linhas;
	private int colunas;
	private Celula[][] matriz;

	public Matriz(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		matriz = new Celula[linhas][colunas];
		for (int i = 0; i < this.linhas; i++) {
			for (int j = 0; j < this.colunas; j++) {
				matriz[i][j] = new Celula();
				matriz[i][j].setEstado(Estado.VEGETACAO);
			}
		}
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public Celula getValor(int linha, int coluna) {
		return matriz[linha][coluna];
	}

	public void setValor(int linha, int coluna, Celula celula) {
		matriz[linha][coluna] = celula;
	}

	public void iniciaFogo() {
		Random rand = new Random();
		int l = rand.nextInt(linhas);
		int c = rand.nextInt(colunas);
		this.matriz[l][c].setEstado(Estado.FOGO);
	}

	public void imprimeMatriz() {
		int i, j;
		for (i = 0; i < this.linhas; i++) {
			for (j = 0; j < this.colunas; j++) {
				System.out.print(this.getValor(i, j).getEstado().getValor() + " ");
			}
			System.out.println();
		}
		try {
			Thread.sleep(500); // sleep for 500 milliseconds (0.5 seconds)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Matriz clone() {
		Matriz copia = new Matriz(this.linhas, this.colunas);
		for (int i = 0; i < this.linhas; i++) {
			for (int j = 0; j < this.colunas; j++) {
				copia.getValor(i, j).setEstado(this.getValor(i, j).getEstado());
				copia.getValor(i, j).setStepAtual(this.getValor(i, j).getStepAtual());
			}
		}
		return copia;
	}

	public int tamanhoMatriz() {
		return this.getLinhas() * this.getColunas();
	}
}
