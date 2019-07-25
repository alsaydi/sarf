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
public class PassivePastAjwafYaeiVocalizer extends AbstractAjwafYaeiVocalizer {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PassivePastAjwafYaeiVocalizer() {

        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ّ","ُC3ّ"));// EX: ( بُتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ْ","ُC3ْ"));// EX: (بُعْتُ، قُئتُ، أُنْتُ، شُئْتُ)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ّ","ُC3ّ"));// EX: (نحن لُنَّا، هن لُنَّ، أنا لِتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3َ","ِيC3َ"));// EX: (بِيع، قِيء، إين، شِيء، بِيت)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ُ","ِيC3ُ"));// EX: (بِيعوا، قِيئوا، إينوا، شِيئوا، بِيتوا)

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
