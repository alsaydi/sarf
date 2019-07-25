package sarf.verb.trilateral.augmented.modifier.substituter.active;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.substituter.*;
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
public class GenericSubstituter7 extends AbstractGenericSubstituter {
    private List<Substitution> substitutions = new ArrayList<>();

    public GenericSubstituter7() {
        substitutions.add(new InfixSubstitution("ضْتَ","ضْطَ"));// EX: (اضْطَلَعَ، يَضْطَلِعُ، اضْطَلِعْ)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC1() == 'ض' && super.isApplied(conjugationResult);
    }
}
