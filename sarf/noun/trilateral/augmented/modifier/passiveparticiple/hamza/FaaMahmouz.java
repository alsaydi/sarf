package sarf.noun.trilateral.augmented.modifier.passiveparticiple.hamza;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.augmented.modifier.*;

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
public class FaaMahmouz extends AbstractFaaMahmouz {
    List substitutions = new LinkedList();

    public FaaMahmouz() {
        substitutions.add(new InfixSubstitution("óÁóÇ", "óÂ")); // EX: (ãõÊÂßóáñ)
        substitutions.add(new InfixSubstitution("úÁóÇ","úÂ"));// EX: (ãõäúÂÏ)
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ãõÊÃßøóÏ)
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (ãõÓÊóÃúãóÑ)
        substitutions.add(new InfixSubstitution("úÁó", "úÃó")); // EX: (ãõäúÃóØóÑñ)
        substitutions.add(new InfixSubstitution("õÁ", "õÄ")); // EX: (ãõÄúËóÑñ¡ ãõÄóËøóÑñ¡ ãõÄóÇÌóÑñ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
