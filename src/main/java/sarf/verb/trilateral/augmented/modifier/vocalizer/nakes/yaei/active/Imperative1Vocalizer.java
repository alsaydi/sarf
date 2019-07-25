package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active;

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
public class Imperative1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative1Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ",""));// EX: (أهْدِ، جَارِ، انْثَنِ، اكْتَفِ، اسْتَغْنِِِِِِِِِ، اعْرَوْرِ)
        substitutions.add(new InfixSubstitution("يِي","ي"));// EX: (أنتِ أهْدِي، جَارِي، انْثَنِي، اكْتَفِي، استغْنِي، اعْرَوْرِي)
        substitutions.add(new InfixSubstitution("يِن","ن"));// EX: (أنتِ أهْدِنَّ، جَارِنَّ، انْثَنِنَّ، اكْتَفِنَّ، استغْنِنَّ، اعْرَوْرِنَّ)
        substitutions.add(new InfixSubstitution("يْن","ين"));// EX: (أنتن أهْدِينَ، جَارِينَ، انْثَنِينَ، اكْتَفِينَ، استغنِينَ، اعْرَوْرِي)
        substitutions.add(new InfixSubstitution("ِيُ","ُ"));// EX: (أنتم أهْدُوا، جَارُوا، انْثَنُوا، اكْتَفُوا، استغنُوا، اعْرَوْرُوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

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


            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 3:
                case 5:
                case 9:
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


            switch (formulaNo) {
                case 1:
                case 3:
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
