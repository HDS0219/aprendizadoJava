package entities;

public class Account {

    private Integer number; // Número da conta
    private String holder; // Nome do titular da conta
    private Double balance; // Saldo da conta
    private Double withdrawLimit; // Limite de saque da conta

    // Construtor padrão
    public Account() {
    }

    // Construtor com argumentos para inicializar os atributos
    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    // Métodos getters e setters para acessar e modificar os atributos da conta
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    // Método para realizar um depósito na conta
    public void deposit(Double amount) {
        balance += amount;
    }

    // Método para realizar um saque na conta
    public void withdraw(Double amount) {
        balance -= amount;
    }
}
