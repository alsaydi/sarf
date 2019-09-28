package sarf.noun.trilateral.unaugmented.modifier.activeparticiple.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.noun.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.*;
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
public class Ajwaf2Vocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Ajwaf2Vocalizer() {
        substitutions.add(new InfixSubstitution("اوِءٌ","اءٍ"));// EX: (هذا ناءٍ)
        substitutions.add(new InfixSubstitution("اوِءً","ائِيً"));// EX: (رأيتُ نائِياً)
        substitutions.add(new InfixSubstitution("اوِءٍ","اءٍ"));// EX: (مررتُ على ناءٍ)
        substitutions.add(new SuffixSubstitution("اوِءُ","ائِي"));// EX: (هذا النائِي، نائِي الـ، )
        substitutions.add(new SuffixSubstitution("اوِءَ","ائِيَ"));// EX: (رأيتُ النائيَ، نائِي الـ، )
        substitutions.add(new SuffixSubstitution("اوِءِ","ائِي"));// EX: (مررتُ على النائِي، نائِي الـ)
        substitutions.add(new InfixSubstitution("اوِءَ","ائِيَ"));// EX: (نائِيَةٌ، نائِيانِ،  )
        substitutions.add(new InfixSubstitution("اوِءُ","اؤُ"));// EX: (ناؤُونَ، )
        substitutions.add(new InfixSubstitution("اوِءِ","ائِ"));// EX: (نائِينَ، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        return kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam && (noc == Conjugation.First || noc == Conjugation.Forth);
    }
}
