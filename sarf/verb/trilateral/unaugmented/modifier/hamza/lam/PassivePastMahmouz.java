package sarf.verb.trilateral.unaugmented.modifier.hamza.lam;

import java.util.*;
import sarf.verb.trilateral.unaugmented.modifier.hamza.*;
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
public class PassivePastMahmouz extends AbstractLamMahmouz {
    private List substitutions = new ArrayList();

    public PassivePastMahmouz() {
        substitutions.add(new InfixSubstitution("öÁ", "öÆ")); // EX: (ÈõÏöÆó¡ ÙõãöÆó¡ ÌõÑöÆó¡ åõæöÆó)
        substitutions.add(new InfixSubstitution("íÁõæ", "íÆõæ")); // EX: (ÈöíÆõæÇ¡ ŞöíÆõæÇ¡ ÔöíÆõæÇ)
        substitutions.add(new SuffixSubstitution("íÁó", "íÁó")); // EX: (ÈöíÁó¡ ŞöíÁó¡ ÔöíÁó¡ ÓöíÁó)
        substitutions.add(new InfixSubstitution("íÁó", "íÆó")); // EX: (ÈöíÆóÇ¡ ŞöíÆóÇ¡ ÔöíÆóÇ¡ ÓöíÆóÊú)
        substitutions.add(new InfixSubstitution("õÁú", "õÄú")); // EX: (ÌõÄúÊõ)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
