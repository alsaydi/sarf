package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.passive;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.TriAugmentedConjugationResult;
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
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new LinkedList();

    public Present1Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3ُ", "َاC3ُ")); // EX: (هو يُقام، يُستدار)
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3ِ", "َاC3ِ")); // EX: (أنتِ تُقَامِينَ، تُستدارين)
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3َ", "َاC3َ")); // EX: (أنتما تُقَامان، تُستداران)
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3ْ", "َC3ْ")); // EX: (هنّ يُقَمْنَ، يُستَدَرْنَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(TriAugmentedConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return ((kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi) && formulaNo == 1) || ((kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi) && formulaNo == 9);
    }
}
