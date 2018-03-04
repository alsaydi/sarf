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
public class ImperativeMahmouz extends AbstractEinMahmouz {

    private List substitutions = new LinkedList();

    public ImperativeMahmouz() {
        substitutions.add(new InfixSubstitution("æúÁõ","æúÁõ"));// EX: (ÇÓúÊóæúÁõæÇ)
        substitutions.add(new SuffixSubstitution("ÇÁö","ÇÁö"));// EX: (ÑóÇÁö)
        substitutions.add(new SuffixSubstitution("óÁö","óÆö"));// EX: (ÇäúİóÆö¡ ÇÔúÊóÆö)
        substitutions.add(new SuffixSubstitution("úÁö","úÆö"));// EX: (ÃäúÆö)
        substitutions.add(new SuffixSubstitution("óÁøö","óÆøö"));// EX: (ÑóÆøö)
        substitutions.add(new InfixSubstitution("Áö","Æö"));// EX: (ÃÓúÆöãú¡ ÇÓúÊóÑúÆöİú¡ ÃæúÆöÈú¡ ÇäúĞóÆöÌú¡ ÇÈúÊóÆöÓú¡ ÇÊøóÆöÏú¡ áÇÆöãú)
        substitutions.add(new InfixSubstitution("óÁøö","óÆøö"));// EX: (ÑóÆøöÓú¡  )
        substitutions.add(new InfixSubstitution("óÁøó","óÃøó"));// EX: (ÊÑóÃøóİú¡ )
        substitutions.add(new InfixSubstitution("óÁøõ","óÄøõ"));// EX: (ÑóÄøõæÇ¡  )
        substitutions.add(new InfixSubstitution("óÁõ","óÄõ"));// EX: (ÇäúİóÄõæÇ¡ ÇÑúÊóÄõæÇ)
        substitutions.add(new InfixSubstitution("úÁõ","úÄõ"));// EX: (ÇäúÄõæÇ¡ )
        substitutions.add(new InfixSubstitution("úÁó","úÃó"));// EX: (ÇÌúÃóáøó¡ íóÌúÃæøöí¡ )
        substitutions.add(new InfixSubstitution("ÇÁó","ÇÁó"));// EX: (ÊóİÇÁóáú¡ )
        substitutions.add(new InfixSubstitution("ÇÁõ","ÇÄõ"));// EX: (ÑÇÄõæÇ¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
