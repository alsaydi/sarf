package sarf.verb.trilateral.Substitution;

import sarf.verb.trilateral.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class Substitution {
    protected final String segment;
    protected final String result;

    public Substitution(String segment, String result) {
        this.segment = segment;
        this.result = result;
    }

    /**
     * check wheather this Substitution cn be applied for this root and word (which generated form this root)
     * if ok the result will be used
     * @param word String
     * @return String
     */
    public abstract String apply(String word, TrilateralRoot root);

    String buildSubstitution(TrilateralRoot root, String expression) {
        var effectiveExpression = expression.replaceAll("C1", root.getC1() + "");
        effectiveExpression = effectiveExpression.replaceAll("C2", root.getC2() + "");
        effectiveExpression = effectiveExpression.replaceAll("C3", root.getC3() + "");
        return effectiveExpression;
    }
}
