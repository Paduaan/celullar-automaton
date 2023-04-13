package br.com.doalti;

import java.util.Random;

public class GeracaoTerreno {
	public void gerarAgua(Matriz matriz) {		
		// Geração aleatória da água
		
		Random random = new Random();
		int tamanhoArea = random.nextInt(8);
		int lin = random.nextInt(matriz.getLinhas());
		int col = random.nextInt(matriz.getColunas());
		
		System.out.println("Tamanho da área gerada: " + tamanhoArea);

		if (matriz.getLinhas() >= tamanhoArea + lin && matriz.getColunas() >= tamanhoArea + col) {

			// defina as posições dentro do tamanho da área como água
			for (int i = lin; i < lin + tamanhoArea; i++) {
				for (int j = col; j < col + tamanhoArea; j++) {
					if(i > matriz.getLinhas() || j > matriz.getColunas()) {
						continue;
					}
					matriz.getValor(i, j).setEstado(Estado.AGUA);
				}
			}
		} else {
			System.out.println("Água gerada fora da área abrangida!");
		}
	}
}
