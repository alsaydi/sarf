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
public class Imperative2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Vocalizer() {

        substitutions.add(new SuffixSubstitution("æú",""));// EX: (ÊóÓÇãó¡ ÊóÒóßøó)
        substitutions.add(new InfixSubstitution("æöí","íú"));// EX: (ÃäÊö ÊÓÇãóíú¡ ÊÒóßøóíú)
        substitutions.add(new InfixSubstitution("æöä","íöä"));// EX: (ÃäÊö ÊÓÇãóíöäøó¡ ÊÒóßøóíöäøó)
        substitutions.add(new InfixSubstitution("æõæ","æú"));// EX: (ÃäÊã ÊÓÇãóæúÇ¡ ÊÒóßøóæúÇ)
        substitutions.add(new InfixSubstitution("æúä","íúä"));// EX: (ÃäÊä ÊÓÇãóíúäó¡ ÊÒóßøóíúäó)
        substitutions.add(new InfixSubstitution("æó","íó"));// EX: (ÃäÊãÇ ÊÓÇãóíÇ¡ ÊÒßøóíÇ)
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
