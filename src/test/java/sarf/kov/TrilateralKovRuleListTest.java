package sarf.kov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrilateralKovRuleListTest {

    @Test
    void addRule() {
        var sut = new TrilateralKovRuleList();
        assertEquals(0, sut.getRules().size());

        sut.addRule(new TrilateralKovRule());

        assertEquals(1, sut.getRules().size());
    }

    @Test
    void getRules() {
        var sut = new TrilateralKovRuleList();
        assertEquals(0, sut.getRules().size());

        sut.addRule(new TrilateralKovRule());
        sut.addRule(new TrilateralKovRule());

        assertEquals(2, sut.getRules().size());
    }
}