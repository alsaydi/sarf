package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei;

import java.util.ArrayList;
import java.util.List;

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
public class PassivePastAjwafYaeiListedVocalizer extends AbstractAjwafYaeiListedVocalizer {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PassivePastAjwafYaeiListedVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ّ","ُC3ّ"));// EX: ( بُتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ْ","ُC3ْ"));// EX: (بُعْتُ، قُئتُ، أُنْتُ، شُئْتُ)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ّ","ُC3ّ"));// EX: (نحن لُنَّا، هن لُنَّ، أنا لِتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3َ","ِيC3َ"));// EX: (بِيع، قِيء، إين، شِيء، بِيت)
        substitutions.add(new ExpressionInfixSubstitution("ُيِC3ُ","ِيC3ُ"));// EX: (بِيعوا، قِيئوا، إينوا، شِيئوا، بِيتوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
