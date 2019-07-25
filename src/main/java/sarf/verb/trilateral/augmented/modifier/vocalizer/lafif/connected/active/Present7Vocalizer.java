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
public class Present7Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present7Vocalizer() {
        substitutions.add(new SuffixSubstitution("وُ", "ي")); // EX: (يُسْوِي، يُساوِي، تنغوي، يستوي، يستغوي)
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (لم يُسْوِ، لم يُساوِ، لم ينغوِ، لم يَستوِ، لم يستغوِ)
        substitutions.add(new InfixSubstitution("وِوِ", "وِ")); // EX: (أنتِ تُسْوِينَ، تُساوِينَ، تنغوين، تستوين، تستغوين)
        substitutions.add(new InfixSubstitution("ِوَ", "ِيَ")); // EX: (أنتما تُسْوِيَانِ، تُساوِيانِ، تنغويان، تستويان، تستغويان)
        substitutions.add(new InfixSubstitution("ِوُ", "ُ")); // EX: (أنتم تُسْوُونَ، تُساوُونَ، تنغوُونَ، تستوُونَ، تستغوون)
        substitutions.add(new InfixSubstitution("ِوْ", "ِي")); // EX: (أنتن تُسْوِينَ، تُساوِينَ، تنغوين، تستوين، تستغوين)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        if (root.getC2() == root.getC3() && root.getC3() == 'و' && kov == KindOfVerb.Lafeef_Maqroon) {
            switch (formulaNo) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 9:
                return true;
            }
        }
        return false;
    }
}
