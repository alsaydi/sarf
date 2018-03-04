package sarf.gerund.modifier.trilateral.unaugmented.meem.vocalizer;

import java.util.*;

import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import sarf.noun.trilateral.unaugmented.modifier.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:åæ ÊßÑÇÑ ááÕİ ÇáÇÎÑ æáßä ãÚ ÔÑØ æÌæÏ ÇáÌĞÑ Öãä ÇáŞÇÆãÉ           </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AjwafListed1Vocalizer extends AbstractAjwafYaeiListedVocalizer implements IUnaugmentedTrilateralNounModificationApplier{
    private List substitutions = new LinkedList();

    public AjwafListed1Vocalizer() {
        substitutions.add(new InfixSubstitution("úíö","öí"));// EX: ( ãóÈöíÚ¡ )
        substitutions.add(new InfixSubstitution("úíó","óÇ"));// EX: (ãÍÇÑ)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    protected static List appliedProunounsIndecies = new ArrayList(18);
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
