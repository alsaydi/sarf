package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.TriAugmentedConjugationResult;
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
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present1Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يُهْدِي، يُجارِي، يَنْثَنِي، يَكْتَفِي، يَسْتَغْنِي، يَعْرَوْرِي)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يُهْدِ، يُجارِ، يَنْثَنِ، يَكْتَفِ، يَسْتَغْنِ، يَعْرَوْرِ)
        substitutions.add(new InfixSubstitution("يِن", "ن")); // EX: (أنتِ تُهْدِنَّ، تُجارِنَّ، تَنْثَنِنَّ، تَكْتَفِنَّ، تَسْتَغْنِنَّ، تَعْرَوْرِنَّ)
        substitutions.add(new InfixSubstitution("يِي", "ي")); // EX: (أنتِ تُهْدِينَ، تُجارِينَ، تَنْثَنِينَ، تَكْتَفِينَ، تَسْتَغْنِينَ، تَعْرَوْرِينَ)
        substitutions.add(new InfixSubstitution("يْن", "ين")); // EX: (أنتن تُهْدِينَ، تُجارِينَ، تَنْثَنِينَ، تَكْتَفِينَ، تَسْتَغْنِينَ، تَعْرَوْرِينَ)
        substitutions.add(new InfixSubstitution("ِيُو", "ُو")); // EX: (أنتم تُهْدُونَ، تُجارُونَ، تَنْثَنُونَ، تَكْتَفُونَ، تَسْتَغْنُونَ، تَعْرَوْرُونَ)
        substitutions.add(new InfixSubstitution("ِيُن", "ُن")); // EX: (أنتم تُهْدُنَّ، تُجارُنَّ، تَنْثَنُنَّ، تَكْتَفُنَّ، تَسْتَغْنُنَّ، تَعْرَوْرُنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(TriAugmentedConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Naqis_Yaee) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 9:
                case 10:
                    return true;
            }


        } else if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 9:
                    return true;
            }


        } else if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 5:
                case 9:
                    return true;
            }
        }
        return false;
    }
}
