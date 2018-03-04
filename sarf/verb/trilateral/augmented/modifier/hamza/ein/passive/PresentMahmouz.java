package sarf.verb.trilateral.augmented.modifier.hamza.ein.passive;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.hamza.ein.AbstractEinMahmouz;

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
public class PresentMahmouz extends AbstractEinMahmouz {

    private List substitutions = new LinkedList();

    public PresentMahmouz() {
        substitutions.add(new InfixSubstitution("íúÁó", "íúÆó")); // EX: (íõÓúÊóíúÆóÓõ¡ )
        substitutions.add(new InfixSubstitution("æúÁó", "æúÁó")); // EX: (íõÓúÊóæúÁóáõ¡ íõÓúÊóæúÁóì¡ )
        substitutions.add(new InfixSubstitution("æÁó", "æúÁó")); // EX: (íõæÁóÈõ¡ )
        substitutions.add(new InfixSubstitution("úÁó", "úÃó")); // EX: (íõÓúÃóãõ¡ íõÌúÃóáøõ¡ íõÓúÊóÑúÃóİõ¡ )
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (íõäúĞóÃÌõ¡ íõÈúÊóÃóÓõ¡ )
        substitutions.add(new InfixSubstitution("óÁøó", "óÃøó")); // EX: (íõÑóÃøóÓõ¡ íõÊóÑóÃøóİõ¡ )
        substitutions.add(new InfixSubstitution("øóÁó", "øóÃó")); // EX: (íõÊøóÃÏõ¡ )
        substitutions.add(new InfixSubstitution("ÇÁó", "ÇÁó")); // EX: (íõáÇÁóãõ¡ íõÊóÓÇÁóáõ¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
