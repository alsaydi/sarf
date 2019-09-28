package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.connected;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
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
public class PassivePresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PassivePresentVocalizer() {
        substitutions.add(new SuffixSubstitution("يَيُ","يَا"));// EX: (يُحْيَا)
        substitutions.add(new SuffixSubstitution("يَيَ","يَا"));// EX: (لن يُحْيَا)
        substitutions.add(new SuffixSubstitution("َيُ","َى"));// EX: (يُشْوَى)
        substitutions.add(new SuffixSubstitution("َيَ","َى"));// EX: (لن يُشْوَى)
        substitutions.add(new SuffixSubstitution("َيْ","َ"));// EX: (لم يُشْوَ)
        substitutions.add(new InfixSubstitution("َيِي","َيْ"));// EX: (أنتِ تُشْوَيْنَ)
        substitutions.add(new InfixSubstitution("َيُو","َوْ"));// EX: (أنتم تُشْوَوْنَ)
        substitutions.add(new InfixSubstitution("َيُن","َوُن"));// EX: (أنتم تُشْوَوُنَّ)
        substitutions.add(new SuffixSubstitution("َوُ","َى"));// EX: (يُسْوَى)
        substitutions.add(new SuffixSubstitution("َوَ","َى"));// EX: (لن يُسْوَى)
        substitutions.add(new SuffixSubstitution("َوْ","َ"));// EX: (لم يُسْوَ)
        substitutions.add(new InfixSubstitution("َوِي","َيْ"));// EX: (أنتِ تُسْوَيْنَ)
        substitutions.add(new InfixSubstitution("َوِن","َيِن"));// EX: (أنتِ تُسْوَيِنَّ)
        substitutions.add(new InfixSubstitution("َوَن","َيَن"));// EX: (أنتَ تُسْوَيَنَّ)
        substitutions.add(new InfixSubstitution("َوُو","َوْ"));// EX: (أنتم تُسْوَوْنَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return ((kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa || kov == KindOfVerb.Lafeef_Maqroon) && (noc == Conjugation.Second)) || (kov == KindOfVerb.Lafeef_Maqroon && noc == Conjugation.Forth);
    }
}
