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
public class EinMahmouz extends AbstractEinMahmouz {
    List substitutions = new LinkedList();

    public EinMahmouz() {
        substitutions.add(new InfixSubstitution("æúÁó", "æúÁó")); // EX: (ãõÓúÊóæúÁóá)
        substitutions.add(new InfixSubstitution("íúÁó", "íúÆó")); // EX: (ãõÓúÊóíúÆóÓ)
        substitutions.add(new InfixSubstitution("úÁğ", "úÃğ")); // EX: (ãõäúÃğì¡ ãõãúÃğì)
        substitutions.add(new InfixSubstitution("óÁğ", "óÃğ")); // EX: (ãõäúİóÃğì)
        substitutions.add(new InfixSubstitution("úÁóÇ", "úÂ")); // EX: (ãõäúÂÉ¡ ãõãúÂÉ)
        substitutions.add(new InfixSubstitution("óÁóÇ", "óÂ")); // EX: (ãõäúİóÂÉ)
        substitutions.add(new InfixSubstitution("úÁó", "úÃó")); // EX: (ãõÔúÃóãñ¡ ãõÈúÊóÃóÓñ¡ ãõÓúÊóÑúÃóİñ¡ ãõÌúÃóáøñ)
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ãõäúĞóÃÌ)
        substitutions.add(new InfixSubstitution("óÁøóÇ", "óÂøó")); // EX: (ãõÑóÂøóÉ)
        substitutions.add(new InfixSubstitution("óÁøó", "óÃøó")); // EX: (ãõÑóÃøóÓñ¡ ãõÊóÑóÃøóİñ)
        substitutions.add(new InfixSubstitution("óÁøğ", "óÃøğ")); // EX: (ãõÑóÃøğì)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
