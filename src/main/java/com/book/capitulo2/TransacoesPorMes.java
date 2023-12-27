package com.book.capitulo2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TransacoesPorMes {
    private static final String DADOS_PADRAO = "C:\\DRS-livro\\extrato.csv";

    public static void main(final String... args) throws IOException {

        final Path path = Paths.get(DADOS_PADRAO);
        final List<String> linhas = Files.readAllLines(path);
        double total = 0d; //inicializa com o valor zero d - double
        final DateTimeFormatter DATA_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (final String linha : linhas) {
            final String[] colunas = linha.split(",");
            final LocalDate date = LocalDate.parse(colunas[0], DATA_PATTERN);
            if (date.getMonth() == Month.JANUARY) { // Verifica se há pelo menos três colunas
                final double valor = Double.parseDouble(colunas[1]);
                total += valor;
            }
        }

        System.out.println("Transações em janeiro: " + total);
    }
}
