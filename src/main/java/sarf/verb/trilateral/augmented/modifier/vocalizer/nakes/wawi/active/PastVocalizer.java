package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.TriAugmentedConjugationResult;

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
public class PastVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PastVocalizer() {
        substitutions.add(new SuffixSubstitution("وَ","ى"));// EX: (هو أدنى، سَمَّى ، حابى، انجلى، ارتضى، ارعَوَى، تسامى، تزكّى ، استرضى، احلولى)
        substitutions.add(new InfixSubstitution("وْت","يْت"));// EX: (أنا أدنَيْتُ، سَمَّيْتُ ، حابَيْتُ، انجليتُ، ارتضيتُ، ارعَوَيْتُ، تساميت، تزكَّيْتُ،  استرضيت، احلوليتُ)
        substitutions.add(new InfixSubstitution("وْن","يْن"));// EX: (أنا أدنَيْتُ، سَمَّيْتُ ، حابَيْتُ، انجليتُ، ارتضيتُ، ارعَوَيْتُ، تساميت، تزكَّيْتُ،  استرضيت، احلوليتُ)
        substitutions.add(new InfixSubstitution("وُو", "وْ")); // EX: (هم أدنَوْا، سَمَّوْا ، حابَوْا، انجَلَوْا، ارتضَوْا، ارعَوَوْا، تسامَوْا، تزكَّوْا ، استرضوا، احلولوا)
        substitutions.add(new InfixSubstitution("وَت", "ت")); // EX: (هي أدْنَتْ، سَمَّتْ ، حابَتْ، انْجَلَتْ، ارتضت، ارْعَوَتْ، تسامَتْ، تزكَّتْ ، استرضت، احلولت)
        substitutions.add(new InfixSubstitution("وَا", "يَا")); // EX: (هما أدنَيَا، سَمَّيَا ، حابَيَا، انْجَلَيَا، ارتضيا، ارعَوَيَا، تسامَيَا، تزكَّيَا ، استرضيا، احلوليا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(TriAugmentedConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if ((kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain || kov == KindOfVerb.Naqis_Wawi) && formulaNo == 4) return true;
        if ((kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa || kov == KindOfVerb.Naqis_Wawi) && (formulaNo == 2 || formulaNo == 9)) return true;
        if (kov == KindOfVerb.Naqis_Wawi && (formulaNo == 6 || formulaNo == 10)) return true;

        if (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa || kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain || kov == KindOfVerb.Naqis_Wawi) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                    return true;
            }
        }
        return false;
    }
}
