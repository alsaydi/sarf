package sarf.noun.trilateral.augmented.modifier.passiveparticiple.vocalizer;

import java.util.*;

import sarf.KindOfVerb;
import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.*;

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
public class PreSeparatedLafifVocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PreSeparatedLafifVocalizer() {
        substitutions.add(new InfixSubstitution("ُوْ","ُو"));// EX: (مُوصٍ)
        substitutions.add(new InfixSubstitution("ُيْ","ُو"));// EX: (مُودٍ)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return kov == KindOfVerb.Lafeef_Mafrooq  && formulaNo == 1;
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
