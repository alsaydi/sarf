package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.connected;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;
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
public class ActivePresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public ActivePresentVocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يَشوي)
        substitutions.add(new SuffixSubstitution("ِيْ","ِ"));// EX: (لم يَشْوِ)
        substitutions.add(new InfixSubstitution("ِيِن","ِن"));// EX: (أنتِ تَشْوِنَّ)
        substitutions.add(new InfixSubstitution("ِيِ","ِ"));// EX: (أنتِ تَشْوِينَ)
        substitutions.add(new InfixSubstitution("ِيْ","ِي"));// EX: (انتن تشوين)
        substitutions.add(new InfixSubstitution("ِيُ","ُ"));// EX: (أنتم تشوون، تَشْوُنَّ)
        substitutions.add(new SuffixSubstitution("يَيُ","يَا"));// EX: (يَحْيَا)
        substitutions.add(new SuffixSubstitution("يَيَ","يَا"));// EX: (لن يَحْيَا)
        substitutions.add(new SuffixSubstitution("َيُ","َى"));// EX: (يَقْوَى)
        substitutions.add(new SuffixSubstitution("َيَ","َى"));// EX: (لن يَقْوَى)
        substitutions.add(new SuffixSubstitution("َيْ","َ"));// EX: (لم يَقْوَ، يَحْيَ)
        substitutions.add(new InfixSubstitution("َيِي","َيْ"));// EX: (أنتِ تَقْوَيْنَ، تَحْيَيْنَ)
        substitutions.add(new InfixSubstitution("َيُو","َوْ"));// EX: (أنتم تَقْوَوْنَ، تَحْيَوْنَ)
        substitutions.add(new InfixSubstitution("َيُن","َوُن"));// EX: (أنتم تَقْوَوُنَّ، تَحْيَوُنَّ)
        substitutions.add(new SuffixSubstitution("َوُ","َى"));// EX: (يَسْوَى)
        substitutions.add(new SuffixSubstitution("َوَ","َى"));// EX: (لن يَسْوَى)
        substitutions.add(new SuffixSubstitution("َوْ","َ"));// EX: (لم يَسْوَ)
        substitutions.add(new InfixSubstitution("َوِي","َيْ"));// EX: (أنتِ تَسْوَيْنَ)
        substitutions.add(new InfixSubstitution("َوِن","َيِن"));// EX: (أنتِ تَسْوَيِنَّ)
        substitutions.add(new InfixSubstitution("َوَن","َيَن"));// EX: (أنتَ تَسْوَيَنَّ)
        substitutions.add(new InfixSubstitution("َوْن","َيْن"));// EX: (أنتن تَسْوَيْنَ)
        substitutions.add(new InfixSubstitution("َوُو","َوْ"));// EX: (أنتم تَسْوَوْنَ)
        substitutions.add(new InfixSubstitution("َوَ","َيَ"));// EX: (أنتما تسْويانِ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return ((kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa || kov == KindOfVerb.Lafeef_Maqroon) && (noc == Conjugation.Second)) ||
                (kov == KindOfVerb.Lafeef_Maqroon && noc == Conjugation.Forth);
    }
}
