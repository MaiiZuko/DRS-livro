package com.book.capitulo2;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankTransactionCSVParserTest {

    private BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        String line = "30-01-2017,-50,Tesco";

        TransacaoBancaria result = statementParser.parseFrom(line);

        TransacaoBancaria expected = new TransacaoBancaria(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getValor(), result.getValor(), 0.0d);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }
}
