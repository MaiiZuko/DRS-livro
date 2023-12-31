package com.book.capitulo2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.time.Month;

public class Extrato {
    private static final String DADOS_PADRAO = "C:\\Users\\maiar\\DRS-livro\\extrato.csv";


    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {

        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final Path path = Paths.get(DADOS_PADRAO);
        final List<String> linhas = Files.readAllLines(path);

        final List<TransacaoBancaria> transacaoBancarias = bankStatementCSVParser.parseLinesFrom(linhas);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(transacaoBancarias);
        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("O total de transações foi: " + bankStatementProcessor.calculaTotalValor());
        System.out.println("O total de transações no mês foi: " + bankStatementProcessor.calculaTotalEmMes(Month.JANUARY));
        System.out.println("Transações em fevereiro: " + bankStatementProcessor.calculaTotalEmMes(Month.FEBRUARY));
        System.out.println("Salario: " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    
    }
}