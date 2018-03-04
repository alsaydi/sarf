package sarf.verb.trilateral.augmented.modifier.hamza.lam.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.hamza.lam.*;

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
public class ImperativeMahmouz extends AbstractLamMahmouz {

    private List substitutions = new LinkedList();

    public ImperativeMahmouz() {
        substitutions.add(new InfixSubstitution("íÁó","íÆó"));// EX: (ÃóÓöíÆóÇ¡ )
        substitutions.add(new InfixSubstitution("íÁõ","íÆõ"));// EX: (ÃóÓöíÆõæÇ¡ )
        substitutions.add(new InfixSubstitution("öÁ","öÆ"));// EX: (ÃõÌúÒöÆú¡ ßÇİöÆú¡ ÇäúİóŞöÆú¡ ÇÈÊóÏöÆú¡ ÇÓÊåÒöÆú¡ ÇÍúÒóæúÒöÆú¡ ÃóÓöÆú¡ )
        substitutions.add(new InfixSubstitution("Áö","Æö"));// EX: (ÊßÇİÆí )
        substitutions.add(new InfixSubstitution("øöÁ","øöÆ"));// EX: (ÌóÒøöÆú¡ )
        substitutions.add(new InfixSubstitution("óÁú","óÃú"));// EX: (ÊÏÇÑóÃú¡ ÊÏÇÑóÃúäó¡ ÇÓúÊóÃú)
        substitutions.add(new InfixSubstitution("óÁó","óÃó"));// EX: (ÊÏÇÑóÃóÇ¡ )
        substitutions.add(new InfixSubstitution("óÁõ","óÄõ"));// EX: (ÊÏÇÑóÄõæÇ¡ )
        substitutions.add(new InfixSubstitution("øóÁú","øóÃú"));// EX: (ÊóÎóÈøóÃú¡ ÊóÎóÈøóÃúäó¡ )
        substitutions.add(new InfixSubstitution("øóÁó","øóÃó"));// EX: (ÊóÎóÈøóÃóÇ¡ )
        substitutions.add(new InfixSubstitution("øóÁõ","øóÄõ"));// EX: (ÊóÎóÈøóÄõæÇ¡ )
        substitutions.add(new InfixSubstitution("ÇÁõ","ÇÄõ"));// EX: (ÇÓúÊÇÄõæÇ¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
