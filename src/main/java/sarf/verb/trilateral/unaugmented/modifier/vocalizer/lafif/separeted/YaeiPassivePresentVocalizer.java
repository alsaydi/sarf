package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.ExpressionSuffixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;

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
public class YaeiPassivePresentVocalizer extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public YaeiPassivePresentVocalizer() {
        substitutions.add(new ExpressionSuffixSubstitution("يْC2َيُ", "وC2َى")); // EX: (يُودَى)
        substitutions.add(new ExpressionSuffixSubstitution("يْC2َيَ", "وC2َى")); // EX: (لن يُودَى)
        substitutions.add(new ExpressionInfixSubstitution("يْC2َيَ","وC2َيَ"));// EX: (يُودَيانِ)
        substitutions.add(new ExpressionSuffixSubstitution("يْC2َيْ", "وC2َ")); // EX: (لم يُودَ)
        substitutions.add(new ExpressionInfixSubstitution("يْC2َيْ","وC2َيْ"));// EX: (يُودَيْنَانِّ)
        substitutions.add(new ExpressionInfixSubstitution("يْC2َيِي", "وC2َيْ")); // EX: (أنتِ تُودَيْنَ)
        substitutions.add(new ExpressionInfixSubstitution("يْC2َيُو", "وC2َوْ")); // EX: (أنتم تُودَوْنَ)
        substitutions.add(new ExpressionInfixSubstitution("يْC2َيُن", "وC2َوُن")); // EX: (أنتم تُودَوُنَّ)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC1() != 'ي') {
            return false;
        }

        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return ((kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain || kov == KindOfVerb.Lafeef_Mafrooq ) && (noc == Conjugation.Second)) ||
                (kov == KindOfVerb.Lafeef_Mafrooq  && (noc == Conjugation.Sixth || noc == Conjugation.Forth));
    }
}
