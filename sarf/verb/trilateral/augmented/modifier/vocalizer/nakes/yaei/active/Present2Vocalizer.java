package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active;

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
        substitutions.add(new SuffixSubstitution("óíõ", "óì")); // EX: (íóÊóäÇÓóì¡ íóÊóÑóŞøóì)
        substitutions.add(new SuffixSubstitution("íó", "ì")); // EX: (áä íóÊóäÇÓóì¡ íóÊóÑóŞøóì)
        substitutions.add(new SuffixSubstitution("íú", "")); // EX: (áã íóÊóäÇÓó¡ íóÊóÑóŞøó)
        substitutions.add(new InfixSubstitution("íöí", "íú")); // EX: (ÃäÊö ÊóÊóäÇÓóíúäó¡ ÊóÊóÑóŞøóíúäó)
        substitutions.add(new InfixSubstitution("íõæ", "æú")); // EX: (ÃäÊã ÊóÊóäÇÓóæúäó¡ ÊóÊóÑóŞøóæúäó)
        substitutions.add(new InfixSubstitution("íõä", "æõä")); // EX: (ÃäÊã ÊóÊóäÇÓóæõäøó¡ ÊóÊóÑóŞøóæõäøó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == 26 || kov == 24 || kov == 25) && (formulaNo == 7 || formulaNo == 8);
    }
}
