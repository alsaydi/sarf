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
public class EinMahmouz extends AbstractEinMahmouz {
    List substitutions = new LinkedList();

    public EinMahmouz() {
        substitutions.add(new InfixSubstitution("óÁøõ","óÄøõ"));// EX: (ÊóÔóÄøõã)
        substitutions.add(new InfixSubstitution("íÁóÇ","íÆóÇ"));// EX: (ÅíÆÇÈ¡ ÇÓÊíÆÇÓ)
        substitutions.add(new InfixSubstitution("Áøò","Ãøò"));// EX: (ÊóİóÃøò)
        substitutions.add(new InfixSubstitution("Áøö","Æøö"));// EX: (ÊóİóÆøöíÇä)
        substitutions.add(new InfixSubstitution("úÁóÇ","úÂ"));// EX: (ÅÔÂã¡ ÇÓÊÑÂİ)
        substitutions.add(new InfixSubstitution("öÁ","öÆ"));// EX: (áöÆÇã¡ ÇäĞÆÇÌ¡ ÇÈÊÆÇÓ¡ ÇÑÊÆÇÁ)
        substitutions.add(new InfixSubstitution("Áö","Æö"));// EX: (ÊÑÆíÓ¡ ÇÌÆáÇá)
        substitutions.add(new InfixSubstitution("ÇÁõ","ÇÄõ"));// EX: (ÊÓÇÄá¡ ÊÑÄøİ)
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
