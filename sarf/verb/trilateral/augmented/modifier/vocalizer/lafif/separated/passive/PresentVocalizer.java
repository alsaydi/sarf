package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.passive;

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
public class PresentVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PresentVocalizer() {
        substitutions.add(new SuffixSubstitution("унх", "ум")); // EX: (нж’ум° нхжу’шум° нхж«бум° нх шуёум° нх уж«—ум° нх ужубшум° нх”ъ ужъЁум)
        substitutions.add(new SuffixSubstitution("уну", "ум")); // EX: (бд нхж’ум° нхжу’шум° нхж«бум° нх шуёум° нх уж«—ум° нх ужубшум° нх”ъ ужъЁум)
        substitutions.add(new SuffixSubstitution("унъ", "у")); // EX: (бг нхж’у° нхжу’шу° нхж«бу° нх шуёу° нх уж«—у° нх ужубшу° нх”ъ ужъЁу)
        substitutions.add(new InfixSubstitution("унцн", "унъ")); // EX: (√д ц  хж’унъду°  хжу’шунъду°  хж«бунд°  х шуёунд°  х уж«—унд°  х ужубшунд°  х”ъ ужъЁунд)
        substitutions.add(new InfixSubstitution("унхж", "ужъ")); // EX: (√д г  хж’ужъду°  хжу’шужъду°  хж«бужд°  х шуёужд°  х уж«—ужъд°  х ужубшужъд°  х”ъ ужъЁужд)
        substitutions.add(new InfixSubstitution("унхд", "ужхд")); // EX: (√д г  хж’ужхдшу°  хжу’шужхдшу°  хж«бужхдшу°  х шуёужхдшу°  х уж«—ужхдшу°  х ужубшужхдшу°  х”ъ ужъЁужхдшу)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (kov) {
        case 29:
            switch (formulaNo) {
            case 5:
            case 7:
            case 9:
                return true;
            }

        case 30:
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
