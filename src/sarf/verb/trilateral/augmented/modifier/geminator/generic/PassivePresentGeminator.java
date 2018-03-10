package sarf.verb.trilateral.augmented.modifier.geminator.generic;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;

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
public class PassivePresentGeminator extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public PassivePresentGeminator() {

        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3ُ","َC3ُّ"));// EX: (يُتَمُّ،)
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3َ","َC3َّ"));// EX: (يُتَمَّان،)
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3ِ","َC3ِّ"));// EX: (تُتَمِّي،)
        substitutions.add(new ExpressionSuffixSubstitution("ْC3َC3ْ","َC3َّ"));// EX: (لم يُتَمَّ،)
        substitutions.add(new ExpressionSuffixSubstitution("َC3َC3ْ","َC3َّ"));// EX: (لم يُنْقَضَّ، يُشْتَدَّ)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3ُ","اC3ُّ"));// EX: (يُتَصَامُّ، يُحاجّ)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3َ","اC3َّ"));// EX: (يُتَصَامَّا، يحاجّا)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3ِ","اC3ِّ"));// EX: (تُتَصَامِّي، تحاجِي)
        substitutions.add(new ExpressionSuffixSubstitution("اC3َC3ْ","اC3َّ"));// EX: (لم يُتَصَامَّ، يحاجَّ)
        substitutions.add(new ExpressionInfixSubstitution("َC3َC3ُ","َC3ُّ"));// EX: (يُحْمَرُّ، يُقْتَضُّ)
        substitutions.add(new ExpressionInfixSubstitution("َC3َC3َ","َC3َّ"));// EX: (لن يُحْمَرَّ، لن يُنْقَضَّ، لن يُشتدَّ)
        substitutions.add(new ExpressionInfixSubstitution("َC3َC3ِ","َC3ِّ"));// EX: (تُنقَضِّين)

    }

    public List getSubstitutions() {
        return substitutions;
    }
}
