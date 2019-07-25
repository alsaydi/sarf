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
public class PassivePresentAjwafYaeiVocalizer extends AbstractAjwafYaeiVocalizer {
    private List<Substitution> substitutions = new ArrayList<>();

    public PassivePresentAjwafYaeiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ُ", "َاC3ُ")); // EX: (يُباع، يُبات، لن تُباتوا)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ِ", "َاC3ِ")); // EX: (تُباعِينَ، تُباتين، لن تُباتي )
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3َ", "َاC3َ")); // EX: (تُباعان، تُباتان، لن يُباتَ، يُباتَنَّ)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ْ", "َC3ْ")); // EX: (يُبَعْنَ، يُبَتْنَ، لم تُبَتْ)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ّ", "َC3ّ")); // EX: (أنتن تُلَنَّ، هن يُلَنَّ)
    }

    public List getSubstitutions() {
        return substitutions;
    }

}
