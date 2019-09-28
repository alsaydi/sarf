package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.passive;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
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
public class Present2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َوَC3ُ","َاC3ُ"));// EX: (هو يُنْقادُ، يُقْتاد)
        substitutions.add(new ExpressionInfixSubstitution("َوَC3ِ","َاC3ِ"));// EX: (أنتِ تُنْقادِينَ، تُقْتادِينَ)
        substitutions.add(new ExpressionInfixSubstitution("َوَC3َ","َاC3َ"));// EX: (أنتما تُنْقَادَانِ، تُقْتادَانِ)
        substitutions.add(new ExpressionInfixSubstitution("َوَC3ْ","َC3ْ"));// EX: (هنّ يُنْقَدْنَ، يُقْتَدْنَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return ((kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Wawi) && formulaNo == 4) || ((kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi) && formulaNo == 5);
    }
}
