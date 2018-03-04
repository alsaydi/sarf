package sarf.verb.trilateral.augmented.modifier.hamza.ein.active;

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
        substitutions.add(new InfixSubstitution("æúÁó", "æúÁó")); // EX: (ÇÓúÊóæúÁóì)
        substitutions.add(new InfixSubstitution("íúÁó", "íúÆó")); // EX: (ÇíúÆóÓó)
        substitutions.add(new InfixSubstitution("úÁó", "úÃó")); // EX: (ÃÓúÃãó¡ ÇÌúÃóáøó¡ ÇÓÊÑúÃóİó¡ ÇÌúÃóæøóì)
        substitutions.add(new InfixSubstitution("óÁøó", "óÃøó")); // EX: (ÑÃøóÓó¡ ÊÑÃøóİó¡ )
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ÇäĞóÃóÌó¡ ÇÈÊóÃóÓó¡ )
        substitutions.add(new InfixSubstitution("øóÁó", "øóÃó")); // EX: (ÇÊøóÃóÏó¡ )
        substitutions.add(new InfixSubstitution("ÇÁó", "ÇÁó")); // EX: (áÇÁóãó¡ ÊİÇÁóáó¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
