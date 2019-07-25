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
public class PastVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private List<Substitution> substitutions = new ArrayList<>();

    public PastVocalizer() {
        substitutions.add(new SuffixSubstitution("يَ","ى"));// EX: (هو أهدى، رقَّى، جارى، انثنى، اكتفى، تناسى، ترقَّى، استغنى، اعرورى، اجْأوَّى)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (هم أهدَوْا، رقَّوْا، جارَوْا، انثنَوْا، اكتفَوْا، تناسَوْا، ترقَّوْا، استغنَوْا، اعرَوْرَوا، اجأوَّوْا)
        substitutions.add(new InfixSubstitution("يَت", "ت")); // EX: (هي أهدَتْ، رقَّتْ ، جارَتْ، انثنَتْ، اكتفَتْ، تناسَتْ، ترقَّتْ ، استغنَتْ، اعْرَوْرَتْ ، اجأوَّتْ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if ((kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain || kov == KindOfVerb.Naqis_Yaee) && formulaNo == 4) return true;
        if (kov == KindOfVerb.Naqis_Yaee &&  formulaNo == 10) return true;
        if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain  && formulaNo == 11) return true;

        if (kov == 24 || kov == 25 || kov == KindOfVerb.Naqis_Yaee) {
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
