package org.aplicacao.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aplicacao.dto.EnderecoDto;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;

public class ApiService {
    public EnderecoDto getEndereco(String cep) throws IOException, InterruptedException { // parte responsável pela requisição
        EnderecoDto enderecoDto = new EnderecoDto();
        try { // criação da requisição completa da API e salvando no objeto enderecodto
            HttpClient client = HttpClient.newHttpClient(); // será utilizado aas classes de tipo http para consumir a api
            HttpRequest request = HttpRequest.newBuilder() // new builder é constructor da class HTTPrequest
                    .uri(URI.create("https://viacep.com.br/ws/"+ cep + "/json/")).build(); // responsavel por chamar o end http
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // envia a requisição que foi criada

            ObjectMapper mapper = new ObjectMapper(); // vai pegar e tranferir os dados retornados em json para um objeto java que será feito abaixo
            enderecoDto = mapper.readValue(response.body(), EnderecoDto.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return enderecoDto;
    }
}
