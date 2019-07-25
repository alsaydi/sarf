package sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.noun.*;

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
public class Ajwaf1Vocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private List<Substitution> substitutions = new ArrayList<>();

    public Ajwaf1Vocalizer() {
        substitutions.add(new InfixSubstitution("ْوُو","ُو"));// EX: (مَؤُوب، مَبُوء، مَقُول،)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        return ((kov == 15 || kov == 16) && (noc == Conjugation.First || noc == Conjugation.Forth)
                || (kov == KindOfVerb.Ajwaf_Wawi && (noc == Conjugation.Forth || noc == Conjugation.First || noc == Conjugation.Fifth)));
    }
}
