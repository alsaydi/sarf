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
public class PresentMahmouz extends AbstractEinMahmouz {

    private List substitutions = new LinkedList();

    public PresentMahmouz() {
        substitutions.add(new InfixSubstitution("æúÁõ","æúÁõ"));// EX: (íóÓúÊóæúÁõæäó)
        substitutions.add(new InfixSubstitution("íúÁó","íúÆó"));// EX: (íóíúÆóÓó)
        substitutions.add(new SuffixSubstitution("ÇÁö","ÇÁö"));// EX: (áã íõÑÇÁö¡)
        substitutions.add(new SuffixSubstitution("óÁö","óÆö"));// EX: (áã íóäúİóÆö¡ áã íóÔúÊóÆö¡)
        substitutions.add(new SuffixSubstitution("óÁøö","óÆøö"));// EX: (áã íõÑóÆøö)
        substitutions.add(new SuffixSubstitution("úÁö","úÆö"));// EX: (áã íõäúÆö¡ )
        substitutions.add(new InfixSubstitution("Áö","Æö"));// EX: (íõÓúÆöã¡ íóÓúÊóÑÆöİõ¡ íõæÆöÈõ¡ íóäúĞóÆöÌõ¡ íóÈúÊóÆöÓõ¡ íóÊøóÆöÏõ¡ íõáÇÆöãõ)
        substitutions.add(new InfixSubstitution("úÁõ","úÄõ"));// EX: (íõäúÄõæäó¡ )
        substitutions.add(new InfixSubstitution("úÁó","úÃó"));// EX: (íóÌúÃóáøõ¡ íóÌúÃæøöí¡ )
        substitutions.add(new InfixSubstitution("óÁøó","óÃøó"));// EX: (íÊÑóÃøóİõ¡ )
        substitutions.add(new InfixSubstitution("óÁøõ","óÄøõ"));// EX: (íõÑóÄøõæäó¡ )
        substitutions.add(new InfixSubstitution("óÁõ","óÄõ"));// EX: (íóäúİóÄõæäó¡ íóÑúÊóÄõæäó)
        substitutions.add(new InfixSubstitution("óÁøö","óÆøö"));// EX: (íõÑóÆøöÓõ¡ )
        substitutions.add(new InfixSubstitution("ÇÁó","ÇÁó"));// EX: (íóÊóİÇÁóáõ¡ )
        substitutions.add(new InfixSubstitution("ÇÁõ","ÇÄõ"));// EX: (íõÑÇÄõæäó¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
