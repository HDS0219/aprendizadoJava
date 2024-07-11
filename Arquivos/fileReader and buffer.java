package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Especifica o caminho do arquivo a ser lido
        String path = "in.txt";
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Inicializa FileReader e BufferedReader para ler o arquivo
            fr = new FileReader(path);
            br = new BufferedReader(fr);

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
        } finally {
            try {
                // Fecha BufferedReader se ele foi inicializado
                if (br != null) {
                    br.close();
                }
                // Fecha FileReader se ele foi inicializado
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
