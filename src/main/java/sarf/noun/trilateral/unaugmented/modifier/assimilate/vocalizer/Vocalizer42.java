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
public class Vocalizer42 extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Vocalizer42() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (هذا الصّدِي )
        substitutions.add(new SuffixSubstitution("ِيَ","ِيَ"));// EX: (رأيتُ الصّدِيَ)
        substitutions.add(new SuffixSubstitution("ِيِ","ِي"));// EX: (مررت على الصّدِي)
        substitutions.add(new InfixSubstitution("ِيٌ","ٍ"));// EX: (هذا صَدٍ، )
        substitutions.add(new InfixSubstitution("ِيٍ","ٍ"));// EX: (مررت على صَدٍ، )
        substitutions.add(new InfixSubstitution("ِيُو","ُو"));// EX: (صَدُونَ، )
        substitutions.add(new InfixSubstitution("ِيِي","ِي"));// EX: (صَدِينَ )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        return nounFormula.equals("فَعِل") && (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa || kov == KindOfVerb.Naqis_Yaee || kov == KindOfVerb.Lafeef_Maqroon) && noc == Conjugation.Forth;
    }

}
