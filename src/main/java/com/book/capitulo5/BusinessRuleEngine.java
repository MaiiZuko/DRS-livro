package com.book.capitulo5;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {
    
    private final List<Action> actions;
    private final Facts facts;

    public BusinessRuleEngine() {
        this.facts = facts;
        this.actions = new ArrayList<>();
    }

    public BusinessRuleEngine() {
        //TODO Auto-generated constructor stub
    }

    public void addAction(final Action action) {
        this.actions.add(action);
    }

    public int count() {
        return this.actions.size();
    }

    public void run() {
        this.actions.forEach(rule -> rule.perform(facts));
    }
    
}
