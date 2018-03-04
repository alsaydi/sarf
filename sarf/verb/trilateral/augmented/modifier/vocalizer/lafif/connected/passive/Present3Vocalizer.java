package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.passive;

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
public class Present3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present3Vocalizer() {
        substitutions.add(new SuffixSubstitution("жх", "м")); // EX: (нх”ъжум° нх”ужшум° нх”«жум° нхдъџужум° нх”ъ ужум° нх у”«жум° нх у”ужшум° нх”ъ у”ъжум° нхЌъжужшум)
        substitutions.add(new SuffixSubstitution("ужу","ум"));// EX: (бд нх”ъжум° нх”ужшум° нх”«жум° нхдъџужум° нх”ъ ужум° нх у”«жум° нх у”ужшум° нх”ъ у”ъжум° нхЌъжужшум)
        substitutions.add(new SuffixSubstitution("жъ", "")); // EX: (бг нх”ъжу° нх”ужшу° нх”«жу° нхдъџужу° нх”ъ ужу° нх у”«жу° нх у”ужшу° нх”ъ у”ъжу° нхЌъжужшу)
        substitutions.add(new InfixSubstitution("жу«", "ну«")); // EX: (√д г«  х”ъжун«дц°  х”ужшун«д°  х”«жун«д°  хдъџужун«д°  х”ъ ужун«д°  х у”«жун«д°  х у”ужшун«д°  х”ъ у”ъжун«д°  хЌъжужшун«д)
        substitutions.add(new InfixSubstitution("жцн", "нъ")); // EX: (√д ц  х”ъжунъду°  х”ужшунъду°  х”«жунъду°  хдъџужунъду°  х”ъ ужунъду°  х у”«жунъду°  х у”ужшунъду°  х”ъ у”ъжунъду°  хЌъжужшунъду)
        substitutions.add(new InfixSubstitution("жцд", "нцд")); // EX: (√д ц  х”ъжунцдшу°  х”ужшунцдшу°  х”«жунцдшу°  хдъџужунцдшу°  х”ъ ужунцдшу°  х у”«жунцдшу°  х у”ужшунцдшу°  х”ъ у”ъжунцдшу°  хЌъжужшунцдшу)
        substitutions.add(new InfixSubstitution("жхж", "жъ")); // EX: (√д г  х”ъжужъду°  х”ужшужъду°  х”«жужъду°  хдъџужужъду°  х”ъ ужужъду°  х у”«жужъду°  х у”ужшужъду°  х”ъ у”ъжужъду°  хЌъжужшужъду)
        substitutions.add(new InfixSubstitution("жъд", "нъд")); // EX: (√д д  х”ъжунъду°  х”ужшунъду°  х”«жунъду°  хдъџужунъду°  х”ъ ужунъду°  х у”«жунъду°  х у”ужшунъду°  х”ъ у”ъжунъду°  хЌъжужшунъду)
        substitutions.add(new InfixSubstitution("жуд", "нуд")); // EX: ( х”ъжунудшу°  х”ужшунудшу°  х”«жунудшу°  хдъџужунудшу°  х”ъ ужунудшу°  х у”«жунудшу°  х у”ужшунудшу°  х”ъ у”ъжунудшу°  хЌъжужшунудшу)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        if (root.getC2() == root.getC3() && root.getC3() == 'ж' && kov == 28) {
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
