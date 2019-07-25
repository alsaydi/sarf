package sarf.noun.trilateral.augmented.modifier.passiveparticiple.vocalizer;

import java.util.*;

import sarf.KindOfVerb;
import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
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
public class WawiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public WawiNakesLafifVocalizer() {
        substitutions.add(new InfixSubstitution("َوَة","َاة"));// EX: (مُدْناةٌ،)
        substitutions.add(new InfixSubstitution("َوَت","َات"));// EX: (مُدْناتان، مُدْناتَيْنِ)
        substitutions.add(new InfixSubstitution("َوَا","َيَا"));// EX: (مُدْنَيَانِ، مُدْنَيَاتٌ)
        substitutions.add(new InfixSubstitution("َوَي","َيَي"));// EX: (مُدْنَيَيْنِ،)
        substitutions.add(new InfixSubstitution("َوُو","َوْ"));// EX: (مُدْنَوْنَ)
        substitutions.add(new InfixSubstitution("َوِي","َيْ"));// EX: (مُدْنَيْنَ)
        substitutions.add(new SuffixSubstitution("َوُ","َى"));// EX: (هذا المُدْنَى،)
        substitutions.add(new SuffixSubstitution("َوَ","َى"));// EX: (رأيتُ المُدْنَى ،  )
        substitutions.add(new SuffixSubstitution("َوِ","َى"));// EX: (مررتُ على المُدْنَى ، )
        substitutions.add(new InfixSubstitution("َوٌ","ًى"));// EX: (هذا مُدْنًى)
        substitutions.add(new InfixSubstitution("َوًا","ًى"));// EX: (رأيتُ مُدْنًى)
        substitutions.add(new InfixSubstitution("َوٍ","ًى"));// EX: (مررتُ على مُدْنًى)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC3() != 'و')
            return false;

        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa) {
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


            if (formulaNo == 4) {
                return true;
            }


            switch (formulaNo) {
                case 6:
                case 10:
                    return true;
            }


            return formulaNo == 11;
        } else if (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    return true;
            }


            switch (formulaNo) {
                case 2:
                case 6:
                case 9:
                case 10:
                    return true;
            }


            return formulaNo == 11;
        } else if (kov == KindOfVerb.Naqis_Wawi) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    return true;
            }


            return formulaNo == 11;
        } else if (kov == KindOfVerb.Lafeef_Maqroon) {
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

    public List getSubstitutions() {
        return substitutions;
    }
}
