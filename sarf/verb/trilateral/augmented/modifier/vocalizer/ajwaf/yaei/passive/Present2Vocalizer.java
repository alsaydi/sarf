package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.passive;

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
public class Present2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("óíóC3õ","óÇC3õ"));// EX: (åæ íõäåÇá¡ íõßÊÇá)
        substitutions.add(new ExpressionInfixSubstitution("óíóC3ö","óÇC3ö"));// EX: (ÃäÊö ÊõäåÇáíä¡ ÊõßÊÇáíä)
        substitutions.add(new ExpressionInfixSubstitution("óíóC3ó","óÇC3ó"));// EX: (ÃäÊãÇ ÊõäåÇáÇä¡ ÊõßÊÇáÇä)
        substitutions.add(new ExpressionInfixSubstitution("óíóC3ú","óC3ú"));// EX: (åäø íõäúåóáúäó¡ íõßúÊóáúäó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == 20 && formulaNo == 4) || ((kov == 18 || kov == 20 ) && formulaNo == 5);
    }
}
