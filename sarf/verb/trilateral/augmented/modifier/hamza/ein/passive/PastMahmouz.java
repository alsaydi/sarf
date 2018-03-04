package sarf.verb.trilateral.augmented.modifier.hamza.ein.passive;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.hamza.ein.*;

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
public class PastMahmouz extends AbstractEinMahmouz {

    private List substitutions = new LinkedList();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("Áö", "Æö")); // EX: (ÃõÓúÆöãó¡ áõæÆöãó¡ ÇäúĞõÆöÌó¡ ÇÈÊõÆöÓó¡ ÊõÓõæÆöáó¡ ÇÓÊõÑÆöİó¡ ÇÊøõÆöÏó¡ )
        substitutions.add(new InfixSubstitution("úÁõ", "úÄõ")); // EX: (ÇÌúÄõáøó¡ )
        substitutions.add(new InfixSubstitution("õÁõ","õÄõ"));// EX: (ÇÑÊõÄõæÇ¡ )
        substitutions.add(new InfixSubstitution("õÁøö", "õÆøö")); // EX: (ÑõÆøöÓó¡ ÊõÑõÆøöİó¡ )
        substitutions.add(new InfixSubstitution("õÁøõ", "õÄøõ")); // EX: (ÑõÄøõæÇ¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
