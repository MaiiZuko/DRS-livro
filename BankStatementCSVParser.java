import java.time.LocalDate;
import java.util.List;
import java.time.format.DateTimeFormatter;

import static java.util.stream.Collectors.toList; // Importando toList

public class BankStatementCSVParser {
    
    private static final DateTimeFormatter DATA_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private TransacaoBancaria parseFromCSV(final String line) {
        final String[] colunas = line.split(",");

        final LocalDate date = LocalDate.parse(colunas[0], DATA_PATTERN);
        double valor = Double.parseDouble(colunas[1]);

        return new TransacaoBancaria(date, valor, colunas[2]);
    }

    public List<TransacaoBancaria> parseLinesFromCSV(final List<String> lines){
        return lines.stream().map(this::parseFromCSV).collect(toList()); 
    }
}
