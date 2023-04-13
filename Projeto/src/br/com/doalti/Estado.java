package br.com.doalti;

public enum Estado {
    VEGETACAO(0),
    FOGO(1),
    CINZAS(2),
	AGUA(3);

    private final int valor;

    Estado(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}