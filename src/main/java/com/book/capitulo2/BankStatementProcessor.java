package com.book.capitulo2;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {
    private final List<TransacaoBancaria> transacaoBancarias;

    public BankStatementProcessor(final List<TransacaoBancaria> transacaoBancarias){
        this.transacaoBancarias = transacaoBancarias;
    }

    public double calculaTotalValor(){
        double total =0;
        for(final TransacaoBancaria transacaoBancaria: transacaoBancarias){
            total += transacaoBancaria.getValor();
        }
        return total;
    }

    public double calculaTotalEmMes(final Month month){
        double total =0;
        for(final TransacaoBancaria transacaoBancaria: transacaoBancarias){
            if(transacaoBancaria.getDate().getMonth() == month){
                total += transacaoBancaria.getValor();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for (final TransacaoBancaria transacaoBancaria : transacaoBancarias) {
            if (transacaoBancaria.getDescription().equals(category)) {
                total += transacaoBancaria.getValor();
            }
        }
        return total;
    }
}