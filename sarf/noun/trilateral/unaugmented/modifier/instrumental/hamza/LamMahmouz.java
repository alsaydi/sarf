package sarf.noun.trilateral.unaugmented.modifier.instrumental.hamza;

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

        substitutions.add(new SuffixSubstitution("óÁõ","óÃõ"));// EX: (ÇáãöŞúÑÃõ)
        substitutions.add(new SuffixSubstitution("óÁö","óÃö"));// EX: (ÇáãöŞúÑÃö)
        substitutions.add(new InfixSubstitution("ÇÁğÇ","ÇÁğ"));// EX: (ãÆËÇÁğ)
        substitutions.add(new InfixSubstitution("óÁñ", "óÃñ")); // EX: (ãöİúŞóÃñ)
        substitutions.add(new InfixSubstitution("óÁğÇ", "óÃğ")); // EX: (ãöİúŞóÃğ)
        substitutions.add(new InfixSubstitution("óÁò", "óÃò")); // EX: (ãöİúŞóÃò)
        substitutions.add(new InfixSubstitution("óÁóÇ", "óÂ")); // EX: (ãöİúŞÂä)
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ãöİŞÃíúä¡ ãöİŞÃÉ¡ ãöİŞÃÊÇä)
        substitutions.add(new InfixSubstitution("öÁ", "öÆ")); // EX: (ŞÇÑÆÉ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
