package sarf.noun.quadriliteral.modifier.activeparticiple;

import sarf.noun.QuadrilateralNounSubstitutionApplier;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
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
public class InternalMahmouz extends QuadrilateralNounSubstitutionApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    InternalMahmouz() {
        substitutions.add(new InfixSubstitution("ْءُ", "ْؤُ"));// EX: (مُتَمَرْؤُونَ،)
        substitutions.add(new InfixSubstitution("َءْ", "َأْ"));// EX: (مُبَأْدِلٌ، مُتَثَأْلِلٌ،)
        substitutions.add(new InfixSubstitution("ءِ", "ئِ"));// EX: (مُطَمْئِنٌ، مُتَطَمْئِنٌ، مُطْمَئِنٌّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC2() == 'ء' || conjugationResult.getRoot().getC3() == 'ء';
    }
}
