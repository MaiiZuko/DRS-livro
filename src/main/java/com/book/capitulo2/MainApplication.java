package com.book.capitulo2;

public class MainApplication {
    public static void main(final String[] args) throws Exception {
        final Extrato extrato = new Extrato();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();
        
        extrato.analyze("extrato.csv", bankStatementParser);
        
    }
}