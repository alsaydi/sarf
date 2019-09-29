package sarf.noun.trilateral.unaugmented.modifier.assimilate.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.noun.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.ConjugationResult;

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
public class Vocalizer32 extends TrilateralNounSubstitutionApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Vocalizer32() {
        substitutions.add(new InfixSubstitution("ِيي","ِيّ"));// EX: (غَنِيّ، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        return nounFormula.equals("فَعِيل") && (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa || kov == KindOfVerb.Naqis_Yaee || kov == KindOfVerb.Lafeef_Maqroon) && noc == Conjugation.Forth;
    }

}
