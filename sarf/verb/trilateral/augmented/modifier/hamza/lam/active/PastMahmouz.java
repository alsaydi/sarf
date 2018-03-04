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
public class PastMahmouz extends AbstractLamMahmouz {

    private List substitutions = new LinkedList();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (ÃÌúÒóÃúÊõ¡ ßÇİÃúÊõ¡ ÇäİŞóÃúÊõ¡ ÇÈÊÏóÃúÊõ¡ ÊÏÇÑóÃúÊõ¡ ÇÓÊóåúÒóÃúÊõ¡ ÇÍúÒóæúÒóÃúÊõ)
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ÃÌúÒóÃó¡ ßÇİóÃó¡ ÇäúİóŞóÃó¡ ÇÈÊÏóÃó¡ ÊÏÇÑóÃó¡ ÇÓÊóåúÒóÃó¡ ÇÍúÒóæúÒóÃó¡ )
        substitutions.add(new InfixSubstitution("óÁõ", "óÄõ")); // EX: (ÃÌúÒóÄõæÇ¡ ßÇİóÄõæÇ¡ ÇäİŞóÄõæÇ¡ ÇÈÊÏóÄõæÇ¡ ÊÏÇÑóÄõæÇ¡ ÇÓÊóåúÒóÄõæÇ¡ ÇÍúÒóæúÒóÄõæÇ)
        substitutions.add(new InfixSubstitution("øóÁú", "øóÃú")); // EX: (ÌóÒøóÃúÊõ¡ ÊóÎóÈøóÃúÊõ¡ )
        substitutions.add(new InfixSubstitution("øóÁó", "øóÃó")); // EX: (ÌóÒøóÃó¡ ÊóÎóÈøóÃó¡)
        substitutions.add(new InfixSubstitution("øóÁõ", "øóÄõ")); // EX: (ÌóÒøóÄõæÇ¡ ÊóÎóÈøóÄõæÇ¡ )
        substitutions.add(new InfixSubstitution("ÇÁó", "ÇÁó")); // EX: (ÃÓÇÁó¡ ÇÓÊÇÁó¡ )
        substitutions.add(new InfixSubstitution("ÇÁõ", "ÇÄõ")); // EX: (ÃÓÇÄõæÇ¡ ÇÓÊÇÄõæÇ¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
