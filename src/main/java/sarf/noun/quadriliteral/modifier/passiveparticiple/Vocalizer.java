package sarf.noun.quadriliteral.modifier.passiveparticiple;

import sarf.noun.QuadrilateralNounSubstitutionApplier;
import sarf.verb.quadriliteral.ConjugationResult;
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
public class Vocalizer extends QuadrilateralNounSubstitutionApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Vocalizer() {
        substitutions.add(new InfixSubstitution("َيَة", "َاة"));// EX: (مُقَلْسَاةٌ،)
        substitutions.add(new InfixSubstitution("َيَت", "َات"));// EX: (مُقَلْسَاتان، مُقَلْسَاتَيْنِ)
        substitutions.add(new InfixSubstitution("َيُو", "َوْ"));// EX: (مُقَلْسَوْنَ)
        substitutions.add(new InfixSubstitution("َيِي", "َيْ"));// EX: (مُقَلْسَيْنَ)
        substitutions.add(new SuffixSubstitution("َيُ", "َى"));// EX: (هذا المُقَلسَى،)
        substitutions.add(new SuffixSubstitution("َيَ", "َى"));// EX: (رأيتُ المُقَلسَى ،  )
        substitutions.add(new SuffixSubstitution("َيِ", "َى"));// EX: (مررتُ على المُقَلسَى ، )
        substitutions.add(new InfixSubstitution("َيٌ", "ًى"));// EX: (هذا مُقَلْسًى)
        substitutions.add(new InfixSubstitution("َيًا", "ًى"));// EX: (رأيتُ مُقَلْسًى)
        substitutions.add(new InfixSubstitution("َيٍ", "ًى"));// EX: (مررتُ على مُقَلْسًى)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'ي';
    }
}
