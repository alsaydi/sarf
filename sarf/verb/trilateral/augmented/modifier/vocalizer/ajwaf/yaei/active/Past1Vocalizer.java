package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class Past1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Past1Vocalizer() {

        substitutions.add(new ExpressionInfixSubstitution("úíóC3ú","óC3ú"));// EX: (ÃÈóÏúÊõ¡ ÇÓÊŞáÊõ)
        substitutions.add(new ExpressionInfixSubstitution("úíóC3ø","óC3ø"));// EX: (ÃÈóÊøõ)
        substitutions.add(new ExpressionInfixSubstitution("úíóC3ó","óÇC3ó"));// EX: (ÃÈÇÏó¡ ÇÓÊŞÇá)
        substitutions.add(new ExpressionInfixSubstitution("úíóC3õ","óÇC3õ"));// EX: (ÃÈÇÏõæÇ¡ ÇÓÊŞÇáæÇ)


    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return ((kov == 19 || kov == 20) && formulaNo == 1) || ((kov == 18 || kov == 19 || kov == 20) && formulaNo == 9);
    }
}
