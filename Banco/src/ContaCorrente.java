import java.time.LocalDate;
import java.util.List;

public class ContaCorrente extends ContaBancaria {
    private double limiteSaqueDiario = 1000.0;

    public ContaCorrente(String titular) {
        super(titular);
    }

    @Override
    public void sacar(double valor) {
        double totalSacadoHoje = getTotalSacadoHoje();

        if (valor <= 0) {
            System.out.println("Valor inválido.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else if ((totalSacadoHoje + valor) > limiteSaqueDiario) {
            System.out.println("Limite diário de saque excedido.");
        } else {
            saldo -= valor;
            transacoes.add(new Transacao("SAQUE", valor));
            System.out.println("Saque realizado com sucesso.");
        }
    }

    private double getTotalSacadoHoje() {
        LocalDate hoje = LocalDate.now();
        double total = 0;
        for (Transacao t : transacoes) {
            if (t.toString().contains("SAQUE") && t.toString().contains(hoje.toString())) {
                total += Double.parseDouble(t.toString().split("R\\$ ")[1].replace(",", "."));
            }
        }
        return total;
    }
}
