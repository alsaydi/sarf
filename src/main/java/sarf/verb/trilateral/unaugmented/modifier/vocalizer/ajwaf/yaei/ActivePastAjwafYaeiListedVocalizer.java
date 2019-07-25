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
public class ActivePastAjwafYaeiListedVocalizer extends AbstractAjwafYaeiListedVocalizer {
    private final List<Substitution> substitutions = new ArrayList<>();

    public ActivePastAjwafYaeiListedVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َيِC3ْ","ِC3ْ"));// EX: ( شِئْتُ)
        substitutions.add(new ExpressionInfixSubstitution("َيِC3ّ","ِC3ّ"));// EX: ( بِتُّ)
        substitutions.add(new ExpressionInfixSubstitution("َيِC3َ","َاC3َ"));// EX: (شاء، بات)
        substitutions.add(new ExpressionInfixSubstitution("َيِC3ُ","َاC3ُ"));// EX: (شاؤوا، باتوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
