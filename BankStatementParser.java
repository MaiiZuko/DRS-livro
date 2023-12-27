import java.util.List;

public interface BankStatementParser {
    TransacaoBancaria parseFrom(String line);
    List<TransacaoBancaria> parseLinesFrom(List<String> lines);
}