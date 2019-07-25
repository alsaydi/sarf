package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.passive;

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
    private final List<Substitution> substitutions = new ArrayList<>();

    public PresentVocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ","َى"));// EX: (يُهْدَى، يُرَقَّى، يُجارَى، يُنثنَى، يُكتفى، يُتناسى، يُترقَّى، يُستغنى، يُعرورى، يُجْأوَّى)
        substitutions.add(new SuffixSubstitution("يَ", "ى")); // EX: (لن يُهْدَى، يُرَقَّى، يُجارَى، يُنثنَى، يُكتفى، يُتناسى، يُترقَّى، يُستغنى، يُعرورى، يُجْأوَّى)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يُهْدَ، يُرَقَّ، يُجارَ، يُنثنَ، يُكتف، يُتناس، يُترقَّ، يُستغن، يُعرور، يُجْأوَّ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تُهْدَيْنَ، تُرَقَّيْنَ، تُجارَيْنَ، تُنثنَيْنَ، تُكتفيْنَ، تُتناسَيْنَ، تُترقَّيْنَ، تُستغنَيْنَ، تُعرورَيْنَ، تُجْأوَّيْنَ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تُهْدَوْنَ، تُرَقَّوْنَ، تُجارَوْنَ، تُنثنَوْنَ، تُكتفوْنَ، تُتناسَوْنَ، تُترقَّوْنَ، تُستغنَوْنَ، تُعرورَوْنَ، تُجْأوَّوْنَ)
        substitutions.add(new InfixSubstitution("يُنَّ","وُنَّ"));// EX: (أنتن تُهْدَوُنَّ، تُرَقَّوُنَّ، تُجارَوُنَّ، تُنثنَوُنَّ، تُكتفوُنَّ، تُتناسَوُنَّ، تُترقَّوُنَّ، تُستغنَوُنَّ، تُعرورَوُنَّ، تُجْأوَّوُنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa) {
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
                case 4:
                case 11:
                    return true;
            }


            switch (formulaNo) {
                case 10:
                    return true;
            }
        } else if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain) {
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


            switch (formulaNo) {
                case 10:
                    return true;
            }
        } else if (kov == KindOfVerb.Naqis_Yaee) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
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
