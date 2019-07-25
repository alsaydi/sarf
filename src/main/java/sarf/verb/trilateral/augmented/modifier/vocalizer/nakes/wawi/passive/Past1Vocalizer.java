package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.passive;

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
public class Past1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private List<Substitution> substitutions = new ArrayList<>();

    public Past1Vocalizer() {
        substitutions.add(new InfixSubstitution("وْ", "ي")); // EX: (أنا أُدْنِيتُ، حُوبِيتُ، انجُليت، ارتضيت، تُسُومِيتُ، استُرْضِيتُ، احْلُولِيتُ)
        substitutions.add(new InfixSubstitution("وَ", "يَ")); // EX: (هو أُدْنِيَ، حُوبِيَ، انجُلِيَ، ارتضيَ، تُسُومِيَ، استُرْضِيَ، احْلُولِيَ)
        substitutions.add(new InfixSubstitution("ِوُ", "ُ")); // EX: (هم أُدْنُوا، حُوبُوا، انجُلُوا، ارتضُوا، تُسُومُوا، استُرْضُوا، احْلُولُوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 7:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 9:
                case 10:
                    return true;
            }
        } else if (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 7:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 9:
                case 10:
                    return true;
            }
        } else if (kov == KindOfVerb.Naqis_Wawi) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 9:
                case 10:
                    return true;
            }
        }
        return false;
    }
}
