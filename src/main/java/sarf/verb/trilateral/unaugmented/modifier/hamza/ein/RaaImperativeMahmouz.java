package sarf.verb.trilateral.unaugmented.modifier.hamza.ein;

import sarf.ConjugationResult;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;

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
public class RaaImperativeMahmouz extends SubstitutionsApplier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public RaaImperativeMahmouz() {
        substitutions.add(new InfixSubstitution("ارْءَ", "رَ"));// EX: (رَ، رَيْ، رَيا، رَوْا، رَيْنَ، رَيَنَّ، رَيِنَّ، رَيانِّ، رَوُنَّ، رَيْنانِّ)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        var root = conjugationResult.getRoot();
        return root.getC1() == 'ر' && root.getC2() == 'ء' && root.getC3() == 'ي';
    }
}
