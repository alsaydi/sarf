package sarf.noun.trilateral.unaugmented.modifier.exaggeration.hamza;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.modifier.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.*;

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
public class NakesLafifMahmouz extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public NakesLafifMahmouz() {

        substitutions.add(new InfixSubstitution("ÇÁñ","ÇÁñ"));// EX: (ÛÒøÇÁñ¡ ÑãøóÇÁñ¡ ãöÚØÇÁñ¡ ãöÌäÇÁ¡ ãöÚæÇÁ¡ ãöíİÇÁ)
        substitutions.add(new InfixSubstitution("ÇÁğ","ÇÁğ"));// EX: (ãöÚØÇÁğ ¡  )
        substitutions.add(new InfixSubstitution("ÇÁò","ÇÁò"));// EX: (ãöÚØÇÁò ¡   )
        substitutions.add(new SuffixSubstitution("ÇÁõ","ÇÁõ"));// EX: (ÇáãÚØÇÁõ )
        substitutions.add(new SuffixSubstitution("ÇÁö","ÇÁö"));// EX: (ÇáãÚØÇÁö )
        substitutions.add(new SuffixSubstitution("ÂøóÁõ","ÂøóÁõ"));// EX: (ãóÂøóÁõ )
        substitutions.add(new SuffixSubstitution("ÂøóÁö","ÂøóÁö"));// EX: (ãóÂøóÁö )
        substitutions.add(new InfixSubstitution("ÂøóÁõ","ÂøóÄõ"));// EX: (ãóÂøóÄõæäó )
        substitutions.add(new InfixSubstitution("ÂøóÁö","ÂøóÆö"));// EX: (ãóÂøóÆöíäó )
        substitutions.add(new InfixSubstitution("ÇÁõ","ÇÄõ"));// EX: (ãÚØÇÄæäó )
        substitutions.add(new InfixSubstitution("ÇÁö","ÇÆö"));// EX: (ãÚØÇÆöíäó )

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        if (!nounFormula.equals("İóÚøóÇá")) {
            return false;
        }

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
