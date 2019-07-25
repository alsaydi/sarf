package sarf.noun.trilateral.unaugmented.modifier.activeparticiple.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.noun.*;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.Substitution.*;

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
public class WawiLafifNakesVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private List<Substitution> substitutions = new ArrayList<>();

    public WawiLafifNakesVocalizer() {
        substitutions.add(new InfixSubstitution("ِوٌ", "ٍ")); // EX: (هذا غازٍ)
        substitutions.add(new InfixSubstitution("ِوً", "ِيً")); // EX: (رأيتُ غازِيًا)
        substitutions.add(new InfixSubstitution("ِوٍ", "ٍ")); // EX: (مررتُ على غازٍ)
        substitutions.add(new SuffixSubstitution("ِوُ", "ِي")); // EX: (هذا الغازِي، غازِي المدينة، )
        substitutions.add(new SuffixSubstitution("ِوَ", "ِيَ")); // EX: (رأيتُ الغازيَ، غازِيَ المدينة، )
        substitutions.add(new SuffixSubstitution("ِوِ", "ِي")); // EX: (مررتُ على الغازي، غازِي المدينة، )
        substitutions.add(new InfixSubstitution("ِوَ", "ِيَ")); // EX: (غازِيَةٌ، غازِيانِ، غازِيَتَانِ، غازِياتٌ، )
        substitutions.add(new InfixSubstitution("ِوُ", "ُ")); // EX: (غازُونَ، )
        substitutions.add(new InfixSubstitution("ِوِ", "ِ")); // EX: (غازِينَ، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC3() != 'و')
            return false;

        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        if (kov == 21) {
            return noc == Conjugation.First || noc == Conjugation.Fifth;
        } else if (kov == 22) {
            return noc == Conjugation.First || noc == Conjugation.Third;
        } else if (kov == 23) {
            switch (noc) {
                case First:
                case Third:
                case Forth:
                case Fifth:
                    return true;
            }


            return noc == Conjugation.Forth;
        } else if (kov == 28) {
            return noc == Conjugation.Forth;
        }
        return false;
    }
}
