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
public class Imperative2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َيِC3ُ","َاC3ُ"));// EX: (انتم انهالوا، اكتالوا)
        substitutions.add(new ExpressionInfixSubstitution("َيِC3ِ","َاC3ِ"));// EX: (أنتِ انهالي، اكتالي)
        substitutions.add(new ExpressionInfixSubstitution("َيِC3َ","َاC3َ"));// EX: (أنتما انهالا، اكتالا)
        substitutions.add(new ExpressionInfixSubstitution("َيِC3ْ","َC3ْ"));// EX: (أنتن انْهَلْنَ، اكْتَلْنَ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == KindOfVerb.Ajwaf_Yaee  && formulaNo == 4) || ((kov == KindOfVerb.Ajwaf_Yaee || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa) && formulaNo == 5);
    }
}
