package sarf.noun.trilateral.unaugmented.modifier.elative.vocalizer;

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
public class YaeiLafifNakesVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public YaeiLafifNakesVocalizer() {
        substitutions.add(new SuffixSubstitution("óíõ","óì"));// EX: (åĞÇ ÇáÃåÏì¡ )
        substitutions.add(new SuffixSubstitution("óíó","óì"));// EX: (ÑÃíÊõ ÇáÃåÏì¡ )
        substitutions.add(new SuffixSubstitution("óíö","óì"));// EX: (ãÑÑÊõ Úáì ÇáÃåÏì¡ )
        substitutions.add(new InfixSubstitution("óíõæ","óæú"));// EX: (ÇáÃåÏóæúäó)
        substitutions.add(new InfixSubstitution("óíöí","óíú"));// EX: (ÇáÃåÏóíúäó)
        substitutions.add(new InfixSubstitution("úíóì","úíóÇ"));// EX: (ÇáåÏíÇ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        switch (kov) {
        case 26:
            switch (noc) {
            case 2:
            case 3:
            case 4:
                return true;
            }
        case 28:
            return noc == 2 || noc == 4;
        }
        return false;
    }
}
