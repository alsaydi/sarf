package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.passive;

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
public class Past2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private List<Substitution> substitutions = new ArrayList<>();

    public Past2Vocalizer() {
        substitutions.add(new InfixSubstitution("وْ", "ي"));// EX: (أنا سُمِّيتُ، تُزُكِّيتُ)
        substitutions.add(new InfixSubstitution("وَ", "يَ"));// EX: (هو سُمِّيَ، تُزُكِّيَ)
        substitutions.add(new InfixSubstitution("ِّوُ", "ُّ"));// EX: (هم سُمُّوا، تُزُكُّوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain && formulaNo == 8) || ((kov == KindOfVerb.Naqis_Wawi || kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa) && (formulaNo == 2 || formulaNo == 8));
    }
}
