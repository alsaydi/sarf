package sarf.verb.quadriliteral.modifier.vocalizer.nakes.active;

import java.util.*;

import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
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
public class Present1Vocalizer extends SubstitutionsApplier {

    private final List<Substitution> substitutions = new ArrayList<>();

    public Present1Vocalizer() {
        substitutions.add(new SuffixSubstitution("يُ", "ي")); // EX: (يُقَلْسِي، يَسْلَنْقِي)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يُقَلْسِ، يَسْلَنْقِ)
        substitutions.add(new InfixSubstitution("يِن", "ن")); // EX: (أنتِ تُقَلْسِنَّ، تُسْلَنْقِنَّ)
        substitutions.add(new InfixSubstitution("يِي", "ي")); // EX: (أنتِ تُقَلْسِينَ، تُسْلَقِينَ)
        substitutions.add(new InfixSubstitution("يْن", "ين")); // EX: (أنتن تُقَلْسِينَ، تُسْلَقِينَ)
        substitutions.add(new InfixSubstitution("ِيُو", "ُو")); // EX: (أنتم تُقَلْسُونَ، تَسْلَنْقُونَ)
        substitutions.add(new InfixSubstitution("ِيُن", "ُن")); // EX: (أنتم تُقَلْسُنَّ، تَسْلَنْقُنَّ)
    }


    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getCharacters().isEmpty()) {
            return false;
        }
        if (conjugationResult.getRoot().getCharacters().size() < 4) {
            return false;
        }
        if(conjugationResult.getRoot().getCharacters().get(3).getValue() != 'ي')
            return false;

        switch (conjugationResult.getFormulaNo()) {
        case 0:
        case 2:
            return true;
        }

        return false;

    }
}
