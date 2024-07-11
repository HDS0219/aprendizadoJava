package application;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria um Scanner para ler a entrada do usuário
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a file path: ");
        // Lê o caminho do arquivo inserido pelo usuário
        String strPath = sc.nextLine();

        // Cria um objeto File para o caminho fornecido
        File path = new File(strPath);

        // Imprime o nome do arquivo
        System.out.println("getName: " + path.getName());
        // Imprime o diretório pai do arquivo
        System.out.println("getParent: " + path.getParent());
        // Imprime o caminho completo do arquivo
        System.out.println("getPath: " + path.getPath());

        // Fecha o Scanner
        sc.close();
    }
}
