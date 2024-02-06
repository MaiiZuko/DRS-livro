package com.book.capitulo2;

@FunctionalInterface //Interface com apenas um único método abstrato
public interface BankTransactionFilter {
    boolean test(TransacaoBancaria transacaoBancaria);
    
}
