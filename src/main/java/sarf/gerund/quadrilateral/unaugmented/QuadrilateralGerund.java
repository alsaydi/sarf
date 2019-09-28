package sarf.gerund.quadrilateral.unaugmented;

import sarf.Word;

/**
 * مصدر الفعل الرباعي المجرد
 */
public class QuadrilateralGerund extends Word {
    private final String display;

    QuadrilateralGerund(String display){
        this.display = display;
    }

    @Override
    public String toString() {
        return display == null ? "" : this.display;
    }
}
