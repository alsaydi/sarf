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
public class Past3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Past3Vocalizer() {
        substitutions.add(new InfixSubstitution("وْ", "ي")); // EX: (أنا ارعُوِيتُ)
        substitutions.add(new InfixSubstitution("وَّ", "وِيَ")); // EX: (هو ارْعُوِيَ)
        substitutions.add(new InfixSubstitution("وُّ", "وُ")); // EX: (هم ارْعُوُوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return kov == KindOfVerb.Naqis_Wawi && formulaNo == 6;
    }
}
