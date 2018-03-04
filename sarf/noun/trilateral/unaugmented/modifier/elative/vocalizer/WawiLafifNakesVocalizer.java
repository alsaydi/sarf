package sarf.noun.trilateral.unaugmented.modifier.elative.vocalizer;

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
        substitutions.add(new SuffixSubstitution("óæõ","óì"));// EX: (åĞÇ ÇáÃÚáì¡ )
        substitutions.add(new SuffixSubstitution("óæó","óì"));// EX: (ÑÃíÊõ ÇáÃÚáì¡ )
        substitutions.add(new SuffixSubstitution("óæö","óì"));// EX: (ãÑÑÊõ Úáì ÇáÃÚáì¡ )
        substitutions.add(new InfixSubstitution("óæó","óíó"));// EX: (ÇáÃÚáíÇä)
        substitutions.add(new InfixSubstitution("óæõæ","óæú"));// EX: (ÇáÃÚáóæúä)
        substitutions.add(new InfixSubstitution("óæöí","óíú"));// EX: (ÇáÃÚáóíúä)
        substitutions.add(new InfixSubstitution("úæóì","úíóÇ"));// EX: (ÇáÚáíÇ)
        substitutions.add(new InfixSubstitution("úæóí","úíóí"));// EX: (ÚõáúíóíóÇä)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        if (kov != 23) {
            return false;
        }

        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        switch (noc) {
        case 1:
        case 3:
        case 4:
        case 5:
            return true;
        }

        return false;
    }
}
