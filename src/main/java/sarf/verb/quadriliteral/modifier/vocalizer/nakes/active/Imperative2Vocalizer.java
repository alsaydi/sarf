package sarf.verb.quadriliteral.modifier.vocalizer.nakes.active;

import java.util.*;
import sarf.verb.quadriliteral.substitution.*;
import sarf.verb.quadriliteral.modifier.*;
import sarf.verb.quadriliteral.*;

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
public class Imperative2Vocalizer extends SubstitutionsApplier implements IQuadrilateralModifier {

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
        return conjugationResult.getRoot().getC4() == 'ي' && conjugationResult.getFormulaNo() == 1;

    }
}
