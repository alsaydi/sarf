package sarf.noun.trilateral.unaugmented.modifier.activeparticiple.vocalizer;

import java.util.*;

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
    List substitutions = new LinkedList();

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


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC3() != 'و')
            return false;

        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        switch (kov) {
        case 21:
            return noc == 1 || noc == 5;

        case 22:
            return noc == 1 || noc == 3;

        case 23:
            switch (noc) {
            case 1:
            case 3:
            case 4:
            case 5:
                return true;
            }

        case 28:
            return noc == 4;
        }
        return false;
    }
}
