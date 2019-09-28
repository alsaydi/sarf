package sarf.gerund.modifier.quadrilateral;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
    private final List<InfixSubstitution> substitutions = new LinkedList<>();

    EndedMahmouz() {
        substitutions.add(new InfixSubstitution("اءًا","اءً"));// EX: (جِئجاءً، احبنطاءً)
        substitutions.add(new InfixSubstitution("َءَا","َآ"));// EX: (جأجآت، غرقآت، يرنآت)
        substitutions.add(new InfixSubstitution("َءَ","َأَ"));// EX: (جأجأة، غرقأة، يرنأة)
        substitutions.add(new InfixSubstitution("ُء","ُؤ"));// EX: (تجأجُؤ، تدربؤ)
    }

    @Override
    public List<InfixSubstitution> getSubstitutions() {
        return substitutions;
    }

    @Override
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
