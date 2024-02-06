package com.book.capitulo5;

public interface ConditionalAction {
    boolean evaluate(Facts facts);
    void perform(Facts facts);
}
