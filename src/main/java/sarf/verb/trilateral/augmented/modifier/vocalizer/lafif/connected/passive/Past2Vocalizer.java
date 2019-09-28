package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.passive;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
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
public class Past2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Past2Vocalizer() {
        substitutions.add(new InfixSubstitution("ِوُ","ُ"));// EX: (اُسْوُوا، سُووُوا، انغُوُوا، استُوُوا، تُسُووُوا، استُغْوُوا)
        substitutions.add(new InfixSubstitution("ِّوُ","ُّ"));// EX: (سُوُّوا، تُسُوُّوا، احْوُوُّوا)
        substitutions.add(new InfixSubstitution("وَ","يَ"));// EX: (أُسْوِيَ، سُوِّيَ أُسْوِيَتْ، أُسْوِيَا، سُووِيَ، انغُوِيَ، استُوِيَ، تُسُووِيَ، استُغْوِيَ احْوُوِّيَ)
        substitutions.add(new InfixSubstitution("وْ","ي"));// EX: (أُسْوِيتُ، سُوِّيتُ سُووِيتُ، انغُوِيتُ، استُوِيتُ، تُسُووِيتُ، استُغْوِيتُ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        var root = triAugmentedConjugationResult.getRoot();
        if (root.getC2() == root.getC3() && root.getC3() == 'و' && kov == KindOfVerb.Lafeef_Maqroon) {
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 11:
                return true;
            }
        }

        return false;
    }
}
