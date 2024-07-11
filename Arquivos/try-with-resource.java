package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Especifica o caminho do arquivo a ser lido
        String path = "in.txt";

        // Bloco try-with-resources para garantir que recursos sejam fechados automaticamente
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            // Lê a primeira linha do arquivo
            String line = br.readLine();

            // Continua lendo até o final do arquivo
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            // Trata possíveis exceções de IO
            System.out.println("Error: " + e.getMessage());
        }
    }
}
