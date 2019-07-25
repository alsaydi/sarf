package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.passive;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
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
public class Present3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present3Vocalizer() {
        substitutions.add(new SuffixSubstitution("وُ", "ى")); // EX: (يُسْوَى، يُسَوَّى، يُساوَى، يُنْغَوَى، يُسْتَوَى، يُتَساوَى، يُتَسَوَّى، يُسْتَسْوَى، يُحْوَوَّى)
        substitutions.add(new SuffixSubstitution("َوَ","َى"));// EX: (لن يُسْوَى، يُسَوَّى، يُساوَى، يُنْغَوَى، يُسْتَوَى، يُتَساوَى، يُتَسَوَّى، يُسْتَسْوَى، يُحْوَوَّى)
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (لم يُسْوَ، يُسَوَّ، يُساوَ، يُنْغَوَ، يُسْتَوَ، يُتَساوَ، يُتَسَوَّ، يُسْتَسْوَ، يُحْوَوَّ)
        substitutions.add(new InfixSubstitution("وَا", "يَا")); // EX: (أنتما تُسْوَيانِ، تُسَوَّيان، تُساوَيان، تُنْغَوَيان، تُسْتَوَيان، تُتَساوَيان، تُتَسَوَّيان، تُسْتَسْوَيان، تُحْوَوَّيان)
        substitutions.add(new InfixSubstitution("وِي", "يْ")); // EX: (أنتِ تُسْوَيْنَ، تُسَوَّيْنَ، تُساوَيْنَ، تُنْغَوَيْنَ، تُسْتَوَيْنَ، تُتَساوَيْنَ، تُتَسَوَّيْنَ، تُسْتَسْوَيْنَ، تُحْوَوَّيْنَ)
        substitutions.add(new InfixSubstitution("وِن", "يِن")); // EX: (أنتِ تُسْوَيِنَّ، تُسَوَّيِنَّ، تُساوَيِنَّ، تُنْغَوَيِنَّ، تُسْتَوَيِنَّ، تُتَساوَيِنَّ، تُتَسَوَّيِنَّ، تُسْتَسْوَيِنَّ، تُحْوَوَّيِنَّ)
        substitutions.add(new InfixSubstitution("وُو", "وْ")); // EX: (أنتم تُسْوَوْنَ، تُسَوَّوْنَ، تُساوَوْنَ، تُنْغَوَوْنَ، تُسْتَوَوْنَ، تُتَساوَوْنَ، تُتَسَوَّوْنَ، تُسْتَسْوَوْنَ، تُحْوَوَّوْنَ)
        substitutions.add(new InfixSubstitution("وْن", "يْن")); // EX: (أنتن تُسْوَيْنَ، تُسَوَّيْنَ، تُساوَيْنَ، تُنْغَوَيْنَ، تُسْتَوَيْنَ، تُتَساوَيْنَ، تُتَسَوَّيْنَ، تُسْتَسْوَيْنَ، تُحْوَوَّيْنَ)
        substitutions.add(new InfixSubstitution("وَن", "يَن")); // EX: (تُسْوَيَنَّ، تُسَوَّيَنَّ، تُساوَيَنَّ، تُنْغَوَيَنَّ، تُسْتَوَيَنَّ، تُتَساوَيَنَّ، تُتَسَوَّيَنَّ، تُسْتَسْوَيَنَّ، تُحْوَوَّيَنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        if (root.getC2() == root.getC3() && root.getC3() == 'و' && kov == KindOfVerb.Lafeef_Maqroon) {
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
        }

        return false;
    }
}
