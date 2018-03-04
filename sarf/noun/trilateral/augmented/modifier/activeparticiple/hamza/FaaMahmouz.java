package sarf.noun.trilateral.augmented.modifier.activeparticiple.hamza;

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

        substitutions.add(new InfixSubstitution("óÁóÇ","óÂ"));// EX: (ãõÊÂßöáñ)
        substitutions.add(new InfixSubstitution("úÁóÇ","úÂ"));// EX: (ãõäúÂÏ)
        substitutions.add(new InfixSubstitution("óÁó","óÃó"));// EX: (ãõÊÃßøöÏ)
        substitutions.add(new InfixSubstitution("óÁú","óÃú"));// EX: (ãõÓÊóÃúãöÑ)
        substitutions.add(new InfixSubstitution("úÁó","úÃó"));// EX: (ãõäúÃóØöÑñ)
        substitutions.add(new InfixSubstitution("Áö","Æö"));// EX: (ãõÆöíÓñ)
        substitutions.add(new InfixSubstitution("õÁ","õÄ"));// EX: (ãõÄúËöÑñ¡ ãõÄóËøöÑñ¡ ãõÄóÇÌöÑñ)

    }


    public List getSubstitutions() {
        return substitutions;
    }
}
