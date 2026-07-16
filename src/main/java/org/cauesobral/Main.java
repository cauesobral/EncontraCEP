package org.cauesobral;

public class Main {
    static void main() {
        BuscarCEP buscador = new BuscarCEP();
        Endereco novoEndereco = buscador.buscarEndereco("11380170");
        System.out.println(novoEndereco);
    }
}
