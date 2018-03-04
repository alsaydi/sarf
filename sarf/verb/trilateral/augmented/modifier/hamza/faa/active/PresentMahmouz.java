package sarf.verb.trilateral.augmented.modifier.hamza.faa.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.hamza.faa.*;

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
public class PresentMahmouz extends AbstractFaaMahmouz {

    private List substitutions = new LinkedList();

    public PresentMahmouz() {

        substitutions.add(new InfixSubstitution("ÃõÁú", "Ãõæ")); // EX: (ÃäÇ ÃõæËöÑõ¡ )
        substitutions.add(new InfixSubstitution("ÃóÁú", "Â")); // EX: (ÃäÇ ÂÊóãöÑõ¡ )
        substitutions.add(new InfixSubstitution("óÁóÇ", "óÂ")); // EX: (íóÊóÂßóáõ)
        substitutions.add(new InfixSubstitution("úÁóÇ", "úÂ")); // EX: (íóäúÂÏõ)
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (íóÃúÊóãöÑõ¡ íÓúÊóÃúãöÑõ)
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (íóÊóÃóßøóÏõ¡ )
        substitutions.add(new InfixSubstitution("óÁö", "óÆö")); // EX: (íóÓúÊóÆöãøõ¡ )
        substitutions.add(new InfixSubstitution("õÁö", "õÆö")); // EX: (íõÆöíÓõ¡ )
        substitutions.add(new InfixSubstitution("õÁú", "õÄú")); // EX: (íõÄúËöÑõ¡ )
        substitutions.add(new InfixSubstitution("õÁó", "õÄó")); // EX: (íõÄóËøöÑõ¡ íõÄóÇÌóÑõ¡ )
        substitutions.add(new InfixSubstitution("úÁó", "úÃó")); // EX: (íóäúÃØöÑõ¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
