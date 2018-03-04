package sarf.noun.trilateral.unaugmented.modifier.instrumental.vocalizer;

import java.util.*;

import sarf.noun.*;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.Substitution.*;

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
public class WawiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public WawiNakesLafifVocalizer() {
        substitutions.add(new SuffixSubstitution("óæõ", "óì")); // EX: (åĞÇ ÇáãöÛúÒóì )
        substitutions.add(new SuffixSubstitution("óæó", "óì")); // EX: (ÑÃíÊ ÇáãöÛúÒóì )
        substitutions.add(new SuffixSubstitution("óæö", "óì")); // EX: (ßÇáãöÛúÒóì )
        substitutions.add(new InfixSubstitution("óæñ", "ğì")); // EX: (åĞÇ ãöÛúÒğì )
        substitutions.add(new InfixSubstitution("óæğÇ", "ğì")); // EX: (ÑÃíÊ ãöÛúÒğì )
        substitutions.add(new InfixSubstitution("óæò", "ğì")); // EX: (ßóãöÛúÒğì )
        substitutions.add(new InfixSubstitution("ÇæğÇ", "ÇÁğ")); // EX: (ãöÛúÒÇÁğ)
        substitutions.add(new InfixSubstitution("óæóÉ", "óÇÉ")); // EX: (ãöÛúÒÇÉ )
        substitutions.add(new InfixSubstitution("óæóÊ", "óÇÊ")); // EX: (ãöÛúÒÇÊÇä )
        substitutions.add(new InfixSubstitution("óæó", "óíó")); // EX: (ãöÛúÒóíÇä )
        substitutions.add(new InfixSubstitution("Çæ","ÇÁ"));// EX: (ãöÛúÒÇÁ )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC3() != 'æ')
            return false;

        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        switch (kov) {
        case 21:
            return noc == 1 || noc == 5;
        case 22:
            return noc == 1 || noc == 3;
        case 23:
            switch (noc) {
            case 1:
            case 3:
            case 4:
            case 5:
                return true;
            }

        case 24:
        case 26:
            switch (noc) {
            case 2:
            case 3:
            case 4:
                return true;
            }

        case 25:
            return noc == 3 || noc == 4;

        case 27:
        case 29:
            return noc == 2;
        case 28:
            return noc == 2 || noc == 4;
        case 30:
            switch (noc) {
            case 2:
            case 4:
            case 6:
                return true;
            }

        }
        return false;
    }

}
