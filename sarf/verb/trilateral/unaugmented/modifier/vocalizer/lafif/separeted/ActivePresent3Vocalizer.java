package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted;

import java.util.*;

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
public class ActivePresent3Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public ActivePresent3Vocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ","َى"));// EX: (يَوْجَى)
        substitutions.add(new SuffixSubstitution("َيَ","َى"));// EX: (لن يَوْجَى)
        substitutions.add(new SuffixSubstitution("َيْ","َ"));// EX: (لم يَوْجَ)
        substitutions.add(new InfixSubstitution("َيِي","َيْ"));// EX: (أنتِ تَوْجَيْنَ)
        substitutions.add(new InfixSubstitution("َيُو","َوْ"));// EX: (أنتم تَوْجَوْنَ)
        substitutions.add(new InfixSubstitution("َيُن","َوُن"));// EX: (أنتم تَوْجَوُنَّ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return (kov == 30 && noc == 4);
    }
}
