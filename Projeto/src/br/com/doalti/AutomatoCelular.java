package br.com.doalti;

import java.util.Random;

public class AutomatoCelular {

	public static void main(String[] args) {
		Matriz matriz = new Matriz(20, 20); // matriz 10x10 para armazenar os estados das células
		Matriz novaMatriz = new Matriz(20, 20);

		Random rand = new Random();
		GeracaoTerreno gerTerreno = new GeracaoTerreno();

		// inicializa a matriz com valores aleatórios (0 ou 1)
		matriz.iniciaFogo();
		gerTerreno.gerarAgua(matriz);
		novaMatriz = matriz.clone();

		// executa 10 gerações do autômato celular
		for (int g = 0; g < 20; g++) {
			// exibe a matriz na tela
			System.out.println("Geração " + g + ":");
			matriz.imprimeMatriz();
			System.out.println();
			
			// calcula o estado das células na próxima geração
			for (int i = 0; i < matriz.getLinhas(); i++) {
				for (int j = 0; j < matriz.getColunas(); j++) {
					int vizinhos = 0;
					// trecho de código para validar os vizinhos
					for (int x = -1; x <= 1; x++) {
						for (int y = -1; y <= 1; y++) {
							if (x == 0 && y == 0) {
								continue;
							}
							int ii = i + x;
							int jj = j + y;
							// verifica se a celulas estão dentro da matriz
							if (ii < 0 || ii >= matriz.getLinhas() || jj < 0 || jj >= matriz.getColunas()) {
								continue;
							}
							// se o valor da celula central avaliada for 0 e tiver algum vizinho com fogo
							if (matriz.getValor(ii, jj).getEstado() == Estado.FOGO) {
								vizinhos = 1;
							}
						}
					}
					// compara se o estado atual da celula é fogo
					if (matriz.getValor(i, j).getEstado() == Estado.FOGO) {
						// se o stepAtual daquela celular for igual a variavel stepFogo que é 2
						if (matriz.getValor(i, j).getStepAtual() == Celula.stepFogo) {
							// se for fogo a 2 stepFogo, muda o estado para CINZAS e zera o stepAtual da
							// celula p/ 0
							novaMatriz.getValor(i, j).setEstado(Estado.CINZAS);
							novaMatriz.getValor(i, j).setStepAtual(1);
						} else {
							// senão mantém como FOGO e incrementa +1 ao stepAtual da celula
							novaMatriz.getValor(i, j).setEstado(Estado.FOGO);
							novaMatriz.getValor(i, j).setStepAtual(matriz.getValor(i, j).getStepAtual() + 1);
						}
						// se o estado atual é CINZAS
					} else if (matriz.getValor(i, j).getEstado() == Estado.CINZAS) {
						// se o stepAtual da celula for igual ao stepCinzas que é 5
						if (matriz.getValor(i, j).getStepAtual() == Celula.stepCinzas) {
							// calcula a probabilidade de voltar para vegetação
							int veg = rand.nextInt(800);
							if (veg == 1) {
								// muda o estado para VEGETACAO e zera o stepAtual da celula
								novaMatriz.getValor(i, j).setEstado(Estado.VEGETACAO);
								novaMatriz.getValor(i, j).setStepAtual(1);
							} else {
								// caso não acerta a probabilidade, aumenta se tiver vizinho com vegetação
								int vegetacao = 0;
								for (int x = -1; x <= 1; x++) {
									for (int y = -1; y <= 1; y++) {
										if (x == 0 && y == 0) {
											continue;
										}
										int ii = i + x;
										int jj = j + y;
										// verifica se a celulas estão dentro da matriz
										if (ii < 0 || ii >= matriz.getLinhas() || jj < 0 || jj >= matriz.getColunas()) {
											continue;
										}
										// se o valor da celula central avaliada for 0 e tiver algum vizinho com fogo
										if (matriz.getValor(ii, jj).getEstado() == Estado.VEGETACAO) {
											vegetacao++;
										}
									}
								}
								if (veg <= (vegetacao * 2)) {
									// muda o estado para VEGETACAO e zera o stepAtual da celula com maior prob
									novaMatriz.getValor(i, j).setEstado(Estado.VEGETACAO);
									novaMatriz.getValor(i, j).setStepAtual(1);
								}
							}
						} else {
							// senão mantém CINZAS e incrementa +1 ao stepAtual daquela celula
							novaMatriz.getValor(i, j).setEstado(Estado.CINZAS);
							novaMatriz.getValor(i, j).setStepAtual(matriz.getValor(i, j).getStepAtual() + 1);
						}
					}
					// se for VEGETACAO e a quantidade de vizinhos pegando FOGO for maior que 0
					if (matriz.getValor(i, j).getEstado() == Estado.VEGETACAO && vizinhos > 0) {
						// muda o estado da celula para FOGO e já deixa incrementado como 1 o stepAtual
						// da celula
						novaMatriz.getValor(i, j).setEstado(Estado.FOGO);
					}
				}
			}
			matriz = novaMatriz.clone();
		}
	}
}