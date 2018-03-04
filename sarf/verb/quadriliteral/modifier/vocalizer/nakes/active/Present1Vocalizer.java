package sarf.verb.quadriliteral.modifier.vocalizer.nakes.active;

import java.util.*;
import sarf.verb.quadriliteral.substitution.*;
import sarf.verb.quadriliteral.modifier.*;
import sarf.verb.quadriliteral.*;

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
public class Present1Vocalizer extends SubstitutionsApplier implements IQuadrilateralModifier {

    private List substitutions = new LinkedList();

    public Present1Vocalizer() {
        substitutions.add(new SuffixSubstitution("íõ", "í")); // EX: (íõŞóáúÓöí¡ íóÓúáóäúŞöí)
        substitutions.add(new SuffixSubstitution("íú", "")); // EX: (áã íõŞóáúÓö¡ íóÓúáóäúŞö)
        substitutions.add(new InfixSubstitution("íöä", "ä")); // EX: (ÃäÊö ÊõŞóáúÓöäøó¡ ÊõÓúáóäúŞöäøó)
        substitutions.add(new InfixSubstitution("íöí", "í")); // EX: (ÃäÊö ÊõŞóáúÓöíäó¡ ÊõÓúáóŞöíäó)
        substitutions.add(new InfixSubstitution("íúä", "íä")); // EX: (ÃäÊä ÊõŞóáúÓöíäó¡ ÊõÓúáóŞöíäó)
        substitutions.add(new InfixSubstitution("öíõæ", "õæ")); // EX: (ÃäÊã ÊõŞóáúÓõæäó¡ ÊóÓúáóäúŞõæäó)
        substitutions.add(new InfixSubstitution("öíõä", "õä")); // EX: (ÃäÊã ÊõŞóáúÓõäøó¡ ÊóÓúáóäúŞõäøó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC4() != 'í')
            return false;

        switch (conjugationResult.getFormulaNo()) {
        case 0:
        case 2:
            return true;
        }

        return false;

    }
}
