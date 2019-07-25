package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.passive;

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
        substitutions.add(new SuffixSubstitution("َيُ", "َى")); // EX: (يوصَى، يُوَصَّى، يُوالَى، يُتَّقَى، يُتَوارَى، يُتَوَلَّى، يُسْتَوْفَى)
        substitutions.add(new SuffixSubstitution("َيَ", "َى")); // EX: (لن يُوصَى، يُوَصَّى، يُوالَى، يُتَّقَى، يُتَوارَى، يُتَوَلَّى، يُسْتَوْفَى)
        substitutions.add(new SuffixSubstitution("َيْ", "َ")); // EX: (لم يُوصَ، يُوَصَّ، يُوالَ، يُتَّقَ، يُتَوارَ، يُتَوَلَّ، يُسْتَوْفَ)
        substitutions.add(new InfixSubstitution("َيِي", "َيْ")); // EX: (أنتِ تُوصَيْنَ، تُوَصَّيْنَ، تُوالَين، تُتَّقَين، تُتَوارَين، تُتَوَلَّين، تُسْتَوْفَين)
        substitutions.add(new InfixSubstitution("َيُو", "َوْ")); // EX: (أنتم تُوصَوْنَ، تُوَصَّوْنَ، تُوالَون، تُتَّقَون، تُتَوارَوْن، تُتَوَلَّوْن، تُسْتَوْفَون)
        substitutions.add(new InfixSubstitution("َيُن", "َوُن")); // EX: (أنتم تُوصَوُنَّ، تُوَصَّوُنَّ، تُوالَوُنَّ، تُتَّقَوُنَّ، تُتَوارَوُنَّ، تُتَوَلَّوُنَّ، تُسْتَوْفَوُنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain) {
            switch (formulaNo) {
                case 5:
                case 7:
                case 9:
                    return true;
            }


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
        } else if (kov == KindOfVerb.Lafeef_Mafrooq) {
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
        }

        return false;
    }
}
