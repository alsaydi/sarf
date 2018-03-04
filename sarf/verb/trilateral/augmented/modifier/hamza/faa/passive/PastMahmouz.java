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
public class PastMahmouz extends AbstractFaaMahmouz {

    private List substitutions = new LinkedList();

    public PastMahmouz() {
        substitutions.add(new ExpressionInfixSubstitution("ÃõÁúíöC3ú","ÃõÆöC3ú"));// EX: (ÃõÆöÓÊõ )
        substitutions.add(new InfixSubstitution("ÃõÁúíö","ÃõÆöí"));// EX: (ÃõÆöíÓ )
        substitutions.add(new InfixSubstitution("ÃõÁú", "Ãõæ")); // EX: (ÃõæËöÑó¡ )
        substitutions.add(new InfixSubstitution("ÇÁúÊö","ÇÆúÊö"));// EX: (ÇÆúÊöáúÊõ¡ )
        substitutions.add(new InfixSubstitution("Áö","Æö"));// EX: (ÇäúÆöíÏóó¡ ÇÓÊõÆãø )
        substitutions.add(new InfixSubstitution("úÁõ", "úÄõ")); // EX: (ÇäúÄõØöÑó¡ )
        substitutions.add(new PrefixSubstitution("Áõ", "Ãõ")); // EX: (ÃõËøöÑó¡ ÃõæÌöÑó¡ )
        substitutions.add(new InfixSubstitution("ÇÁú", "ÇÄú")); // EX: (ÇÄúÊõãöÑó¡ )

        substitutions.add(new InfixSubstitution("õÁõ", "õÄõ")); // EX: (ÊõÄõæßöáó¡ ÊõÄõßøöÏó¡ )
        substitutions.add(new InfixSubstitution("õÁú", "õÄú")); // EX: (ÇÓÊõÄúßöáó¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
