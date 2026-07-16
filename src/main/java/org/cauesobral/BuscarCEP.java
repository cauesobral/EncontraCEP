package org.cauesobral;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscarCEP {
    public Endereco buscarEndereco(String cep){
        URI endereco = URI.create("viacep.com.br/"+cep+"/json/");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Endereço não encontrado para esse CEP.");
        }

        return new Gson().fromJson(response.body(), Endereco.class);
    }
}
