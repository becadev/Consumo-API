package org.aplicacao;
import org.aplicacao.Service.ApiService;
import org.aplicacao.dto.EnderecoDto;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ApiService apiService = new ApiService();
        try {
            EnderecoDto enderecoDto = apiService.getEndereco("59149363");
            System.out.println(enderecoDto.getBairro());
        } catch(IOException e){
            throw new RuntimeException(e);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}