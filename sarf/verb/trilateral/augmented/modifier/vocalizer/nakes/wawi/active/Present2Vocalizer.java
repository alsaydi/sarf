package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

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
        substitutions.add(new SuffixSubstitution("æõ", "ì")); // EX: (åæ íóÊóÓÇãóì¡ íóÊóÒóßøóì)
        substitutions.add(new SuffixSubstitution("æó", "ì")); // EX: (áä íóÊóÓÇãóì¡ íóÊóÒóßøóì)
        substitutions.add(new SuffixSubstitution("æú", "")); // EX: (áã íóÊóÓÇãó¡ íóÊóÒóßøó)
        substitutions.add(new InfixSubstitution("æó", "íó")); // EX: (ÃäÊãÇ ÊÊÓÇãóíÇä¡ ÊÊÒßøóíÇä)
        substitutions.add(new InfixSubstitution("æöí", "íú")); // EX: (ÃäÊö ÊÊÓÇãóíúäó¡ ÊÊÒóßøóíúäó)
        substitutions.add(new InfixSubstitution("æöä", "íöä")); // EX: (ÃäÊö ÊÊÓÇãóíöäøó¡ ÊÊÒóßøóíöäøó)
        substitutions.add(new InfixSubstitution("æõæ", "æú")); // EX: (ÃäÊã ÊÊÓÇãóæúäó¡ ÊÊÒóßøóæúäó)
        substitutions.add(new InfixSubstitution("æúä","íúä"));// EX: (ÃäÊä ÊÊÓÇãóíúäó¡ ÊÊÒóßøóíúäó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (kov) {
        case 21:
        case 22:
        case 23:
            switch (formulaNo) {
            case 7:
            case 8:
                return true;
            }
        }
        return false;
    }
}
