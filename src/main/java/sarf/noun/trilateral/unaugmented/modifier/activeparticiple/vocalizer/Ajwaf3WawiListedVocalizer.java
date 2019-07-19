package sarf.noun.trilateral.unaugmented.modifier.activeparticiple.vocalizer;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.*;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import sarf.noun.trilateral.unaugmented.modifier.ConjugationResult;

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
public class Ajwaf3WawiListedVocalizer extends AbstractAjwafWawiListedVocalizer implements IUnaugmentedTrilateralNounModificationApplier{
    private List<Substitution> substitutions = new LinkedList<Substitution>();

    public Ajwaf3WawiListedVocalizer() {
        substitutions.add(new InfixSubstitution("اوِ","ائِ"));// EX: (قائِمٌ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    private static List<String> appliedProunounsIndecies = new ArrayList<String>(18);
    static {
        for (int i=0; i<18; i++) {
            appliedProunounsIndecies.add(i+1 +"");
        }
    }

    protected List<String> getAppliedPronounsIndecies() {
        return appliedProunounsIndecies;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return super.isApplied(conjugationResult);
    }
}
