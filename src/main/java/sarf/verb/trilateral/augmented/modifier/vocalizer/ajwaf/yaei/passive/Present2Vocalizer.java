package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.passive;

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
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ُ","َاC3ُ"));// EX: (هو يُنهال، يُكتال)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ِ","َاC3ِ"));// EX: (أنتِ تُنهالين، تُكتالين)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3َ","َاC3َ"));// EX: (أنتما تُنهالان، تُكتالان)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ْ","َC3ْ"));// EX: (هنّ يُنْهَلْنَ، يُكْتَلْنَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == KindOfVerb.Ajwaf_Yaee && formulaNo == 4) || ((kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Yaee ) && formulaNo == 5);
    }
}
