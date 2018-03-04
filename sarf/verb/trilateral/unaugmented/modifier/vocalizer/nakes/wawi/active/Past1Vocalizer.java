package sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.util.ArabCharUtil;

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
public class Past1Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Past1Vocalizer() {
        substitutions.add(new SuffixSubstitution("óæó","óÇ"));// EX: (ÛÒÇ¡ ÃÓÇ¡ ÚËÇ)
        substitutions.add(new InfixSubstitution("óæõæÇ","óæúÇ"));// EX: (ÛÒóæúÇ¡ ÃÓæÇ¡ ÚóËóæúÇ)
        substitutions.add(new InfixSubstitution("óæóÊ","óÊ"));// EX: (ÛóÒóÊú¡ ÛóÒóÊóÇ¡ ÃÓóÊú¡ ÃÓóÊóÇ¡ ÚóËóÊú¡ ÚóËóÊóÇ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return (kov == 21 || kov == 23) && (noc == 1 || noc == 3);
    }
}
