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
public class EinMahmouz extends AbstractEinMahmouz {
    List substitutions = new LinkedList();

    public EinMahmouz() {

        substitutions.add(new InfixSubstitution("ÇÁò","ÇÁò"));// EX: (ãÊÑÇÁò¡ ãÊÔÇÁò)
        substitutions.add(new InfixSubstitution("úÁò","úÁò"));// EX: (ãõäúÁò¡ ãóãúÁò)
        substitutions.add(new InfixSubstitution("óÁò","óÃò"));// EX: (ãõäúİóÃò)
        substitutions.add(new InfixSubstitution("óÁøò","óÃøò"));// EX: (ãõÑóÃøò¡ ãõÊóÑóÃøò)
        substitutions.add(new InfixSubstitution("Áõ","Äõ"));// EX: (ãõäúÄõæä¡ ãõãúÄõæä¡ ãõÑÇÄõæä)
        substitutions.add(new InfixSubstitution("Áö","Æö"));// EX: (ãõÔúÆöãñ¡ ãõÈúÊóÆöÓñ¡ ãõÊóÓÇÆöáñ¡ ãõÓúÊóÑÆöİñ)
        substitutions.add(new InfixSubstitution("Áøö","Æøö"));// EX: (ãõÑóÆøöÓñ¡ ãõÊóÑóÆøöİñ)
        substitutions.add(new InfixSubstitution("Áøõ","Äøõ"));// EX: (ãõÑóÄøõæä)
        substitutions.add(new InfixSubstitution("úÁó","úÃó"));// EX: (ãõÌúÃóáøñ)

    }


    public List getSubstitutions() {
        return substitutions;
    }
}
