package sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.yaei.passive;

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
public class PresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private List<Substitution> substitutions = new ArrayList<>();

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
        int kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return ((kov == 24 || kov == 26) && (noc == Conjugation.Second)) ||
                ((kov == 24 || kov == 25 || kov == 26) && (noc == Conjugation.Third || noc == Conjugation.Forth));
    }
}
