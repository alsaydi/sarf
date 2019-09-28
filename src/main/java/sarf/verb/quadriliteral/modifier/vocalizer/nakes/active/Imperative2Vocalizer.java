package sarf.verb.quadriliteral.modifier.vocalizer.nakes.active;

import sarf.verb.quadriliteral.substitution.SubstitutionsApplier;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.Substitution;
import sarf.verb.trilateral.Substitution.SuffixSubstitution;
import sarf.ConjugationResult;

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
public class Imperative2Vocalizer extends SubstitutionsApplier {

    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative2Vocalizer() {
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (تَقَلْسَ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تَقَلْسَيْ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تَقَلْسَوْا)
        substitutions.add(new InfixSubstitution("يُن", "وُن")); // EX: (أنتم تَقَلْسَوُنَّ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getCharacters().isEmpty()) {
            return false;
        }
        if (conjugationResult.getRoot().getCharacters().size() < 4) {
            return false;
        }
        return conjugationResult.getRoot().getCharacters().get(3).getValue() == 'ي' && conjugationResult.getFormulaNo() == 1;
    }
}
