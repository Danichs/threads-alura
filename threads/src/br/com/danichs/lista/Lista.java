package br.com.danichs.lista;

public class Lista {

    private String[] elementos = new String[1000];
    private int indice = 0;

    public synchronized void adicionaElementos(String elemento) {
            this.elementos[indice] = elemento;
            this.indice++;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (this.indice == this.elementos.length) {
                this.notify();
            }
    } 

    public int tamanho() {
        return this.elementos.length;
    }

    public String pegaElemento(int posicao) {
        return this.elementos[posicao];
    }

    public boolean estaCheia() {
        return this.indice == this.tamanho();
    }

}
