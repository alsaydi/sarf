package sarf.kov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadrilateralKovRuleListTest {

    @Test
    void addRule() {
        var sut = new QuadrilateralKovRuleList();
        assertEquals(0, sut.getRules().size());

        sut.addRule(new QuadrilateralKovRule());

        assertEquals(1, sut.getRules().size());
    }

    @Test
    void getRules() {
        var sut = new QuadrilateralKovRuleList();
        assertEquals(0, sut.getRules().size());

        sut.addRule(new QuadrilateralKovRule());
        sut.addRule(new QuadrilateralKovRule());

        assertEquals(2, sut.getRules().size());
    }
}