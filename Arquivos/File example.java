package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Especifica o caminho do arquivo a ser lido
        File file = new File("in.txt");
        Scanner sc = null;

        try {
            // Inicializa o Scanner para ler o arquivo
            sc = new Scanner(file);
            // Lê o arquivo linha por linha
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (IOException e){
            // Trata possíveis exceções de IO
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            // Fecha o Scanner se ele foi inicializado
            if (sc != null) {
                sc.close();
            }
        }
    }
}
