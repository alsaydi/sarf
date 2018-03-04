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
public class Present9Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present9Vocalizer() {
        substitutions.add(new SuffixSubstitution("æõ", "ì")); // EX: (íóÊóÓÇæóì¡ íóÊóÓóæøóì)
        substitutions.add(new SuffixSubstitution("æú", "")); // EX: (áã íóÊóÓÇæó¡ áã íóÊóÓóæøó)
        substitutions.add(new SuffixSubstitution("æó", "ì")); // EX: (áä íóÊóÓÇæóì¡ áä íÊÓæøóì)
        substitutions.add(new InfixSubstitution("æóÇ", "íóÇ")); // EX: (ÃäÊãÇ ÊóÊóÓÇæóíÇäö¡ ÊÊÓæøóíÇäö)
        substitutions.add(new InfixSubstitution("æöí", "íú")); // EX: (ÃäÊö ÊóÊóÓÇæóíúäó¡ ÊÊÓæøóíúäó)
        substitutions.add(new InfixSubstitution("æöä", "íöä")); // EX: (ÃäÊö ÊóÊóÓÇæóíöäøó¡ ÊÊÓæøóíöäøó)
        substitutions.add(new InfixSubstitution("æõæ", "æú")); // EX: (ÃäÊã ÊóÊóÓÇæóæúäó¡ ÊÊÓæøóæúäó)
        substitutions.add(new InfixSubstitution("æúä", "íúä")); // EX: (ÃäÊä ÊóÊóÓÇæóíúäó¡ ÊÊÓæøóíúäó)
        substitutions.add(new InfixSubstitution("æóä", "íóä")); // EX: (ÊóÊóÓÇæóíóäó¡ ÊÊÓæøóíóäó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'æ' &&  kov == 28 && (formulaNo == 7 || formulaNo == 8);
    }
}
