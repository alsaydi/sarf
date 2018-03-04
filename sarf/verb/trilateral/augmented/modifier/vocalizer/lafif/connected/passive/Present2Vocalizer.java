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
public class Present2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present2Vocalizer() {
        substitutions.add(new SuffixSubstitution("унх","ум"));// EX: (нх–ъжум° нхёужшум° нхѕ«жум° нхдъ“ужум° нхЌъ ужум° нх уѕу«жум° нх уёужшум° нх”ъ уеъжум)
        substitutions.add(new SuffixSubstitution("ну","м"));// EX: (бд нх–ъжум° нхёужшум° нхѕ«жум° нхдъ“ужум° нхЌъ ужум° нх уѕу«жум° нх уёужшум° нх”ъ уеъжум)
        substitutions.add(new SuffixSubstitution("нъ",""));// EX: (бг нх–ъжу° нхёужшу° нхѕ«жу° нхдъ“ужу° нхЌъ ужу° нх уѕу«жу° нх уёужшу° нх”ъ уеъжу)
        substitutions.add(new InfixSubstitution("нцн","нъ"));// EX: (√д ц  х–ъжунъду°  хёужшунъду°  ѕ«жунъду°  дъ“ужунъду°  Ќ жнд°   ѕ«жнд°   ёжнд°  ” ежнд)
        substitutions.add(new InfixSubstitution("нхж","жъ"));// EX: (√д г  х–ъжужъду°  хёужшужъду°  ѕ«жужъду°  дъ“ужужъду°  Ќ жужъду°   ѕ«жужъду°   ёжшужъд°  х”ъ уеъжужъду)
        substitutions.add(new InfixSubstitution("нхдш","жхдш"));// EX: (√д г  х–ъжужхдшу°  хёужшужхдшу°  ѕ«жужхдшу°  дъ“ужужхдшу°  Ќ жужхдшу°   ѕ«жужхдшу°   ёжшужхдшу°  х”ъ уеъжужхдшу)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        if (root.getC2() == 'ж' && root.getC3() == 'н') {
            switch (kov) {
            case 27:
                switch (formulaNo) {
                case 1:
                case 2:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
                }

            case 28:
                switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
                }
            }
        }


        return false;
    }
}
