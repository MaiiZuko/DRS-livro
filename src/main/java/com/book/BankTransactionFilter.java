package com.book;

import com.book.capitulo2.TransacaoBancaria;

@FunctionalInterface //Interface com apenas um único método abstrato
public interface BankTransactionFilter {
    boolean test(TransacaoBancaria transacaoBancaria);
    
}
