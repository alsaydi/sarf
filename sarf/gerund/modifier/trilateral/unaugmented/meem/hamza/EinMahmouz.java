package sarf.gerund.modifier.trilateral.unaugmented.meem.hamza;

import java.util.*;

import sarf.noun.trilateral.unaugmented.modifier.*;
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
public class EinMahmouz extends AbstractEinMahmouz {
    List substitutions = new LinkedList();

    public EinMahmouz() {
        substitutions.add(new InfixSubstitution("æúÁó", "æúÁó")); // EX: (ãóæúÁóá¡ ãóæúÁóì)
        substitutions.add(new InfixSubstitution("æúÁğ", "æúÁğ")); // EX: ( ãóæúÁğì)
        substitutions.add(new InfixSubstitution("íúÁó", "íúÆó")); // EX: (ãóíúÆóÓ)
        substitutions.add(new InfixSubstitution("úÁó", "úÃó")); // EX: (ãóäúÃóã)
        substitutions.add(new InfixSubstitution("úÁğ","úÃğ"));// EX: (ãóÌúÃğì)
        substitutions.add(new InfixSubstitution("Áö", "Æö")); // EX: (ãóæúÆöÏ)

    }


    public List getSubstitutions() {
        return substitutions;
    }
}
