package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.active;

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
public class Imperative1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative1Vocalizer() {

        substitutions.add(new ExpressionInfixSubstitution("úæöC3õ", "öíC3õ")); // EX: (ÃäÊã ÃŞíãæÇ¡ ÇÓÊÏíÑæÇ)
        substitutions.add(new ExpressionInfixSubstitution("úæöC3ö", "öíC3ö")); // EX: (ÃäÊö ÃŞíãí¡ ÇÓÊÏíÑí)
        substitutions.add(new ExpressionInfixSubstitution("úæöC3ó", "öíC3ó")); // EX: (ÃäÊãÇ ÃŞíãÇ¡ ÇÓÊÏíÑÇ)
        substitutions.add(new ExpressionInfixSubstitution("úæöC3ú", "öC3ú")); // EX: (ÃäÊä ÃŞöãúäó¡ ÇÓÊÏÑúäó)
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
