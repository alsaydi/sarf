package sarf.noun.trilateral.augmented.modifier.activeparticiple.hamza;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.augmented.modifier.*;

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

        substitutions.add(new SuffixSubstitution("ÇÁó","ÇÁó"));// EX: (ãÓÊÇÁó)
        substitutions.add(new SuffixSubstitution("ÇÁõ","ÇÁõ"));// EX: (ãÓÊÇÁõ)
        substitutions.add(new SuffixSubstitution("ÇÁö","ÇÁö"));// EX: (ãÓÊÇÁö)
        substitutions.add(new SuffixSubstitution("íÁó", "íÁó")); // EX: (ãõÏöíÁó)
        substitutions.add(new SuffixSubstitution("íÁõ", "íÁõ")); // EX: (ãõÏöíÁõ)
        substitutions.add(new SuffixSubstitution("íÁö", "íÁö")); // EX: (ãõÏöíÁö)
        substitutions.add(new InfixSubstitution("ÇÁğÇ", "ÇÁğ")); // EX: (ãõÓúÊÇÁğ)
        substitutions.add(new InfixSubstitution("ÇÁõ", "ÇÄõ")); // EX: (ãõÓúÊÇÄõæä)
        substitutions.add(new InfixSubstitution("ÇÁö", "ÇÆö")); // EX: (ãõÓúÊÇÆíä)
        substitutions.add(new InfixSubstitution("íÁñ", "íÁñ")); // EX: (ãõÏöíÁñ)
        substitutions.add(new InfixSubstitution("íÁò", "íÁò")); // EX: (ãõÏöíÁò)
        substitutions.add(new InfixSubstitution("íÁ", "íÆ")); // EX: (ãõÏíÆÇğ)
        substitutions.add(new InfixSubstitution("öÁ", "öÆ")); // EX: (ãõÌúÒöÆñ¡ ãõÓÊóåúÒöÆñ)
        substitutions.add(new InfixSubstitution("øöÁ", "øöÆ")); // EX: (ãõÌóÒøöÆñ¡ ãõÊóÎóÈøöÆñ )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
