package sarf.noun.trilateral.unaugmented.modifier.activeparticiple.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.noun.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SuffixSubstitution;

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
public class Ajwaf4Vocalizer extends TrilateralNounSubstitutionApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Ajwaf4Vocalizer() {
        substitutions.add(new InfixSubstitution("ايِءٌ","اءٍ"));// EX: (هذا جاءٍ)
        substitutions.add(new InfixSubstitution("ايِءٍ","اءٍ"));// EX: (مررتُ على جاءٍ)
        substitutions.add(new SuffixSubstitution("ايِءُ","ائِي"));// EX: (هذا الجائِي، )
        substitutions.add(new SuffixSubstitution("ايِءِ","ائِي"));// EX: (مررتُ على الجائِي )
        substitutions.add(new InfixSubstitution("ايِءُ","اؤُ"));// EX: (جاؤُونَ، )
        substitutions.add(new InfixSubstitution("ايِءِ","ائِ"));// EX: (جائِينَ، )
        substitutions.add(new InfixSubstitution("ايِء","ائِي"));// EX: (جائيان، جائيَيْن، جائية، جائيًا، رأيتُ الجائِيَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        return kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam && (noc == Conjugation.Second || noc == Conjugation.Forth);
    }
}
