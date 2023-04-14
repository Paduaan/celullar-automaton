package br.com.doalti;

import java.util.ArrayList;
import java.util.Arrays;

public class Direcao {
	private static final int[] NOROESTE = {-1, -1};
	private static final int[] NORTE = {-1, 0};
	private static final int[] NORDESTE = {-1, 1};
	private static final int[] LESTE = {0, 1};
	private static final int[] SUDESTE = {1, 1};
	private static final int[] SUL = {1, 0};
	private static final int[] SUDOESTE = {1, -1};
	private static final int[] OESTE = {0, -1};
	public static ArrayList<int[]> listaDirecoes = 
			new ArrayList<>(Arrays.asList(NOROESTE, NORTE, NORDESTE, LESTE, SUDESTE, SUL, SUDOESTE, OESTE));
	public static final int[] direcaoVento = NOROESTE;
}