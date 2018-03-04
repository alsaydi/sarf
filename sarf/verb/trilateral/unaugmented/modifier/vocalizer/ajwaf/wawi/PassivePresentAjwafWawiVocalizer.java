package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.wawi;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.*;
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
public class PassivePresentAjwafWawiVocalizer extends AbstractAjwafWawiVocalizer {
    private List substitutions = new LinkedList();

    public PassivePresentAjwafWawiVocalizer() {
        //نفس القائمة في listed

        substitutions.add(new ExpressionInfixSubstitution("ْوَC3ُ","َاC3ُ"));// EX: (يُقام، يُخاف، لن تُخافُوا، يُداء)
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3ِ","َاC3ِ"));// EX: (تُقامين، تُخافين، لن تُخافي، )
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3َ","َاC3َ"));// EX: (تُقامان، تُخافان، لن يُخافَ، يُخافَنَّ)
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3ْ","َC3ْ"));// EX: (تُقَمْنَ، تُخَفْنَ، لم تُخَفْ)
        substitutions.add(new ExpressionInfixSubstitution("ْوَC3ّ","َC3ّ"));// EX: (أنتن تُصَنَّ، هن يُصَنَّ)

    }

    public List getSubstitutions() {
        return substitutions;
    }

}
