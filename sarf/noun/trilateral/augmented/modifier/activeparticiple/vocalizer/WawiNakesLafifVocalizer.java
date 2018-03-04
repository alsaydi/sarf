package sarf.noun.trilateral.augmented.modifier.activeparticiple.vocalizer;

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
        substitutions.add(new SuffixSubstitution("öæõ", "öí")); // EX: (åĞÇ ÇáãõÏúäöí¡)
        substitutions.add(new SuffixSubstitution("öæó", "öíó")); // EX: (ÑÃíÊõ ÇáãõÏúäöíó¡  )
        substitutions.add(new SuffixSubstitution("öæö", "öí")); // EX: (ãÑÑÊõ Úáì ÇáãõÏúäöí¡ )
        substitutions.add(new InfixSubstitution("öæñ", "ò")); // EX: (åĞÇ ãõÏúäò)
        substitutions.add(new InfixSubstitution("öæò", "ò")); // EX: (ãÑÑÊõ Úáì ãõÏúäò)
        substitutions.add(new InfixSubstitution("öæğ", "öíğ")); // EX: (ÑÃíÊõ ãõÏúäöíğÇ)
        substitutions.add(new InfixSubstitution("öæó", "öíó")); // EX: (ãõÏúäöíóÉñ¡ ãõÏúäöíÇä¡ ãõÏúäöíÊÇä¡ ãõÏúäöíÇÊ¡ )
        substitutions.add(new InfixSubstitution("öæõ", "õ")); // EX: (ãõÏúäõæäó¡ )
        substitutions.add(new InfixSubstitution("öæö", "ö")); // EX: (ãõÏúäöíäó¡ )
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
