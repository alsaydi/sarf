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
public class PassivePresentMahmouz extends AbstractLamMahmouz {
    private List substitutions = new ArrayList();

    public PassivePresentMahmouz() {
        substitutions.add(new SuffixSubstitution("óÁõ", "óÃõ")); // EX: (åæ íõæØóÃõ)
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (åäøó íõÈÏÃúäó¡ áã íõÈúÏóÃú)
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (åãÇ íõÈÏÃÇä¡ áä íõÈÏÃ)
        substitutions.add(new InfixSubstitution("óÁõ", "óÄõ")); // EX: (åã íõÈÏÄæä)
        substitutions.add(new InfixSubstitution("Áö", "Æö")); // EX: (ÃäÊö ÊõÈÏÆíä¡ ÊõÈÇÆíä¡ ÊõÏÇÆíä¡ ÊÔÇÆíä)
        substitutions.add(new InfixSubstitution("ÇÁõæ", "ÇÄõæ")); // EX: (åã íõÈÇÄõæä¡  íõÏÇÄæä¡ íõÔÇÄæä)
        substitutions.add(new InfixSubstitution("ÇÁõä", "ÇÄõä")); // EX: (åã íÓÇÄõäøó¡ íÌÇÄäøó)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
