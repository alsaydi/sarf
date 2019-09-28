package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi;

import java.util.*;

import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.Substitution;

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
public class ActivePastAjwafWawiVocalizer extends AbstractAjwafWawiVocalizer {
    private final List<Substitution> substitutions = new ArrayList<>();

    public ActivePastAjwafWawiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َوَC3ْ", "ُC3ْ")); // EX: (قُمْتُ، بُؤْتُ، أُبْتُ)
        substitutions.add(new ExpressionInfixSubstitution("َوَC3ّ", "ُC3ّ")); // EX: (نحن صُنَّا، هنّ صُنَّ، أنا فُتُّ)
        substitutions.add(new ExpressionInfixSubstitution("َوَC3َ", "َاC3َ")); // EX: (قام، باء، آب)
        substitutions.add(new ExpressionInfixSubstitution("َوَC3ُ", "َاC3ُ")); // EX: (قاموا، باؤوا، آبوا)
    }

    /**
     *
     * @return List
     * @todo Implement this
     *   SubstitutionsApplier method
     */
    public List getSubstitutions() {
        return substitutions;
    }
}
