package sarf.verb.trilateral.unaugmented.modifier.vocalizer.mithal;

import java.util.*;

import sarf.Conjugation;
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
public class WawiPassivePresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private List<Substitution> substitutions = new ArrayList<>();

    public WawiPassivePresentVocalizer() {
        substitutions.add(new InfixSubstitution("ُوْ","ُو"));// EX: (يُوعَدُ، يُوهَبُ، يُورَثُ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return (kov == 9  && noc == Conjugation.Second) ||
                (kov == 10 && (noc == Conjugation.Third || noc == Conjugation.Forth || noc == Conjugation.Fifth)) ||
                (kov == 11 && (noc == Conjugation.Second || noc == Conjugation.Third || noc == Conjugation.Forth || noc == Conjugation.Fifth));
    }
}
