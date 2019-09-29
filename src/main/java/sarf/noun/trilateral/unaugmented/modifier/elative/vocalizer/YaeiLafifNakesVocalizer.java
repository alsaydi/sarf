package sarf.noun.trilateral.unaugmented.modifier.elative.vocalizer;

import sarf.Conjugation;
import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SuffixSubstitution;

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
public class YaeiLafifNakesVocalizer extends TrilateralNounSubstitutionApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public YaeiLafifNakesVocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ", "َى"));// EX: (هذا الأهدى، )
        substitutions.add(new SuffixSubstitution("َيَ", "َى"));// EX: (رأيتُ الأهدى، )
        substitutions.add(new SuffixSubstitution("َيِ", "َى"));// EX: (مررتُ على الأهدى، )
        substitutions.add(new InfixSubstitution("َيُو", "َوْ"));// EX: (الأهدَوْنَ)
        substitutions.add(new InfixSubstitution("َيِي", "َيْ"));// EX: (الأهدَيْنَ)
        substitutions.add(new InfixSubstitution("ْيَى", "ْيَا"));// EX: (الهديا)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        if (kov == KindOfVerb.Naqis_Yaee) {
            return noc == Conjugation.Second
                    || noc == Conjugation.Third
                    || noc == Conjugation.Forth;

        } else if (kov == KindOfVerb.Lafeef_Maqroon) {//return noc == 2 || noc == Conjugation.Forth;
            return noc == Conjugation.Second || noc == Conjugation.Forth;
        }
        return false;
    }
}
