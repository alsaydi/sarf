package sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.active;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.*;

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
public class PresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PresentVocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يرمي)
        substitutions.add(new SuffixSubstitution("ِيْ","ِ"));// EX: (لم يرمِ)
        substitutions.add(new InfixSubstitution("ِيِن","ِن"));// EX: (أنتِ تَرْمِنَّ)
        substitutions.add(new InfixSubstitution("ِيِ","ِ"));// EX: (أنتِ ترمين)
        substitutions.add(new InfixSubstitution("ِيْ","ِي"));// EX: (انتن ترمين)
        substitutions.add(new InfixSubstitution("ِيُ","ُ"));// EX: (أنتم ترمون، تَرْمُنَّ)
        substitutions.add(new SuffixSubstitution("َيُ","َى"));// EX: (يسعى، يخشى )
        substitutions.add(new SuffixSubstitution("َيَ","َى"));// EX: (لن يسعى، يخشى )
        substitutions.add(new SuffixSubstitution("َيْ","َ"));// EX: (لم يسعَ، يخشَ)
        substitutions.add(new InfixSubstitution("َيِي","َيْ"));// EX: (أنتِ تسعَيْنَ، تخشين )
        substitutions.add(new InfixSubstitution("َيُو","َوْ"));// EX: (أنتم تسعَوْنَ، تخشون )
        substitutions.add(new InfixSubstitution("َيُن","َوُن"));// EX: (أنتم تسعَوُنَّ، تَخْشَوُنَّ )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return ((kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa || kov == KindOfVerb.Naqis_Yaee) && (noc == Conjugation.Second)) ||
                ((kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa || kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain || kov == KindOfVerb.Naqis_Yaee) && (noc == Conjugation.Third || noc == Conjugation.Forth));
    }
}
