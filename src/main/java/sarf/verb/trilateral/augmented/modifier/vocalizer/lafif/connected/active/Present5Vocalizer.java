package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

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
public class Present5Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present5Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يُقَوِّي)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يُقَوِّ)
        substitutions.add(new InfixSubstitution("ِّيِ", "ِّ")); // EX: (أنتِ تقوِّينَ)
        substitutions.add(new InfixSubstitution("ِّيُ", "ُّ")); // EX: (أنتم تُقَوُّونَ)
        substitutions.add(new InfixSubstitution("ِّيْ", "ِّي")); // EX: (أنتن تُقَوِّينَ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC2() == 'و' && root.getC3() == 'ي' && (kov == KindOfVerb.Lafeef_Maqroon || kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa) && formulaNo == 2;
    }
}
