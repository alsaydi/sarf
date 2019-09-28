package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi;

import java.util.*;

import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.Substitution;
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
public class ActivePastAjwafWawiListedVocalizer extends AbstractAjwafWawiListedVocalizer {
    private final List<Substitution> substitutions = new ArrayList<>();

    public ActivePastAjwafWawiListedVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َوِC3ْ","ِC3ْ"));// EX: ( بِهْتُ، دِئْتُ)
        substitutions.add(new ExpressionInfixSubstitution("َوِC3ّ","ِC3ّ"));// EX: ( صِتُّ)
        substitutions.add(new ExpressionInfixSubstitution("َوِC3َ","َاC3َ"));// EX: ( باه، داء)
        substitutions.add(new ExpressionInfixSubstitution("َوِC3ُ","َاC3ُ"));// EX: ( باهوا، داؤوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
