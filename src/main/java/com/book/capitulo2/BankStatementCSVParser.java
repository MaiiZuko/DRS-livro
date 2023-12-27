import java.time.LocalDate;
import java.util.List;
import java.time.format.DateTimeFormatter;

import static java.util.stream.Collectors.toList;

public class BankStatementCSVParser implements BankStatementParser {
    
    private static final DateTimeFormatter DATA_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public TransacaoBancaria parseFrom(String line) {
        final String[] colunas = line.split(",");
        final LocalDate date = LocalDate.parse(colunas[0], DATA_PATTERN);
        double valor = Double.parseDouble(colunas[1]);
        return new TransacaoBancaria(date, valor, colunas[2]);
    }

    @Override
    public List<TransacaoBancaria> parseLinesFrom(List<String> lines) {
        return lines.stream().map(this::parseFrom).collect(toList());
    }
}
