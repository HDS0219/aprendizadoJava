package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Array de strings a serem escritas no arquivo
        String[] lines = new String[]{
                "Good morning", "Good afternoon", "Good night"
        };

        // Especifica o caminho do arquivo de saída
        String path = "D:\\programação\\JAVA2\\AULAS\\Aula4\\out.txt";

        // Bloco try-with-resources para garantir que BufferedWriter seja fechado automaticamente
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            // Escreve cada linha no arquivo
            for (String line : lines) {
                bw.write(line);
                // Adiciona uma nova linha após cada linha escrita
                bw.newLine();
            }
        } catch (IOException e) {
            // Trata possíveis exceções de IO
            e.printStackTrace();
        }
    }
}
