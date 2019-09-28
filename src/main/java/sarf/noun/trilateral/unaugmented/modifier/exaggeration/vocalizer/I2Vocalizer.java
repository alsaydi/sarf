package sarf.noun.trilateral.unaugmented.modifier.exaggeration.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.noun.*;

import sarf.verb.trilateral.Substitution.*;
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
public class I2Vocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public I2Vocalizer() {
        substitutions.add(new InfixSubstitution("ِيٌ","ٍ"));// EX: (هذا مَضٍ، عَوٍ، وَقٍ)
        substitutions.add(new InfixSubstitution("ِيٍ","ٍ"));// EX: (مررتُ على مَضٍ)
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (هذا المَضِي، )
        substitutions.add(new SuffixSubstitution("ِيَ","ِيَ"));// EX: (رأيتُ المَضِيَ، )
        substitutions.add(new SuffixSubstitution("ِيِ","ِي"));// EX: (مررتُ على المَضِي ، )
        substitutions.add(new InfixSubstitution("ِيُ","ُ"));// EX: (مَضُونَ، )
        substitutions.add(new InfixSubstitution("ِيِ","ِ"));// EX: (مَضِينَ، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        if (!nounFormula.equals("فَعِل")) {
            return false;
        }

        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        if (kov == KindOfVerb.Naqis_Yaee) {
            switch (noc) {
                case Second:
                case Third:
                case Forth:
                    return true;
            }

            return false;
        } else if (kov == KindOfVerb.Lafeef_Maqroon) {
            return noc == Conjugation.Second || noc == Conjugation.Forth;
        } else if (kov == KindOfVerb.Lafeef_Mafrooq) {
            switch (noc) {
                case Second:
                case Forth:
                case Sixth:
                    return true;
            }
        }
        return false;
    }
}
