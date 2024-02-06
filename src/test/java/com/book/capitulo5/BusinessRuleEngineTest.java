package com.book.capitulo5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BusinessRuleEngineTest {

    @Test
    public void shuldHaveNoRulesInitially(){
        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        assertEquals(0, businessRuleEngine.count());
    }
    
    
}
