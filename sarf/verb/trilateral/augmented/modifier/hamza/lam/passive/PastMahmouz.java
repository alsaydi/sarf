package sarf.verb.trilateral.augmented.modifier.hamza.lam.passive;

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
        substitutions.add(new SuffixSubstitution("íÁó", "íÁó")); // EX: (ÃõÓöíÁó¡ )
        substitutions.add(new InfixSubstitution("íÁ", "íÆ")); // EX: (ÃÓöíÆóÇ¡ ÃõÓöíÆõæÇ)
        substitutions.add(new InfixSubstitution("õÁú", "õÄú")); // EX: (ÇÓÊõÄúÊõ¡ )
        substitutions.add(new InfixSubstitution("öÁ", "öÆ")); // EX: (ÃõÌúÒöÆó¡ ßõæİöÆó¡ ÇäúİõŞöÆó¡ ÇÈÊõÏöÆó¡ ÊõÏõæÑöÆó¡ ÇÓÊõåúÒöÆó¡ ÇÍúÒõæÒöÆó¡ )
        substitutions.add(new InfixSubstitution("øöÁ", "øöÆ")); // EX: (ÌõÒøöÆó¡ ÊõÎõÈøöÆó¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
