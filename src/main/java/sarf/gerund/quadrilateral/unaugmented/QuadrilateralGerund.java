package sarf.gerund.quadrilateral.unaugmented;

/**
 * مصدر الفعل الرباعي المجرد
 */
public class QuadrilateralGerund {
    private final String display;

    QuadrilateralGerund(String display){
        this.display = display;
    }

    @Override
    public String toString() {
        return display == null ? "" : this.display;
    }
}
