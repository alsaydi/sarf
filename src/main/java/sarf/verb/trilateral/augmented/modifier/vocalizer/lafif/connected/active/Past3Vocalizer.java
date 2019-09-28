package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
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
public class Past3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Past3Vocalizer() {
        substitutions.add(new SuffixSubstitution("َوَ","َى"));// EX: (أسوَى، سَوَّى ساوَى، انغوى، استوى، تساوى، تَسَوَّى استغوى احْوَوَّى)
        substitutions.add(new InfixSubstitution("وْ","يْ"));// EX: (أسْوَيْتُ، سَوَّيْتُ ساوَيْتُ، انغويتُ، استوَيْتُ، تساويتُ، تسوَّيْتُ استغوَيْتُ احوَوَّيْتُ)
        substitutions.add(new InfixSubstitution("وَا","يَا"));// EX: (أسْوَيَا، سَوَّيا ساوَيا، انغويا، استوَيا، تساوَيَا، تَسَوَّيَا، استغوَيَا، احْوَوَّيَا)
        substitutions.add(new InfixSubstitution("وُو","وْ"));// EX: (أسْوَوْا، سَوَّوْا ساوَوْا، انغوَوْا، استوَوْا، تساوَوْا، تَسَوَّوْا، استغوَوْا، احْوَوَّوْا)
        substitutions.add(new InfixSubstitution("وَوَ","وَ"));// EX: (أسْوَتْ، )
        substitutions.add(new InfixSubstitution("وَّوَ","وَّ"));// EX: (سَوَّتْ، )
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
