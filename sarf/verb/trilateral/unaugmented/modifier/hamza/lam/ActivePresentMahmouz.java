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
public class ActivePresentMahmouz extends AbstractLamMahmouz {
    private List substitutions = new ArrayList();

    public ActivePresentMahmouz() {
        substitutions.add(new SuffixSubstitution("óÁõ", "óÃõ")); // EX: (åæ íÈÏÃ)
        substitutions.add(new InfixSubstitution("óÁú", "óÃú")); // EX: (åäøó íÈÏÃúäó¡ áã íóÈúÏóÃú)
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (åãÇ íÈÏÃÇä¡ áä íÈÏÃ)
        substitutions.add(new InfixSubstitution("óÁõ", "óÄõ")); // EX: (åã íÈÏÄæä)
        substitutions.add(new InfixSubstitution("Áö", "Æö")); // EX: (ÃäÊö ÊÈÏÆíä¡ ÊóÌúÑõÆíä¡ ÊóÈõæÆíä¡ ÊÏÇÆíä¡ ÊóŞöíÆöíäó)
        substitutions.add(new InfixSubstitution("õÁõ", "õÄõ")); // EX: (íóÌúÑõÄõ)
        substitutions.add(new InfixSubstitution("õÁó", "õÄó")); // EX: (áä íóÌúÑõÄó)
        substitutions.add(new InfixSubstitution("õÁú", "õÄú")); // EX: (áã íÌÑõÄú¡ áã íóÈõÄú¡ åäøó íóÈõÄúäó)
        substitutions.add(new InfixSubstitution("öÁú", "öÆú")); // EX: (áã íóŞöÆú¡ åäø íóŞöÆúäó)
        substitutions.add(new InfixSubstitution("ÇÁõæ", "ÇÄõæ")); // EX: (åã íóÏÇÄæä)
        substitutions.add(new InfixSubstitution("ÇÁõä", "ÇÄõä")); // EX: (åã íÔÇÄõäøó¡)
        substitutions.add(new InfixSubstitution("íÁóÇ", "íÆóÇ")); // EX: (åãÇ íóŞöíÆóÇä)
        substitutions.add(new InfixSubstitution("íÁóä", "íÆóä")); // EX: (åæ íóŞöíÆóäøó)
        substitutions.add(new InfixSubstitution("íÁõæ", "íÆõæ")); // EX: (åã íóŞöíÆõæäó)
        substitutions.add(new InfixSubstitution("íÁõä", "íÆõä")); // EX: (åã íÌíÆäøó)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
