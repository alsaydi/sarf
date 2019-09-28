package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.active;

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
public class Past1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Past1Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3ْ","َC3ْ"));// EX: (أقَمْتُ، استدرتُ)
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3ّ","َC3ّ"));// EX: (أمَتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3َ","َاC3َ"));// EX: (أقامَ، استدار)
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3ُ","َاC3ُ"));// EX: (أقاموا، استداروا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return ((kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi) && formulaNo == 1) || ((kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi) && formulaNo == 9);
    }
}
