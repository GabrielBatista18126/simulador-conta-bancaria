import java.util.ArrayList;
import java.util.List;

public abstract class ContaBancaria {
    protected String titular;
    protected double saldo;
    protected List<Transacao> transacoes;

    public ContaBancaria(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
        this.transacoes = new ArrayList<>();
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            transacoes.add(new Transacao("DEPÓSITO", valor));
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public abstract void sacar(double valor);

    public void exibirExtrato() {
        System.out.println("\nExtrato de " + titular + ":");
        for (Transacao t : transacoes) {
            System.out.println(t);
        }
        System.out.println("Saldo atual: R$ " + String.format("%.2f", saldo));
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
