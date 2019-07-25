package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei;

import java.util.ArrayList;
import java.util.List;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.AbstractAjwafYaeiListedVocalizer;

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
public class ImperativeAjwafYaeiListedVocalizer extends AbstractAjwafYaeiListedVocalizer {
    private List<Substitution> substitutions = new ArrayList<>();

    public ImperativeAjwafYaeiListedVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("اC1ْيَC3ُ", "C1َاC3ُ"));
        substitutions.add(new ExpressionInfixSubstitution("اC1ْيَC3ِ", "C1َاC3ِ"));
        substitutions.add(new ExpressionInfixSubstitution("اC1ْيَC3َ", "C1َاC3َ"));
        substitutions.add(new ExpressionInfixSubstitution("اC1ْيَC3ْ", "C1َC3ْ"));
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
