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
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present1Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("úæóC3õ", "óÇC3õ")); // EX: (åæ íõŞÇã¡ íõÓÊÏÇÑ)
        substitutions.add(new ExpressionInfixSubstitution("úæóC3ö", "óÇC3ö")); // EX: (ÃäÊö ÊõŞóÇãöíäó¡ ÊõÓÊÏÇÑíä)
        substitutions.add(new ExpressionInfixSubstitution("úæóC3ó", "óÇC3ó")); // EX: (ÃäÊãÇ ÊõŞóÇãÇä¡ ÊõÓÊÏÇÑÇä)
        substitutions.add(new ExpressionInfixSubstitution("úæóC3ú", "óC3ú")); // EX: (åäø íõŞóãúäó¡ íõÓÊóÏóÑúäó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return ((kov == 16 || kov == 17) && formulaNo == 1) || ((kov == 15 || kov == 16 || kov == 17) && formulaNo == 9);
    }
}
