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
public class Imperative3Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative3Vocalizer() {
        substitutions.add(new SuffixSubstitution("óíú", "ó")); // EX: (ÃäÊó ÇæúÌó)
        substitutions.add(new InfixSubstitution("óíöí", "óíú")); // EX: (ÃäÊö ÇæúÌóíú)
        substitutions.add(new InfixSubstitution("óíõæ", "óæú")); // EX: (ÃäÊã ÇæúÌóæúÇ)
        substitutions.add(new InfixSubstitution("óíõæ", "óæõ")); // EX: (ÃäÊã ÇæúÌóæõäøó)
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
