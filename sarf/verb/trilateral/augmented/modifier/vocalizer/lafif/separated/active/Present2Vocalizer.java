package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active;

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
public class Present2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present2Vocalizer() {
        substitutions.add(new SuffixSubstitution("нх", "м")); // EX: (ну уж«—ум° ну ужубшум)
        substitutions.add(new SuffixSubstitution("уну","ум"));// EX: (бд ну уж«—ум° ну ужубшум)
        substitutions.add(new SuffixSubstitution("нъ", "")); // EX: (бг ну уж«—у° ну ужубшу)
        substitutions.add(new InfixSubstitution("нцн", "нъ")); // EX: (√д ц  у уж«—унъду°  у ужубшунъду)
        substitutions.add(new InfixSubstitution("нхж", "жъ")); // EX: (√д г  у уж«—ужъду°  у ужубшужъду)
        substitutions.add(new InfixSubstitution("нхд", "жхд")); // EX: (√д г  у уж«—ужхдшу°  у ужубшужхдшу)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == 29 && formulaNo == 7) || (kov == 30 && (formulaNo == 7 || formulaNo == 8));
    }
}
