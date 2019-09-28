package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;

import sarf.ConjugationResult;
import sarf.verb.trilateral.augmented.modifier.*;

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
public class Present2Vocalizer extends SubstitutionsApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َيِC3ُ", "َاC3ُ"));// EX: (هو يَنهال، يَكتال)
        substitutions.add(new ExpressionInfixSubstitution("َيِC3ِ", "َاC3ِ"));// EX: (أنتِ تنهالين، تكتالين)
        substitutions.add(new ExpressionInfixSubstitution("َيِC3َ", "َاC3َ"));// EX: (أنتما تنهالان، تكتالان)
        substitutions.add(new ExpressionInfixSubstitution("َيِC3ْ", "َC3ْ"));// EX: (هنّ يَنْهَلْنَ، يَكْتَلْنَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return (kov == KindOfVerb.Ajwaf_Yaee  && formulaNo == 4) || ((kov == KindOfVerb.Ajwaf_Yaee || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa) && formulaNo == 5);
    }
}
