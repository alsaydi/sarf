package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted;

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
public class ActivePresent3Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public ActivePresent3Vocalizer() {
        substitutions.add(new SuffixSubstitution("óíõ","óì"));// EX: (íóæúÌóì)
        substitutions.add(new SuffixSubstitution("óíó","óì"));// EX: (áä íóæúÌóì)
        substitutions.add(new SuffixSubstitution("óíú","ó"));// EX: (áã íóæúÌó)
        substitutions.add(new InfixSubstitution("óíöí","óíú"));// EX: (ÃäÊö ÊóæúÌóíúäó)
        substitutions.add(new InfixSubstitution("óíõæ","óæú"));// EX: (ÃäÊã ÊóæúÌóæúäó)
        substitutions.add(new InfixSubstitution("óíõä","óæõä"));// EX: (ÃäÊã ÊóæúÌóæõäøó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return (kov == 30 && noc == 4);
    }
}
