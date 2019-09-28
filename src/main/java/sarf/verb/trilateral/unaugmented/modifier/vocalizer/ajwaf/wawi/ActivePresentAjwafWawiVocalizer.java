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
public class ActivePresentAjwafWawiVocalizer extends AbstractAjwafWawiVocalizer {
    private final List<Substitution> substitutions = new ArrayList<>();

    public ActivePresentAjwafWawiVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْوُC3ُ", "ُوC3ُ")); // EX: (يَقُومُ، يبوء، يؤوب)
        substitutions.add(new ExpressionInfixSubstitution("ْوُC3ِ", "ُوC3ِ")); // EX: (تقومين، لن تقومِي، تبوئين، تؤوبين)
        substitutions.add(new ExpressionInfixSubstitution("ْوُC3َ", "ُوC3َ")); // EX: (تقومان، لن يقومَ، تبوءان، تؤوبان)
        substitutions.add(new ExpressionInfixSubstitution("ْوُC3ْ", "ُC3ْ")); // EX: (تَقُمْنَ، لم يَقُمْ، يَبُؤْ، يَؤُبْ)
        substitutions.add(new ExpressionInfixSubstitution("ْوُC3ّ", "ُC3ّ")); // EX: (أنتن تَصُنَّ، هنّ صُنَّ)
    }

    public List getSubstitutions() {
        return substitutions;
    }

}
