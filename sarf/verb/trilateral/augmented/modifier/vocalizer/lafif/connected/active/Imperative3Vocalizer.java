package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

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
public class Imperative3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative3Vocalizer() {
        substitutions.add(new SuffixSubstitution("íú", "")); // EX: (ÊÍÇíó¡ ÊÏÇæó¡ ÊóÍóíøó¡ ÊóŞóæøó)
        substitutions.add(new InfixSubstitution("íöí", "íú")); // EX: (ÃäÊö ÊóÍÇíóíú¡ ÊóÏÇæóíú¡ ÊóÍóíøóíú¡ ÊóŞóæøóíú)
        substitutions.add(new InfixSubstitution("íõæ", "æú")); // EX: (ÃäÊã ÊóÍÇíóæúÇ¡ ÊóÏóÇæóæúÇ¡ ÊóÍóíøóæúÇ¡ ÊóŞóæøóæúÇ)
        substitutions.add(new InfixSubstitution("íõä","æõä"));// EX: (ÃäÊã ÊóÍÇíóæõäøó¡ ÊÏÇæóæõäøó¡ ÊóÍóíøóæõäøó¡ ÊóŞóæøóæõäøó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        return (root.getC2() == 'æ' || root.getC2() == 'í') && root.getC3() == 'í' && (kov == 27 || kov == 28) && (formulaNo == 7 || formulaNo == 8);
    }
}
