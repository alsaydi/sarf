package sarf.verb.trilateral.augmented.modifier.hamza.faa.passive;

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
        substitutions.add(new InfixSubstitution("ÃõÁú", "Ãõæ")); // EX: (ÃõæËóÑõ¡ ÃæúÊóãóÑõ¡ )
        substitutions.add(new InfixSubstitution("óÁóÇ", "óÂ")); // EX: (íõÊóÂßóáõ¡ )
        substitutions.add(new InfixSubstitution("úÁóÇ", "úÂ")); // EX: (íõäÂÏõ )
        substitutions.add(new InfixSubstitution("õÁú", "õÄú")); // EX: (íõÄúËóÑõ¡ íõÄúÊóãóÑõ¡ )
        substitutions.add(new InfixSubstitution("õÁó", "õÄó")); // EX: (íõÄóËøóÑõ¡ íõÄóÇÌóÑõ¡ )
        substitutions.add(new InfixSubstitution("úÁó", "úÃó")); // EX: (íõäúÃóØóÑõ¡ )
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (íõÊóÃßøóÏõ¡ )
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (íõÓúÊÃãóÑõ¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
