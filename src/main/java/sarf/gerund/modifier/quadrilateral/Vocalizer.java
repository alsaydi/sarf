package sarf.gerund.modifier.quadrilateral;

import sarf.noun.QuadrilateralNounSubstitutionApplier;
import sarf.verb.quadriliteral.ConjugationResult;
import sarf.verb.quadriliteral.substitution.InfixSubstitution;
import sarf.verb.quadriliteral.substitution.Substitution;
import sarf.verb.quadriliteral.substitution.SuffixSubstitution;

import java.util.LinkedList;
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
    private final List<Substitution> substitutions = new LinkedList<>();

    public Vocalizer() {
        substitutions.add(new InfixSubstitution("َيَة", "َاة"));// EX: (قلساة، ضوضاة، حيحاة)
        substitutions.add(new InfixSubstitution("َيَت", "َات"));// EX: (قلساتان، ضوضاتان، حيحاتان)
        substitutions.add(new InfixSubstitution("َاي", "َاء"));// EX: (اسلنقاء)
        substitutions.add(new SuffixSubstitution("ُيُ", "ِي"));// EX: (هذا التقلسي)
        substitutions.add(new SuffixSubstitution("ُيَ", "ِيَ"));// EX: (رأيتُ التقلسيَ)
        substitutions.add(new SuffixSubstitution("ُيِ", "ِي"));// EX: (بالتقلسي)
        substitutions.add(new InfixSubstitution("ُيٌ", "ٍ"));// EX: (هذا تقلسٍ)
        substitutions.add(new InfixSubstitution("ُيٍ", "ٍ"));// EX: (بتقلسٍ)
        substitutions.add(new InfixSubstitution("ُيً", "ِيً"));// EX: (تقلسيًا)
        substitutions.add(new InfixSubstitution("ُيَ", "ِيَ"));// EX: (تقلسيان)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC4() == 'ي';
    }
}
