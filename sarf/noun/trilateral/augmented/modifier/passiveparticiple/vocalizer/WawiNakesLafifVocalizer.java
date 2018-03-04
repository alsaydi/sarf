package sarf.noun.trilateral.augmented.modifier.passiveparticiple.vocalizer;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
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
public class WawiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public WawiNakesLafifVocalizer() {
        substitutions.add(new InfixSubstitution("óæóÉ","óÇÉ"));// EX: (ãõÏúäÇÉñ¡)
        substitutions.add(new InfixSubstitution("óæóÊ","óÇÊ"));// EX: (ãõÏúäÇÊÇä¡ ãõÏúäÇÊóíúäö)
        substitutions.add(new InfixSubstitution("óæóÇ","óíóÇ"));// EX: (ãõÏúäóíóÇäö¡ ãõÏúäóíóÇÊñ)
        substitutions.add(new InfixSubstitution("óæóí","óíóí"));// EX: (ãõÏúäóíóíúäö¡)
        substitutions.add(new InfixSubstitution("óæõæ","óæú"));// EX: (ãõÏúäóæúäó)
        substitutions.add(new InfixSubstitution("óæöí","óíú"));// EX: (ãõÏúäóíúäó)
        substitutions.add(new SuffixSubstitution("óæõ","óì"));// EX: (åĞÇ ÇáãõÏúäóì¡)
        substitutions.add(new SuffixSubstitution("óæó","óì"));// EX: (ÑÃíÊõ ÇáãõÏúäóì ¡  )
        substitutions.add(new SuffixSubstitution("óæö","óì"));// EX: (ãÑÑÊõ Úáì ÇáãõÏúäóì ¡ )
        substitutions.add(new InfixSubstitution("óæñ","ğì"));// EX: (åĞÇ ãõÏúäğì)
        substitutions.add(new InfixSubstitution("óæğÇ","ğì"));// EX: (ÑÃíÊõ ãõÏúäğì)
        substitutions.add(new InfixSubstitution("óæò","ğì"));// EX: (ãÑÑÊõ Úáì ãõÏúäğì)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC3() != 'æ')
            return false;

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
            case 11:
                return true;
            }
        }
        return false;
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
