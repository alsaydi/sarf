package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.*;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.*;

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
public class PassivePastAjwafWawiVocalizer extends AbstractAjwafWawiVocalizer {
    private List substitutions = new LinkedList();

    public PassivePastAjwafWawiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3ْ","ِC3ْ"));// EX: (قِمْتُ، بِئْتُ، إِبْتُ)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3ّ","ِC3ّ"));// EX: (نحن صِنَّا، هن صِنَّ، أنا فِتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3َ","ِيC3َ"));// EX: (قِيمَ، بِيء، إيبَ)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3ُ","ِيC3ُ"));// EX: (قِيموا، بِيئوا، إيبوا)
    }

    /**
     *
     * @return List
     * @todo Implement this
     *   sarf.verb.trilateral.Substitution.SubstitutionsApplier method
     */
    public List getSubstitutions() {
        return substitutions;
    }
}
