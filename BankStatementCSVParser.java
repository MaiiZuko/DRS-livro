import java.time.LocalDate;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class BankStatementCSVParser {
    
    private static final DateTimeFormatter DATA_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private TransacaoBancaria parseFromCSV(final String line) {
        final String[] colunas = line.split(",");

        final LocalDate date = LocalDate.parse(colunas[0], DATA_PATTERN);
        double valor = Double.parseDouble(colunas[1]);
        final String description = colunas[2];

        return new TransacaoBancaria(date, valor, description);
    }

    public List<TransacaoBancaria> parseLinesFromCSV(final List<String> lines){
        final List<TransacaoBancaria> transacaoBancarias = new ArrayList<>();
        for(final String line:lines) {
            transacaoBancarias.add(parseFromCSV(line));
        }
        return transacaoBancarias;
    }
}

