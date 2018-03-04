package sarf.noun.trilateral.unaugmented.modifier.timeandplace.hamza;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import sarf.noun.trilateral.unaugmented.modifier.*;

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
public class LamMahmouz extends AbstractLamMahmouz {
    List substitutions = new LinkedList();

    public LamMahmouz() {
        substitutions.add(new InfixSubstitution("óÁğÇ", "óÃğ")); // EX: (ãáÌÃğ¡ )
        substitutions.add(new InfixSubstitution("óÁñ", "óÃñ")); // EX: (ãáÌÃñ¡ )
        substitutions.add(new InfixSubstitution("óÁò", "óÃò")); // EX: (ãáÌÃò¡ )
        substitutions.add(new SuffixSubstitution("óÁõ", "óÃõ")); // EX: (ÇáãáÌÃõ¡ )
        substitutions.add(new SuffixSubstitution("óÁó", "óÃó")); // EX: (ÇáãáÌÃó ¡ )
        substitutions.add(new SuffixSubstitution("óÁö", "óÃö")); // EX: (ÇáãáÌÃö ¡ )
        substitutions.add(new InfixSubstitution("óÁóÇ", "óÂ")); // EX: (ãóáúÌóÂä¡ )
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ãóßúãóÃóÉ¡ ãóáúÌóÃóíúä¡ )
        substitutions.add(new InfixSubstitution("öÁ", "öÆ")); // EX: (ãóæúØöÆ¡)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
