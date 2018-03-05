package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active;

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
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present1Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يُهْدِي، يُجارِي، يَنْثَنِي، يَكْتَفِي، يَسْتَغْنِي، يَعْرَوْرِي)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يُهْدِ، يُجارِ، يَنْثَنِ، يَكْتَفِ، يَسْتَغْنِ، يَعْرَوْرِ)
        substitutions.add(new InfixSubstitution("يِن", "ن")); // EX: (أنتِ تُهْدِنَّ، تُجارِنَّ، تَنْثَنِنَّ، تَكْتَفِنَّ، تَسْتَغْنِنَّ، تَعْرَوْرِنَّ)
        substitutions.add(new InfixSubstitution("يِي", "ي")); // EX: (أنتِ تُهْدِينَ، تُجارِينَ، تَنْثَنِينَ، تَكْتَفِينَ، تَسْتَغْنِينَ، تَعْرَوْرِينَ)
        substitutions.add(new InfixSubstitution("يْن", "ين")); // EX: (أنتن تُهْدِينَ، تُجارِينَ، تَنْثَنِينَ، تَكْتَفِينَ، تَسْتَغْنِينَ، تَعْرَوْرِينَ)
        substitutions.add(new InfixSubstitution("ِيُو", "ُو")); // EX: (أنتم تُهْدُونَ، تُجارُونَ، تَنْثَنُونَ، تَكْتَفُونَ، تَسْتَغْنُونَ، تَعْرَوْرُونَ)
        substitutions.add(new InfixSubstitution("ِيُن", "ُن")); // EX: (أنتم تُهْدُنَّ، تُجارُنَّ، تَنْثَنُنَّ، تَكْتَفُنَّ، تَسْتَغْنُنَّ، تَعْرَوْرُنَّ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (kov) {
        case 26:
            switch (formulaNo) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 9:
            case 10:
                return true;
            }

        case 25:
            switch (formulaNo) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 9:
                return true;
            }

        case 24:
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
