package sarf.noun.quadriliteral.modifier.passiveparticiple;

import sarf.noun.QuadrilateralNounSubstitutionApplier;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.SuffixSubstitution;
import sarf.verb.trilateral.Substitution.Substitution;
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
public class EndedMahmouz extends QuadrilateralNounSubstitutionApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    EndedMahmouz() {
        substitutions.add(new InfixSubstitution("َءٌ", "َأٌ"));// EX: (مُغَرْقَأٌ)
        substitutions.add(new InfixSubstitution("َءًا", "َأً"));// EX: (مُغَرْقَأً)
        substitutions.add(new InfixSubstitution("َءٍ", "َأٍ"));// EX: (مُغَرْقَأٍ)
        substitutions.add(new InfixSubstitution("َءَا", "َآ"));// EX: (مُغَرقآن)
        substitutions.add(new SuffixSubstitution("َءَ", "َأَ"));// EX: (المُغَرقَأَ)
        substitutions.add(new SuffixSubstitution("َءُ", "َأُ"));// EX: (المُغَرقَأُ)
        substitutions.add(new SuffixSubstitution("َءِ", "َأِ"));// EX: (المُغَرقَأِ)
        substitutions.add(new InfixSubstitution("َءَ", "َأَ"));// EX: (مُغَرْقَأة)
        substitutions.add(new InfixSubstitution("ءُ", "ؤُ"));// EX: (مُغَرْقَؤُونَ)
        substitutions.add(new InfixSubstitution("ءِ", "ئِ"));// EX: (مُغَرْقَئِينَ)
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
        return conjugationResult.getRoot().getCharacters().get(3).getValue() == 'ء';
    }
}
