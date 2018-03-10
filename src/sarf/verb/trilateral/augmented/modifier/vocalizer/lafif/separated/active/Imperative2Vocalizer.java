package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active;

import java.util.*;

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
public class Imperative2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (تَوارَ، تَوَلَّ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تَوارَيْ، تَوَلَّيْ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تَوَارَوْا، تَوَلَّوْا)
        substitutions.add(new InfixSubstitution("يُن", "وُن")); // EX: (أنتم تَوَارَوُنَّ، تَوَلَّوُنَّ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == 29 && formulaNo == 7) || (kov == 30 && (formulaNo == 7 || formulaNo == 8));
    }
}
