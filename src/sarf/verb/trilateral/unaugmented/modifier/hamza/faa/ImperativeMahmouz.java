package sarf.verb.trilateral.unaugmented.modifier.hamza.faa;

import java.util.*;
import sarf.verb.trilateral.unaugmented.modifier.hamza.*;
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
public class ImperativeMahmouz extends AbstractFaaMahmouz {
    private List substitutions = new ArrayList();

    public ImperativeMahmouz() {
        substitutions.add(new ExpressionInfixSubstitution("اءْC2َ", "ائْC2َ")); // EX: (ائْبَه)
        substitutions.add(new ExpressionInfixSubstitution("اءْC2ِ", "ائْC2ِ")); // EX: (ائْسِر)
        substitutions.add(new ExpressionInfixSubstitution("اءْC2ُ", "اؤْC2ُ")); // EX: (اؤْنُث)
        substitutions.add(new ExpressionInfixSubstitution("ءُC3","أُC3"));// EX: (أُبْ)
        substitutions.add(new PrefixSubstitution("ءِ", "إِ")); // EX: (أنتَ إِنَّ، إمْ)
        substitutions.add(new PrefixSubstitution("ءُ","أُ"));// EX: (أنتِ أُولي)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
