package application;

import entities.Account;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Configura a localidade padrão para os Estados Unidos para garantir o uso do ponto como separador decimal
        Locale.setDefault(Locale.US);
        // Cria um objeto Scanner para leitura de dados do usuário
        Scanner sc = new Scanner(System.in);

        try {
            // Solicita e lê os dados da conta
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt(); // Lê o número da conta
            System.out.print("Holder: ");
            String holder = sc.next(); // Lê o nome do titular da conta
            sc.nextLine(); // Consome a linha pendente
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble(); // Lê o saldo inicial da conta
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble(); // Lê o limite de saque da conta

            // Cria uma nova instância da classe Account com os dados fornecidos
            Account acc = new Account(number, holder, balance, withdrawLimit);

            // Solicita e lê o valor para saque
            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();

            // Verifica se o valor do saque ultrapassa o limite de saque
            if (amount > acc.getWithdrawLimit()) {
                System.out.println("Withdraw error: The amount exceeds withdraw limit");
                // Verifica se há saldo suficiente para o saque
            } else if (amount > acc.getBalance()) {
                System.out.println("Withdraw error: Not enough balance");
            } else {
                // Realiza o saque e imprime o novo saldo
                acc.withdraw(amount);
                System.out.printf("New balance: %.2f%n", acc.getBalance());
            }

        } catch (InputMismatchException e) {
            // Captura exceções de formato incorreto de entrada
            System.out.println("Invalid expression!");
        } catch (RuntimeException e) {
            // Captura exceções inesperadas em tempo de execução
            System.out.println("Unexpected error");
        }
        // Fecha o objeto Scanner
        sc.close();
    }
}
