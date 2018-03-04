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
public class Imperative2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Vocalizer() {
        substitutions.add(new SuffixSubstitution("íú", "")); // EX: (ÊóæÇÑó¡ Êóæóáøó)
        substitutions.add(new InfixSubstitution("íöí", "íú")); // EX: (ÃäÊö ÊóæÇÑóíú¡ Êóæóáøóíú)
        substitutions.add(new InfixSubstitution("íõæ", "æú")); // EX: (ÃäÊã ÊóæóÇÑóæúÇ¡ ÊóæóáøóæúÇ)
        substitutions.add(new InfixSubstitution("íõä", "æõä")); // EX: (ÃäÊã ÊóæóÇÑóæõäøó¡ Êóæóáøóæõäøó)
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
