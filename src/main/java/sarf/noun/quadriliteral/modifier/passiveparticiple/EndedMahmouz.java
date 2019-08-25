package sarf.noun.quadriliteral.modifier.passiveparticiple;

import sarf.noun.QuadrilateralNounSubstitutionApplier;
import sarf.verb.quadriliteral.QuadriConjugationResult;
import sarf.verb.quadriliteral.substitution.InfixSubstitution;
import sarf.verb.quadriliteral.substitution.Substitution;
import sarf.verb.quadriliteral.substitution.SuffixSubstitution;

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

    public boolean isApplied(QuadriConjugationResult quadriConjugationResult) {
        return quadriConjugationResult.getRoot().getC4() == 'ء';
    }
}
