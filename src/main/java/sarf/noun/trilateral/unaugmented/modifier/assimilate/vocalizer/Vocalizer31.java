package sarf.noun.trilateral.unaugmented.modifier.assimilate.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
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
public class Vocalizer31 extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Vocalizer31() {
        substitutions.add(new InfixSubstitution("ِيو","ِيّ"));// EX: (بهيّ، سويّ، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        //return nounFormula.equals("فَعِيل") && conjugationResult.getRoot().getC3()=='و' &&   (kov == KindOfVerb.Naqis_Wawi && (noc == Conjugation.Forth || noc == Conjugation.Fifth) || (kov == KindOfVerb.Lafeef_Maqroon && noc == Conjugation.Forth));
        return nounFormula.equals("فَعِيل")
                && conjugationResult.getRoot().getC3() == 'و'
                && (kov == KindOfVerb.Naqis_Wawi && (noc == Conjugation.Forth || noc == Conjugation.Fifth)
                || (kov == KindOfVerb.Lafeef_Maqroon && noc == Conjugation.Forth));
    }
}
