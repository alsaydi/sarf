package sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;

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
        substitutions.add(new SuffixSubstitution("óíó","óì"));// EX: (Ñãì¡ ÃÊì¡ ÓÚì¡ äÃì¡ ÃÈì )
        substitutions.add(new InfixSubstitution("óíõæÇ","óæúÇ"));// EX: (ÑóãóæúÇ¡ ÃÊóæúÇ¡ ÓóÚóæúÇ¡ äÃæúÇ¡ ÃÈóæúÇ)
        substitutions.add(new InfixSubstitution("óíóÊ","óÊ"));// EX: (ÑóãóÊú¡ ÑóãóÊóÇ¡ ÃÊóÊú¡ ÃÊóÊóÇ¡ ÓóÚóÊú¡ ÓóÚóÊóÇ¡ äóÃÊú¡ äÃÊóÇ¡ ÃÈóÊú¡ ÃÈóÊóÇ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return (kov == 24 || kov == 25 || kov == 26) && (noc == 2 || noc == 3);
    }
}
