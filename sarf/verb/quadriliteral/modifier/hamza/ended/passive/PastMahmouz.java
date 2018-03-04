package sarf.verb.quadriliteral.modifier.hamza.ended.passive;

import java.util.*;

import sarf.verb.quadriliteral.substitution.*;

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
public class PastMahmouz extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("öÁ","öÆ"));// EX: (ÛõÑúŞöÆó¡ ÊõÏõÑúÈöÆó¡ ÇÍúÈõäúØöÆó)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
