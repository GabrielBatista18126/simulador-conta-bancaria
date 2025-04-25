import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do titular:");
        String nomeTitular = scanner.nextLine();

        System.out.println("Tipo de conta (1 - Corrente | 2 - Poupança):");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        ContaBancaria conta;
        if (tipo == 1) {
            conta = new ContaCorrente(nomeTitular);
        } else {
            conta = new ContaPoupanca(nomeTitular);
        }

        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver Extrato");
            System.out.println("4 - Exportar Extrato (.txt)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    conta.exibirExtrato();
                    break;
                case 4:
                    ExportadorExtrato.exportar(conta);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
