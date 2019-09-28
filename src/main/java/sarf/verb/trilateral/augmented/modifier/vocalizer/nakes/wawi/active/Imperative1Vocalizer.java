package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;
import sarf.verb.trilateral.Substitution.*;
import sarf.ConjugationResult;
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
public class Imperative1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative1Vocalizer() {
        substitutions.add(new InfixSubstitution("ِوُو","ُو"));// EX: (أنتم أدْنُوا، حابُوا، انجلُوا، ارتضُوا، ارعَوُوا، استرضُوا، احلَوْلُوا)
        substitutions.add(new InfixSubstitution("ِوُن","ُن"));// EX: (أنتم أدْنُنَّ، حابُنَّ، انجلُنَّ، ارتضُنَّ، ارعَوُنَّ، استرضُنَّ، احلَوْلُنَّ)
        substitutions.add(new SuffixSubstitution("وْ",""));// EX: (أدْنِ، حابِ، انجلِ، ارتضِ، ارعَوِ، استرضِ، احلَوْلِ)
        substitutions.add(new InfixSubstitution("وْن","ين"));// EX: (أنتن أدنِينَ، حابِين، انجلِين، ارتضين، ارعوين، استرضين، احلولين)
        substitutions.add(new InfixSubstitution("ِوِ","ِ"));// EX: (أنتِ أدْنِي، حابِي، انجلِي، ارتضي، ارعوي، استرضي، احلولي)
        substitutions.add(new InfixSubstitution("وَ","يَ"));// EX: (أنتما أدْنِيا، حابِيا، انجلِيا، ارتضيا، ارعويا، استرضيا، احلوليا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if ((kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain || kov == KindOfVerb.Naqis_Wawi) && formulaNo == 4) return true;
        if ((kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa || kov == KindOfVerb.Naqis_Wawi) &&  formulaNo == 9) return true;
        if (kov == KindOfVerb.Naqis_Wawi && (formulaNo == 6 || formulaNo == 10)) return true;

        if (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa || kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain || kov == KindOfVerb.Naqis_Wawi) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 5:
                    return true;
            }
        }
        return false;
    }
}
