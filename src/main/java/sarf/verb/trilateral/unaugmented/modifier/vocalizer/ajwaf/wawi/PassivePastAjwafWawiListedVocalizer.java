package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
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
public class PassivePastAjwafWawiListedVocalizer extends AbstractAjwafWawiListedVocalizer {
    private List<Substitution> substitutions = new ArrayList<>();

    public PassivePastAjwafWawiListedVocalizer() {

        substitutions.add(new ExpressionInfixSubstitution("ُوِC3ْ","ُC3ْ"));// EX: ( بُهْتُ، دُئْتُ)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3َ","ِيC3َ"));// EX: (بِيه، دِيء)
        substitutions.add(new ExpressionInfixSubstitution("ُوِC3ُ","ِيC3ُ"));// EX: (بِيهوا، دِيئوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
