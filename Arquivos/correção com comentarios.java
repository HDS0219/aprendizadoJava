package application;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Configura a localidade padrão para US, para garantir o formato de ponto decimal
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Lista para armazenar os produtos lidos do arquivo
        List<Product> list = new ArrayList<>();

        System.out.println("Enter File Path: ");
        // Lê o caminho do arquivo de entrada inserido pelo usuário
        String sourceFileStr = sc.nextLine();

        // Cria um objeto File para o arquivo de entrada
        File sourceFile = new File(sourceFileStr);
        // Obtém o diretório pai do arquivo de entrada
        String sourceFolderStr = sourceFile.getParent();

        // Cria um diretório "out" dentro do diretório pai do arquivo de entrada
        boolean success = new File(sourceFolderStr + "\\out").mkdir();

        // Caminho completo do arquivo de saída "summary.csv" dentro do diretório "out"
        String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

        // Bloco try-with-resources para garantir que BufferedReader seja fechado automaticamente
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
            // Lê a primeira linha do arquivo CSV
            String itemCsv = br.readLine();
            while (itemCsv != null) {
                // Divide a linha lida em campos separados por vírgula
                String[] fields = itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                // Adiciona um novo produto à lista
                list.add(new Product(name, price, quantity));

                // Lê a próxima linha do arquivo CSV
                itemCsv = br.readLine();
            }

            // Bloco try-with-resources para garantir que BufferedWriter seja fechado automaticamente
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
                // Escreve cada produto da lista no arquivo de saída
                for (Product item : list) {
                    bw.write(item.getName() + ", " + String.format("%.2f", item.total()));
                    bw.newLine();
                }
                System.out.println(targetFileStr + " CREATED!");

            } catch (IOException e) {
                // Trata possíveis exceções de IO ao escrever no arquivo de saída
                System.out.println("ERROR: " + e.getMessage());
            }

        } catch (IOException e) {
            // Trata possíveis exceções de IO ao ler o arquivo de entrada
            System.out.println("ERROR: " + e.getMessage());
        }

        // Fecha o Scanner
        sc.close();
    }
}
