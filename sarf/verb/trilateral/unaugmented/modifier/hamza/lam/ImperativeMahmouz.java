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
public class ImperativeMahmouz extends AbstractLamMahmouz {
    private List substitutions = new ArrayList();

    public ImperativeMahmouz() {
        substitutions.add(new InfixSubstitution("óÁú","óÃú"));// EX: (ÇÈÏóÃú¡ ÏóÃó [ÏÇÁ]¡ ÔóÃú [ÔÇÁ])
        substitutions.add(new InfixSubstitution("óÁó","óÃó"));// EX: (ÇÈÏóÃóÇ)
        substitutions.add(new InfixSubstitution("óÁõ","óÄõ"));// EX: (ÇÈÏóÄõæÇ)
        substitutions.add(new InfixSubstitution("Áö","Æö"));// EX: (ÇÈÏóÆöí¡ ÔóÆöäøó¡ ÇÌÑõÆöí¡ ÈõæÆöí¡ ŞöíÆöí)
        substitutions.add(new InfixSubstitution("õÁõ","õÄõ"));// EX: (ÇÌÑõÄõæÇ)
        substitutions.add(new InfixSubstitution("õÁó","õÄó"));// EX: (ÇÌÑõÄóÇ)
        substitutions.add(new InfixSubstitution("õÁú","õÄú"));// EX: (ÇÌÑõÄú¡ ÈõÄú¡ ÈõÄúäó¡ ÈõÄúäÇäøö)
        substitutions.add(new InfixSubstitution("íÁó","íÆó"));// EX: (ŞöíÆóÇ)
        substitutions.add(new InfixSubstitution("íÁõ","íÆõ"));// EX: (ŞöíÆõæÇ)
        substitutions.add(new InfixSubstitution("ÇÁö","ÇÆö"));// EX: (ÔÇÆöí)
        substitutions.add(new InfixSubstitution("ÇÁõ","ÇÄõ"));// EX: (ÔÇÄõæÇ)
        substitutions.add(new InfixSubstitution("öÁ","öÆ"));// EX: (ŞöÆú¡ ŞöÆúäó¡ ŞöÆõäøó)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
