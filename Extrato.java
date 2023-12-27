import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.time.Month;

public class Extrato {
    private static final String DADOS_PADRAO = "C:\\DRS-livro\\extrato.csv";

    public static double calculaTotalValor (final List<TransacaoBancaria> transacaoBancarias){
        double total = 0d;
        for(final TransacaoBancaria transacaoBancaria: transacaoBancarias){
            total += transacaoBancaria.getValor();
        }
        return total;
    }

    public static List<TransacaoBancaria> selectInMonth(final List<TransacaoBancaria> transacaoBancarias, final Month month) {
        final List<TransacaoBancaria> transacaoBancariasEmMes = new ArrayList<>();
        for(final TransacaoBancaria transacaoBancaria: transacaoBancarias){
            if(transacaoBancaria.getDate().getMonth() == month){
                transacaoBancariasEmMes.add(transacaoBancaria);
            }
        }
        return transacaoBancariasEmMes;
    }

    public static void main(final String... args) throws IOException {

        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final Path path = Paths.get(DADOS_PADRAO);
        final List<String> linhas = Files.readAllLines(path);

        final List<TransacaoBancaria> transacaoBancarias = bankStatementCSVParser.parseLinesFromCSV(linhas);

        System.out.println("O total de transações foi: " + calculaTotalValor(transacaoBancarias));
        System.out.println("O total de transações no mês foi: " + selectInMonth(transacaoBancarias, Month.JANUARY));
    }
}
