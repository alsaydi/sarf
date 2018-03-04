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
public class YaeiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public YaeiNakesLafifVocalizer() {

        substitutions.add(new SuffixSubstitution("óíõ","óì"));// EX: (åĞÇ ÇáãöÓÑì )
        substitutions.add(new SuffixSubstitution("óíó","óì"));// EX: (ÑÃíÊ ÇáãöÓÑì)
        substitutions.add(new SuffixSubstitution("óíö","óì"));// EX: (ßÇáãöÓÑì )
        substitutions.add(new InfixSubstitution("óíñ","ğì"));// EX: (åĞÇ ãöÓÑğì )
        substitutions.add(new InfixSubstitution("óíğÇ","ğì"));// EX: (ÑÃíÊ ãöÓÑğì)
        substitutions.add(new InfixSubstitution("óíò","ğì"));// EX: (ßóãöÓÑğì )
        substitutions.add(new InfixSubstitution("ÇíğÇ","ÇÁğ"));// EX: (ãöÓÑÇÁğ)
        substitutions.add(new InfixSubstitution("óíóÉ","óÇÉ"));// EX: (ãöÓÑÇÉ )
        substitutions.add(new InfixSubstitution("óíóÊ","óÇÊ"));// EX: (ãöÓÑÇÊÇä )
        substitutions.add(new InfixSubstitution("Çí","ÇÁ"));// EX: (ãöÓÑÇÁ )

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC3() != 'í')
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
