package sarf.noun.trilateral.unaugmented.modifier.activeparticiple.vocalizer;

import java.util.*;

import sarf.ConjugationResult;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;

import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:فحص الأجوف حسب قائمة    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class Ajwaf3WawiListedVocalizer extends AbstractAjwafWawiListedVocalizer {
    private final List<Substitution> substitutions = new LinkedList<>();

    public Ajwaf3WawiListedVocalizer() {
        substitutions.add(new InfixSubstitution("اوِ","ائِ"));// EX: (قائِمٌ)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    private static final List<String> appliedPronounIndexes = new ArrayList<>(18);
    static {
        for (int i=0; i<18; i++) {
            appliedPronounIndexes.add(i+1 +"");
        }
    }

    @Override
    protected List<String> getAppliedPronounsIndexes() {
        return appliedPronounIndexes;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        return super.isApplied(conjugationResult);
    }
}
