package sarf.verb.quadriliteral.substitution;

import sarf.verb.quadriliteral.*;

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
    protected String segment;
    protected String result;

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
    public abstract String apply(String word, QuadrilateralRoot root);
}
