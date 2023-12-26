import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SomaDosExtratos {
    private static final String DADOS_PADRAO = "C:\\DRS-livro\\extrato.csv";

    public static void main(final String... args) throws IOException {

        final Path path = Paths.get(DADOS_PADRAO);
        final List<String> linhas = Files.readAllLines(path);
        double total = 0d; //inicializa com o valor zero d - double

        for (final String linha : linhas) {
            final String[] colunas = linha.split(",");
            if (colunas.length >= 3) { // Verifica se há pelo menos três colunas
                final double valor = Double.parseDouble(colunas[1]);
                total += valor;
            }
        }

        System.out.println("O total de transações foi: " + total);
    }
}
