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
public class Present3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present3Vocalizer() {
        substitutions.add(new SuffixSubstitution("íõ", "Ç")); // EX: (íóÊóÍóÇíóÇ¡ íóÊóÍóíøóÇ)
        substitutions.add(new SuffixSubstitution("óíó","óÇ"));// EX: (áä íóÊóÍóÇíóÇ¡ áä íÊóÍóíøóÇ)
        substitutions.add(new SuffixSubstitution("íú", "")); // EX: (áã íóÊóÍóÇíó¡ áã íóÊóÍóíøó)
        substitutions.add(new InfixSubstitution("íöí", "íú")); // EX: (ÃäÊö ÊóÊóÍóÇíóíúäó¡ ÊóÊóÍóíøóíúäó)
        substitutions.add(new InfixSubstitution("íõæ", "æú")); // EX: (ÃäÊã ÊóÊóÍÇíóæúäó¡ ÊóÊóÍóíøóæúäó)
        substitutions.add(new InfixSubstitution("íõä", "æõä")); // EX: (ÃäÊã ÊóÊóÍÇíóæõäøó¡ ÊóÊóÍóíøóæõäøó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'í' && kov == 28 && (formulaNo == 7 || formulaNo == 8);
    }
}
