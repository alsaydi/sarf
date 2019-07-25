package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.passive;

import java.util.*;

import sarf.KindOfVerb;
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
    private List<Substitution> substitutions = new ArrayList<>();

    public Present2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َوَC3ُ","َاC3ُ"));// EX: (هو يُنْقادُ، يُقْتاد)
        substitutions.add(new ExpressionInfixSubstitution("َوَC3ِ","َاC3ِ"));// EX: (أنتِ تُنْقادِينَ، تُقْتادِينَ)
        substitutions.add(new ExpressionInfixSubstitution("َوَC3َ","َاC3َ"));// EX: (أنتما تُنْقَادَانِ، تُقْتادَانِ)
        substitutions.add(new ExpressionInfixSubstitution("َوَC3ْ","َC3ْ"));// EX: (هنّ يُنْقَدْنَ، يُقْتَدْنَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return ((kov == 15 || kov == KindOfVerb.Ajwaf_Wawi) && formulaNo == 4) || ((kov == 15 || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi) && formulaNo == 5);
    }
}
