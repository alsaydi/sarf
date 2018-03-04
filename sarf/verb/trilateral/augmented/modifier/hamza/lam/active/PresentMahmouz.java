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
public class PresentMahmouz extends AbstractLamMahmouz {

    private List substitutions = new LinkedList();

    public PresentMahmouz() {
        substitutions.add(new SuffixSubstitution("íÁõ", "íÁõ")); // EX: (íõÓöíÁõ¡ )
        substitutions.add(new SuffixSubstitution("íÁó", "íÁó")); // EX: (áä íõÓöíÁó¡ )
        substitutions.add(new InfixSubstitution("íÁ", "íÆ")); // EX: (íõÓöíÆóÇäö¡ íõÓöíÆõæäö)
        substitutions.add(new SuffixSubstitution("óÁõ", "óÃõ")); // EX: (íóÊóÏÇÑóÃõ¡ )
        substitutions.add(new SuffixSubstitution("øóÁõ", "øóÃõ")); // EX: (íóÊóÎóÈøóÃõ¡ )
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (áä íóÊóÏÇÑóÃó¡ íóÊóÏÇÑóÃóÇäö¡ )
        substitutions.add(new InfixSubstitution("óÁõ", "óÄõ")); // EX: (ÊóÊóÏÇÑóÄõæäó¡ )
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (áã íóÊóÏÇÑóÃú¡ ÊóÊóÏÇÑóÃúäó¡ )
        substitutions.add(new InfixSubstitution("øóÁó", "øóÃó")); // EX: (áä íÊÎÈøóÃó¡ íóÊóÎóÈøóÃóÇäö¡ )
        substitutions.add(new InfixSubstitution("øóÁõ", "øóÄõ")); // EX: (ÊÊÎÈøóÄõæäó¡ )
        substitutions.add(new InfixSubstitution("øóÁú", "øóÃú")); // EX: (áã íÊÎÈøóÃú¡ ÊÊÎÈøóÃúäó¡ )
        substitutions.add(new SuffixSubstitution("ÇÁõ", "ÇÁõ")); // EX: (íóÓúÊÇÁõ¡ )
        substitutions.add(new InfixSubstitution("ÇÁõ", "ÇÄõ")); // EX: (íóÓúÊÇÄõæäó¡ )
        substitutions.add(new InfixSubstitution("Áö", "Æö")); // EX: (ÊóÓúÊÇÆöíäó¡ ÊõÓöíÆöíäó¡ ÊÊÏÇÑóÆöíäó¡ ÊÊÎÈøóÆöíäó¡ )
        substitutions.add(new InfixSubstitution("öÁ", "öÆ")); // EX: (íõÌúÒöÆõ¡ áä íõÌúÒöÆó¡ áã íõÌúÒöÆú¡ íßÇİöÆõ¡ íóäúİŞöÆõ¡ íóÈúÊÏöÆõ¡ íÓÊåÒöÆõ¡ íóÍúÒóæúÒöÆõ¡ )
        substitutions.add(new InfixSubstitution("øöÁ", "øöÆ")); // EX: (íõÌúÒøöÆõ¡ áä íõÌúÒøöÆó¡ áã íõÌúÒøöÆú¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
