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
public class Past2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Past2Vocalizer() {

        substitutions.add(new ExpressionInfixSubstitution("óíóC3ú","óC3ú"));// EX: (ÇäúåóáúÊõ¡ ÇßÊáÊõ)
        substitutions.add(new ExpressionInfixSubstitution("óíóC3ø","óC3ø"));// EX: (ÇÎÊóÊø)
        substitutions.add(new ExpressionInfixSubstitution("óíóC3ó","óÇC3ó"));// EX: (ÇäúåÇáó¡ ÇßÊÇá)
        substitutions.add(new ExpressionInfixSubstitution("óíóC3õ","óÇC3õ"));// EX: (ÇäåÇáæÇ¡ ÇßÊÇáæÇ)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == 20  && formulaNo == 4) || ((kov == 20 || kov == 18) && formulaNo == 5);
    }
}
