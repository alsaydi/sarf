package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;
import sarf.verb.trilateral.Substitution.*;
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
public class Imperative4Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative4Vocalizer() {
        substitutions.add(new SuffixSubstitution("وْ",""));// EX: (أسْوِ، ساوِ، انْغَوِ، استَوِ، استَغْوِ)
        substitutions.add(new InfixSubstitution("ِوِ","ِ"));// EX: (أنتِ أسْوِي، ساوِي، انْغَوِي، استَوِي، استَغْوِي)
        substitutions.add(new InfixSubstitution("ِوَ","ِيَ"));// EX: (أنتما ِ أسْوِيا، ساوِيا، انْغَوِيا، استَوِيا، استَغْوِيا)
        substitutions.add(new InfixSubstitution("ِوُ","ُ"));// EX: (أنتم أسْوُوا، ساوُوا، انْغَوُوا، استَوُوا، استَغْوُوا)
        substitutions.add(new InfixSubstitution("ِوْ","ِي"));// EX: (أنتن أسْوِينَ، ساوِينَ، انْغَوِينَ، استَوِينَ، استَغْوِينَ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        var root = triAugmentedConjugationResult.getRoot();
        if (root.getC2() == root.getC3() && root.getC3() == 'و' && kov == KindOfVerb.Lafeef_Maqroon) {
            switch (formulaNo) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 9:
                return true;
            }
        }
        return false;

    }
}
