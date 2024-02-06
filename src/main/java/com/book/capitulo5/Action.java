package com.book.capitulo5;

@FunctionalInterface
public interface Action {
    void perform(Facts facts);
}
