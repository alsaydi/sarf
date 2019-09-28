package sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.passive;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.Substitution;
import sarf.verb.trilateral.Substitution.SubstitutionsApplier;
import sarf.verb.trilateral.Substitution.SuffixSubstitution;
import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;

import java.util.ArrayList;
import java.util.List;

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
        substitutions.add(new SuffixSubstitution("َيُ","َى"));// EX: (يُرْمَى، يسعى، يخشى )
        substitutions.add(new SuffixSubstitution("َيَ","َى"));// EX: (لن يُرْمَى، يسعى، يخشى )
        substitutions.add(new SuffixSubstitution("َيْ","َ"));// EX: (لم يُرمَ، يسعَ، يخشَ)
        substitutions.add(new InfixSubstitution("َيِي","َيْ"));// EX: (أنتِ تُرمَيْنَ، تسعَيْنَ، تخشين )
        substitutions.add(new InfixSubstitution("َيُو","َوْ"));// EX: (أنتم تُرمَوْنَ، تسعَوْنَ، تخشون )
        substitutions.add(new InfixSubstitution("َيُن","َوُن"));// EX: (أنتم تُرمَوُنَّ، تُسعَوُنَّ، تُخشوُنَّ )
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
