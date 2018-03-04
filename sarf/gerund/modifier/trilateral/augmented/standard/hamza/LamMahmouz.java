package sarf.gerund.modifier.trilateral.augmented.standard.hamza;

import java.util.*;

import sarf.noun.trilateral.augmented.modifier.*;
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
public class LamMahmouz extends AbstractLamMahmouz {
    List substitutions = new LinkedList();

    public LamMahmouz() {
        substitutions.add(new InfixSubstitution("ÇÁğÇ","ÇÁğ"));// EX: (ÇÌÊÒÇÁğ¡ )
        substitutions.add(new InfixSubstitution("óÁóÇ","óÂ"));// EX: (ãõæÇØÂÊ¡ )
        substitutions.add(new InfixSubstitution("öÁó","öÆó"));// EX: (ÊÌÒÆÉ¡ ÊÌÒÆÊÇä¡ )
        substitutions.add(new InfixSubstitution("óÁó","óÃó"));// EX: (ãßÇİÃÉ¡ )
        substitutions.add(new InfixSubstitution("óæøõÁ","óæøõÁ"));// EX: (ÊóÈóæøõÁ¡ )
        substitutions.add(new InfixSubstitution("õÁ","õÄ"));// EX: (ÊÏÇÑÄ¡ )
        substitutions.add(new SuffixSubstitution("öíÁó","öíÁó"));// EX: (ÊÌÒíÁó)
        substitutions.add(new SuffixSubstitution("öíÁõ","öíÁõ"));// EX: (ÊÌÒíÁõ)
        substitutions.add(new SuffixSubstitution("öíÁö","öíÁö"));// EX: (ÊÌÒíÁö)
        substitutions.add(new InfixSubstitution("öíÁñ","öíÁñ"));// EX: (ÊÌÒíÁñ)
        substitutions.add(new InfixSubstitution("öíÁò","öíÁò"));// EX: (ÊÌÒíÁò)
        substitutions.add(new InfixSubstitution("öíÁ","öíÆ"));// EX: (ÊÌÒíÆğÇ¡ ÊÌÒíÆÇ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
