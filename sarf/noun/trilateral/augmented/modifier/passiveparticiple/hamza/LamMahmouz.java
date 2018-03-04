package sarf.noun.trilateral.augmented.modifier.passiveparticiple.hamza;

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
        substitutions.add(new InfixSubstitution("óÁñ", "óÃñ")); // EX: (ãõÌúÒóÃñ¡ ãõÓÊóåúÒóÃñ)
        substitutions.add(new InfixSubstitution("óÁğÇ", "óÃğ")); // EX: (ãõÌúÒóÃğ¡ ãõÓÊóåúÒóÃğ)
        substitutions.add(new InfixSubstitution("ÇÁğÇ", "ÇÁğ")); // EX: (ãõÏÇÁğ)
        substitutions.add(new InfixSubstitution("óÁò", "óÃò")); // EX: (ãõÌúÒóÃò¡ ãõÓÊóåúÒóÃò)
        substitutions.add(new InfixSubstitution("óÁóÇ", "óÂ")); // EX: (ãõÌúÒóÂäö¡ ãõÓÊóåúÒóÂäó)
        substitutions.add(new InfixSubstitution("óÁóí", "óÃóí")); // EX: (ãõÌúÒóÃíúäö¡ ãõÓÊóåúÒóÃóíúäó)
        substitutions.add(new SuffixSubstitution("óÁõ", "óÃõ")); // EX: (ÇáãÌÒóÃõ¡ ÇáãõÓÊóåúÒóÃõ)
        substitutions.add(new SuffixSubstitution("óÁó", "óÃó")); // EX: (ÇáãÌÒóÃó¡ ÇáãõÓÊóåúÒóÃó)
        substitutions.add(new SuffixSubstitution("óÁö", "óÃö")); // EX: (ÇáãÌÒóÃö¡ ÇáãõÓÊóåúÒóÃö)
        substitutions.add(new InfixSubstitution("óÁó", "óÃó")); // EX: (ÇáãÌÒÃóÉ¡ ÇáãÓÊåÒÃÉ)
        substitutions.add(new InfixSubstitution("Áõ", "Äõ")); // EX: (ãõÌúÒóÄõæäó¡ ãõÓÊóåúÒóÄõæäó)
        substitutions.add(new InfixSubstitution("Áö", "Æö")); // EX: (ãõÌúÒóÆöíäó¡ ãõÓÊóåúÒóÆöíäó)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
