package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;
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
public class Imperative3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private List<Substitution> substitutions = new ArrayList<>();

    public Imperative3Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (تحايَ، تداوَ، تَحَيَّ، تَقَوَّ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تَحايَيْ، تَداوَيْ، تَحَيَّيْ، تَقَوَّيْ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تَحايَوْا، تَدَاوَوْا، تَحَيَّوْا، تَقَوَّوْا)
        substitutions.add(new InfixSubstitution("يُن","وُن"));// EX: (أنتم تَحايَوُنَّ، تداوَوُنَّ، تَحَيَّوُنَّ، تَقَوَّوُنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        return (root.getC2() == 'و' || root.getC2() == 'ي') && root.getC3() == 'ي' && (kov == 27 || kov == KindOfVerb.Lafeef_Maqroon) && (formulaNo == 7 || formulaNo == 8);
    }
}
