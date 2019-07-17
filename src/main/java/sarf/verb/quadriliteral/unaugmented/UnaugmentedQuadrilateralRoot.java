package sarf.verb.quadriliteral.unaugmented;

import sarf.verb.quadriliteral.QuadrilateralRoot;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: الجذر الرباعي المجرد
 * متضمنا الأحرف الأربعة واللزوم أو التعدية               </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class UnaugmentedQuadrilateralRoot extends QuadrilateralRoot{
    private String transitive;

    public UnaugmentedQuadrilateralRoot() {
    }

    public String getTransitive() {
        return transitive;
    }

    public void setTransitive(String transitive) {
        this.transitive = transitive;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare.
     * @return <code>true</code> if this object is the same as the obj
     *   argument; <code>false</code> otherwise.
     * @todo Implement this java.lang.Object method
     */
    public boolean equals(Object obj) {
        if(!(obj instanceof UnaugmentedQuadrilateralRoot)){
            return false;
        }
        UnaugmentedQuadrilateralRoot other = (UnaugmentedQuadrilateralRoot) obj;
        return other.getC1() == this.getC1() && other.getC2() == this.getC2()
                && other.getC3() == this.getC4() && other.getC4() == this.getC4();
    }
}


