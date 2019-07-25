package sarf.gerund.modifier.trilateral.unaugmented.meem.vocalizer;

import java.util.*;

import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:هو تكرار للصف الاخر ولكن مع شرط وجود الجذر ضمن القائمة           </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AjwafListed1Vocalizer extends AbstractAjwafYaeiListedVocalizer implements IUnaugmentedTrilateralNounModificationApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public AjwafListed1Vocalizer() {
        substitutions.add(new InfixSubstitution("ْيِ","ِي"));// EX: ( مَبِيع، )
        substitutions.add(new InfixSubstitution("ْيَ","َا"));// EX: (محار)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    private static final List<String> appliedProunounsIndecies = new ArrayList<String>(18);
    static {
        for (int i=0; i<18; i++) {
            appliedProunounsIndecies.add(i+1 +"");
        }
    }

    protected List getAppliedPronounsIndecies() {
        return appliedProunounsIndecies;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return super.isApplied(conjugationResult);
    }
}
