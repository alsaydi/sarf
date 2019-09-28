package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;

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
public class Imperative2Vocalizer extends SubstitutionsApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative2Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ",""));// EX: (حَيِّ، قَوِّ)
        substitutions.add(new InfixSubstitution("ِّيِ","ِّ"));// EX: (أنتِ حَيِّي، قَوِّي)
        substitutions.add(new InfixSubstitution("ِّيُ","ُّ"));// EX: (أنتم حَيُّوا، قَوُّوا)
        substitutions.add(new InfixSubstitution("ِّيْ","ِّي"));// EX: (أنتن حَيِّينَ، قَوِّينَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        var root = triAugmentedConjugationResult.getRoot();
        return (root.getC2() == 'و' || root.getC2() == 'ي') && root.getC3() == 'ي' && (kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa || kov == KindOfVerb.Lafeef_Maqroon) && formulaNo == 2;
    }
}
