package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.connected;

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
public class PassivePastVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PassivePastVocalizer() {
        substitutions.add(new InfixSubstitution("öíú", "öí"));
        substitutions.add(new InfixSubstitution("öæú", "öí"));
        substitutions.add(new InfixSubstitution("öæó", "öíó"));
        substitutions.add(new InfixSubstitution("öíõ", "õ"));
        substitutions.add(new InfixSubstitution("öæõ", "õ"));

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 27 || kov == 28) && (noc == 2)) || (kov == 28 && noc == 4);
    }
}
