public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(String titular) {
        super(titular);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
            transacoes.add(new Transacao("SAQUE", valor));
            System.out.println("Saque realizado com sucesso.");
        }
    }
}
