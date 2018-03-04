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
public class ImperativeMahmouz extends AbstractFaaMahmouz {

    private List substitutions = new LinkedList();

    public ImperativeMahmouz() {
        substitutions.add(new InfixSubstitution("ÃóÁú","Â"));// EX: (ÂËöÑú¡  )
        substitutions.add(new InfixSubstitution("ÁóÇ","Â"));// EX: (ÂÌöÑú¡ ÊÂßóáú¡ )
        substitutions.add(new InfixSubstitution("úÁó","úÃó"));// EX: (ÇäúÃØöÑú¡ )
        substitutions.add(new InfixSubstitution("ÇÁú","ÇÆú"));// EX: (ÇÆúÊóãöÑú¡ )
        substitutions.add(new InfixSubstitution("óÁó","óÃó"));// EX: (ÊóÃóßøóÏú¡ )
        substitutions.add(new InfixSubstitution("óÁú","óÃú"));// EX: (ÇÓúÊóÃúãöÑú¡ )
        substitutions.add(new InfixSubstitution("óÁö","óÆö"));// EX: (ÇÓúÊóÆöãøó¡ ÃóÆöÓú)
        substitutions.add(new InfixSubstitution("Áó","Ãó"));// EX: (ÃËøöÑú¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
