package sarf.noun.trilateral.unaugmented.modifier.activeparticiple.vocalizer;

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
public class WawiLafifNakesVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public WawiLafifNakesVocalizer() {
        substitutions.add(new InfixSubstitution("öæñ", "ò")); // EX: (åĞÇ ÛÇÒò)
        substitutions.add(new InfixSubstitution("öæğ", "öíğ")); // EX: (ÑÃíÊõ ÛÇÒöíğÇ)
        substitutions.add(new InfixSubstitution("öæò", "ò")); // EX: (ãÑÑÊõ Úáì ÛÇÒò)
        substitutions.add(new SuffixSubstitution("öæõ", "öí")); // EX: (åĞÇ ÇáÛÇÒöí¡ ÛÇÒöí ÇáãÏíäÉ¡ )
        substitutions.add(new SuffixSubstitution("öæó", "öíó")); // EX: (ÑÃíÊõ ÇáÛÇÒíó¡ ÛÇÒöíó ÇáãÏíäÉ¡ )
        substitutions.add(new SuffixSubstitution("öæö", "öí")); // EX: (ãÑÑÊõ Úáì ÇáÛÇÒí¡ ÛÇÒöí ÇáãÏíäÉ¡ )
        substitutions.add(new InfixSubstitution("öæó", "öíó")); // EX: (ÛÇÒöíóÉñ¡ ÛÇÒöíÇäö¡ ÛÇÒöíóÊóÇäö¡ ÛÇÒöíÇÊñ¡ )
        substitutions.add(new InfixSubstitution("öæõ", "õ")); // EX: (ÛÇÒõæäó¡ )
        substitutions.add(new InfixSubstitution("öæö", "ö")); // EX: (ÛÇÒöíäó¡ )
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

        case 28:
            return noc == 4;
        }
        return false;
    }
}
