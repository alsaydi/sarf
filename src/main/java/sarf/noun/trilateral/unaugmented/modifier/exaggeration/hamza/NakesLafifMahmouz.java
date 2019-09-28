package sarf.noun.trilateral.unaugmented.modifier.exaggeration.hamza;

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
public class NakesLafifMahmouz extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public NakesLafifMahmouz() {
        substitutions.add(new InfixSubstitution("اءٌ","اءٌ"));// EX: (غزّاءٌ، رمَّاءٌ، مِعطاءٌ، مِجناء، مِعواء، مِيفاء)
        substitutions.add(new InfixSubstitution("اءً","اءً"));// EX: (مِعطاءً ،  )
        substitutions.add(new InfixSubstitution("اءٍ","اءٍ"));// EX: (مِعطاءٍ ،   )
        substitutions.add(new SuffixSubstitution("اءُ","اءُ"));// EX: (المعطاءُ )
        substitutions.add(new SuffixSubstitution("اءِ","اءِ"));// EX: (المعطاءِ )
        substitutions.add(new SuffixSubstitution("آَّءُ","آَّءُ"));// EX: (مَآَّءُ )
        substitutions.add(new SuffixSubstitution("آَّءِ","آَّءِ"));// EX: (مَآَّءِ )
        substitutions.add(new InfixSubstitution("آَّءُ","آَّؤُ"));// EX: (مَآَّؤُونَ )
        substitutions.add(new InfixSubstitution("آَّءِ","آَّئِ"));// EX: (مَآَّئِينَ )
        substitutions.add(new InfixSubstitution("اءُ","اؤُ"));// EX: (معطاؤونَ )
        substitutions.add(new InfixSubstitution("اءِ","ائِ"));// EX: (معطائِينَ )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        if (!nounFormula.equals("فَعَّال")) {
            return false;
        }

        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        if (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Faa) {
            return noc == Conjugation.First || noc == Conjugation.Fifth;
        } else if (kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain) {
            return noc == Conjugation.First || noc == Conjugation.Third;
        } else if (kov == KindOfVerb.Naqis_Wawi) {
            switch (noc) {
                case First:
                case Third:
                case Forth:
                case Fifth:
                    return true;
            }


            if (noc == Conjugation.Second) {
                return true;
            }


            return noc == Conjugation.Third || noc == Conjugation.Forth;
        } else if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa || kov == KindOfVerb.Naqis_Yaee) {
            switch (noc) {
                case Second:
                case Third:
                case Forth:
                    return true;
            }


            return noc == Conjugation.Third || noc == Conjugation.Forth;
        } else if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain) {
            return noc == Conjugation.Third || noc == Conjugation.Forth;
        } else if (kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa || kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain) {
            return noc == Conjugation.Second;
        } else if (kov == KindOfVerb.Lafeef_Maqroon) {
            return noc == Conjugation.Second || noc == Conjugation.Forth;
        } else if (kov == KindOfVerb.Lafeef_Mafrooq) {
            switch (noc) {
                case Second:
                case Forth:
                case Sixth:
                    return true;
            }
        }
        return false;
    }
}
