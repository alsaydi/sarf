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
public class PresentVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private List<Substitution> substitutions = new ArrayList<>();

    public PresentVocalizer() {
        substitutions.add(new SuffixSubstitution("وُ", "ى")); // EX: (يُدْنَى، يُسَمَّى، يحابَى، يرتضى، يرعوَى، يُتسامى، يُتزكَّى، يسترضى، يحلولى)
        substitutions.add(new SuffixSubstitution("وَ", "ى")); // EX: (لن يُدْنَى، يُسَمَّى، يحابَى، يرتضى، يُتسامى، يُتزكَّى، يسترضى، يحلولى)
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (لم يُدْنَ، يُسَمَّ، يحابَ، يرتضَ، يرعوَ، يُتسامَ، يُتزكَّ، يسترضَ، يحلولَ)
        substitutions.add(new InfixSubstitution("وِي", "يْ")); // EX: (أنتِ تُدْنَيْنَ، تُسَمَّيْن، تحابَين، ترتضَين، تُتسامَين، تُتزكَّين، تسترضَين، تحلولَين)
        substitutions.add(new InfixSubstitution("وَا", "يَا")); // EX: (أنتما تُدْنَيان، تُسَمَّيان، تحابَيان، ترتضَيان، تُتسامَيان، تُتزكَّيان، تسترضَيان، تحلولَيان)
        substitutions.add(new InfixSubstitution("وُو", "وْ")); // EX: (أنتم تُدْنَوْن، تُسَمَّوْن، تحابَوْن، ترتضَوْن، تُتسامَوْن، تُتزكَّوْن، تسترضَوْن، تحلولَوْن)
        substitutions.add(new InfixSubstitution("وْن", "يْن")); // EX: (أنتن تُدْنَيْنَ، تُسَمَّيْن، تحابَين، ترتضَين، تُتسامَين، تُتزكَّين، تسترضَين، تحلولَين)
        substitutions.add(new InfixSubstitution("وَن", "يَن")); // EX: (هو يُدْنَيَنَّ، يُسَمَّيَنَّ، يحابَيَنَّ، يرتضَيَنَّ، يُتسامَيَنَّ، يُتزكَّيَنَّ، يسترضَيَنَّ، يحلولَيَنَّ)
        substitutions.add(new InfixSubstitution("وِن", "يِن")); // EX: (أنتِ تُدْنَيِنَّ، تُسَمَّيِنَّ، تحابَيِنَّ، ترتضَيِنَّ، تُتسامَيِنَّ، تُتزكَّيِنَّ، تسترضَيِنَّ، تحلولَيِنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if (kov == 21) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    return true;
            }
        } else if (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    return true;
            }
        } else if (kov == KindOfVerb.Naqis_Wawi) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    return true;
            }
        }
        return false;
    }
}
