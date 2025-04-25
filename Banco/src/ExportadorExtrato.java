import java.io.FileWriter;
import java.io.IOException;

public class ExportadorExtrato {

    public static void exportar(ContaBancaria conta) {
        try {
            String nomeArquivo = conta.getTitular().replace(" ", "_") + "_extrato.txt";
            FileWriter writer = new FileWriter(nomeArquivo);

            writer.write("Extrato da conta de: " + conta.getTitular() + "\n\n");
            for (Transacao t : conta.getTransacoes()) {
                writer.write(t.toString() + "\n");
            }
            writer.write("\nSaldo final: R$ " + String.format("%.2f", conta.getSaldo()));
            writer.close();

            System.out.println("Extrato exportado com sucesso para " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao exportar extrato: " + e.getMessage());
        }
    }
}
