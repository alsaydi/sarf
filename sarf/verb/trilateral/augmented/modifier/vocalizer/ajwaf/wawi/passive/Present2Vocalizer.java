package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.passive;

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
        substitutions.add(new ExpressionInfixSubstitution("óæóC3õ","óÇC3õ"));// EX: (åæ íõäúŞÇÏõ¡ íõŞúÊÇÏ)
        substitutions.add(new ExpressionInfixSubstitution("óæóC3ö","óÇC3ö"));// EX: (ÃäÊö ÊõäúŞÇÏöíäó¡ ÊõŞúÊÇÏöíäó)
        substitutions.add(new ExpressionInfixSubstitution("óæóC3ó","óÇC3ó"));// EX: (ÃäÊãÇ ÊõäúŞóÇÏóÇäö¡ ÊõŞúÊÇÏóÇäö)
        substitutions.add(new ExpressionInfixSubstitution("óæóC3ú","óC3ú"));// EX: (åäø íõäúŞóÏúäó¡ íõŞúÊóÏúäó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return ((kov == 15 || kov == 17) && formulaNo == 4) || ((kov == 15 || kov == 16 || kov == 17) && formulaNo == 5);
    }
}
