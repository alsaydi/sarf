package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
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
public class ActivePastAjwafYaeiVocalizer extends AbstractAjwafYaeiVocalizer {
    private List<Substitution> substitutions = new ArrayList<>();

    public ActivePastAjwafYaeiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ْ","ِC3ْ"));// EX: (بِعْتُ، قِئتُ، إِنْتُ،)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ّ","ِC3ّ"));// EX: (نحن لِنَّا، هن لِنَّ، أنا لِتُّ)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3َ","َاC3َ"));// EX: (باع، قاء، آن،)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ُ","َاC3ُ"));// EX: (باعوا، قاؤوا، آنوا،)
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
