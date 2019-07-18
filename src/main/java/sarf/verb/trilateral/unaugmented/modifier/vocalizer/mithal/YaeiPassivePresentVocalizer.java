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
public class YaeiPassivePresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private List<Substitution> substitutions = new ArrayList<>();

    public YaeiPassivePresentVocalizer() {
        substitutions.add(new InfixSubstitution("ُيْ","ُو"));// EX: (يُوسَرُ، يوقَظُ، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return (kov == 12  && (noc == Conjugation.Second || noc == Conjugation.Forth)) ||
                (kov == 13  && (noc == Conjugation.Forth || noc == Conjugation.Sixth)) ||
                (kov == 14 && (noc == Conjugation.First || noc == Conjugation.Second || noc == Conjugation.Third || noc == Conjugation.Forth || noc == Conjugation.Fifth || noc == Conjugation.Sixth));
    }
}
