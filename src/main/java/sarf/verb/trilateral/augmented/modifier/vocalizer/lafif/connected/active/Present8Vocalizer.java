package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import sarf.KindOfVerb;
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
public class Present8Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private List<Substitution> substitutions = new ArrayList<>();

    public Present8Vocalizer() {
        substitutions.add(new SuffixSubstitution("وُ", "ي")); // EX: (يُسَوِّي، يَحْوَوِّي)
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (لم يُسَوِّ، لم يَحْوَوِّ)
        substitutions.add(new InfixSubstitution("وِّوِ", "وِّ")); // EX: (أنتِ تُسَوِّينَ، تَحْوَوِّينَ)
        substitutions.add(new InfixSubstitution("ِّوَ", "ِّيَ")); // EX: (أنتما تُسَوِّيانِ، تَحْوَوِّيانِ، لن يُسَوِّيَ، لن يَحْوَوِّيَ)
        substitutions.add(new InfixSubstitution("ِّوُ", "ُّ")); // EX: (أنتم تُسَوُّونَ، تَحْوَوُّونَ)
        substitutions.add(new InfixSubstitution("ِّوْ", "ِّي")); // EX: (أنتن تُسَوِّينَ، تَحْوَوِّينَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'و' &&  kov == 28 && (formulaNo == 2 || formulaNo == 11);
    }
}
