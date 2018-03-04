package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.passive;

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
        substitutions.add(new SuffixSubstitution("жх", "м")); // EX: (нхѕъдум° нх”угшум° нЌ«»ум° н— ÷м° н—Џжум° нх ”«гм° нх “яшум° н” —÷м° нЌбжбм)
        substitutions.add(new SuffixSubstitution("жу", "м")); // EX: (бд нхѕъдум° нх”угшум° нЌ«»ум° н— ÷м° нх ”«гм° нх “яшум° н” —÷м° нЌбжбм)
        substitutions.add(new SuffixSubstitution("жъ", "")); // EX: (бг нхѕъду° нх”угшу° нЌ«»у° н— ÷у° н—Џжу° нх ”«гу° нх “яшу° н” —÷у° нЌбжбу)
        substitutions.add(new InfixSubstitution("жцн", "нъ")); // EX: (√д ц  хѕъдунъду°  х”угшунъд°  Ќ«»унд°  — ÷унд°  х ”«гунд°  х “яшунд°  ” —÷унд°  Ќбжбунд)
        substitutions.add(new InfixSubstitution("жу«", "ну«")); // EX: (√д г«  хѕъдун«д°  х”угшун«д°  Ќ«»ун«д°  — ÷ун«д°  х ”«гун«д°  х “яшун«д°  ” —÷ун«д°  Ќбжбун«д)
        substitutions.add(new InfixSubstitution("жхж", "жъ")); // EX: (√д г  хѕъдужъд°  х”угшужъд°  Ќ«»ужъд°  — ÷ужъд°  х ”«гужъд°  х “яшужъд°  ” —÷ужъд°  Ќбжбужъд)
        substitutions.add(new InfixSubstitution("жъд", "нъд")); // EX: (√д д  хѕъдунъду°  х”угшунъд°  Ќ«»унд°  — ÷унд°  х ”«гунд°  х “яшунд°  ” —÷унд°  Ќбжбунд)
        substitutions.add(new InfixSubstitution("жуд", "нуд")); // EX: (еж нхѕъдунудшу° нх”угшунудшу° нЌ«»унудшу° н— ÷унудшу° нх ”«гунудшу° нх “яшунудшу° н” —÷унудшу° нЌбжбунудшу)
        substitutions.add(new InfixSubstitution("жцд", "нцд")); // EX: (√д ц  хѕъдунцдшу°  х”угшунцдшу°  Ќ«»унцдшу°  — ÷унцдшу°  х ”«гунцдшу°  х “яшунцдшу°  ” —÷унцдшу°  Ќбжбунцдшу)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (kov) {
        case 21:
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

        case 22:
            switch (formulaNo) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                return true;
            }

        case 23:
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

        }
        return false;
    }
}
