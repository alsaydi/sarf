package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class Imperative3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative3Vocalizer() {
        substitutions.add(new SuffixSubstitution("íú", "")); // EX: (æóÕøö)
        substitutions.add(new InfixSubstitution("íöí", "í")); // EX: (ÃäÊö æóÕøöí)
        substitutions.add(new InfixSubstitution("íöä", "ä")); // EX: (ÃäÊö æóÕøöäøó)
        substitutions.add(new InfixSubstitution("íúä", "íä")); // EX: (ÃäÊä æóÕøöíäó)
        substitutions.add(new InfixSubstitution("øöíõ", "øõ")); // EX: (ÃäÊã æóÕøõæÇ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == 30 && formulaNo == 2);
    }
}
