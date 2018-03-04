package sarf.verb.trilateral.unaugmented.modifier.geminator.generic;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;

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
public class ActivePresentGeminator extends SubstitutionsApplier{

    private List substitutions = new LinkedList();

    public ActivePresentGeminator() {

        substitutions.add(new ExpressionInfixSubstitution("úC3õC3õ","õC3øõ"));
        substitutions.add(new ExpressionInfixSubstitution("úC3õC3ó","õC3øó"));
        substitutions.add(new ExpressionInfixSubstitution("úC3õC3ö","õC3øö"));
        substitutions.add(new ExpressionSuffixSubstitution("úC3õC3ú","õC3øó"));
        substitutions.add(new ExpressionInfixSubstitution("úC3öC3õ","öC3øõ"));
        substitutions.add(new ExpressionInfixSubstitution("úC3öC3ó","öC3øó"));
        substitutions.add(new ExpressionInfixSubstitution("úC3öC3ö","öC3øö"));
        substitutions.add(new ExpressionSuffixSubstitution("úC3öC3ú","öC3øó"));
        substitutions.add(new ExpressionInfixSubstitution("úC3óC3õ","óC3øõ"));
        substitutions.add(new ExpressionInfixSubstitution("úC3óC3ó","óC3øó"));
        substitutions.add(new ExpressionInfixSubstitution("úC3óC3ö","óC3øö"));
        substitutions.add(new ExpressionSuffixSubstitution("úC3óC3ú","óC3øó"));



    }

    public List getSubstitutions() {
        return substitutions;
    }
}
