package sarf.substitution;

import sarf.WordPresenter;
import sarf.verb.Root;

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
     * check whether this Substitution cn be applied for this root and word (which generated form this root)
     * if ok the result will be used
     * @param word String
     * @return String
     */
    public abstract WordPresenter apply(WordPresenter word, Root root);

    String buildSubstitution(Root root, String expression) {
        var effectiveExpression = expression;
        for (var letter : root.getCharacters()) {
            effectiveExpression = effectiveExpression.replaceAll(letter.getMoniker(), letter.getValue() + "");
        }
        return effectiveExpression;
    }
}
