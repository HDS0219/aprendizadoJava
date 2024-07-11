package application;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria um Scanner para ler a entrada do usuário
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        // Lê o caminho da pasta inserido pelo usuário
        String strPath = sc.nextLine();

        // Cria um objeto File para o caminho fornecido
        File path = new File(strPath);

        // Lista os diretórios presentes no caminho fornecido
        File[] folders = path.listFiles(File::isDirectory);
        // Lista os arquivos presentes no caminho fornecido
        File[] files = path.listFiles(File::isFile);

        System.out.println("FOLDERS: ");
        // Imprime os nomes dos diretórios
        for (File folder : folders) {
            System.out.println(folder);
        }

        System.out.println("FILES: ");
        // Imprime os nomes dos arquivos
        for (File file : files) {
            System.out.println(file);
        }

        // Cria um novo diretório no caminho fornecido
        boolean success = new File(strPath + "\\subdir").mkdir();
        System.out.println("Directory created successfully: " + success);

        // Fecha o Scanner
        sc.close();
    }
}
