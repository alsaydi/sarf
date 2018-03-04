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
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present1Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("úíóC3õ","óÇC3õ"));// EX: (åæ íõÈÇÏõ¡ íõÓÊŞÇá)
        substitutions.add(new ExpressionInfixSubstitution("úíóC3ö","óÇC3ö"));// EX: (ÃäÊö ÊõÈÇÏöíä¡ ÊõÓÊŞÇáíä)
        substitutions.add(new ExpressionInfixSubstitution("úíóC3ó","óÇC3ó"));// EX: (ÃäÊãÇ ÊõÈÇÏÇä¡ ÊõÓÊŞÇáÇä)
        substitutions.add(new ExpressionInfixSubstitution("úíóC3ú","óC3ú"));// EX: (åäø íõÈóÏúäó¡ íõÓÊóŞóáúäó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return ((kov == 18 || kov == 19 || kov == 20) && formulaNo == 1) || ((kov == 18 || kov == 19 || kov == 20) && formulaNo == 9);
    }
}
