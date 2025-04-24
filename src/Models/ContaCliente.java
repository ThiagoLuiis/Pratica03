package Models;

public class ContaCliente {
    private int id;
    private Cliente cliente;
    private double saldo = 0.0;

    public ContaCliente(int id, Cliente cliente, double saldo) {
        this.id = id;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public ContaCliente(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public ContaCliente(int id) {
        this.id = id;
        this.cliente = null;
        this.saldo = 0.0;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        String clienteInfo = cliente != null ? cliente.getNome() + "(" + cliente.getId() + ")" : "sem cliente";
        return clienteInfo + " saldo=R$" + String.format("%.2f", saldo);
    }

    public double addDeposito(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + String.format("%.2f", valor) + " realizado. Novo saldo: R$" + String.format("%.2f", saldo));
        return saldo;
    }

    public double subSaldo(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Retirada de R$" + String.format("%.2f", valor) + " realizada. Novo saldo: R$" + String.format("%.2f", saldo));
        } else {
            System.out.println("Saldo insuficiente. Saldo atual: R$" + String.format("%.2f", saldo) + ", Tentativa de retirada: R$" + String.format("%.2f", valor));
        }
        return saldo;
    }
}