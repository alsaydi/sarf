package sarf.verb.trilateral.unaugmented.modifier.hamza.ein;

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
public class ImperativeMahmouz extends AbstractEinMahmouz {
    private List substitutions = new ArrayList();

    public ImperativeMahmouz() {
        substitutions.add(new PrefixSubstitution("Áö","Åö"));// EX: (ÅöÏú [æÃÏ]¡ Åö [æÃì])
        substitutions.add(new PrefixSubstitution("Áõ","Ãõ"));// EX: (ÃäÊã ÃõæÇ)
        substitutions.add(new InfixSubstitution("Áö","Æö"));// EX: (ÇãúÆöí¡ ÇäúÆöãú)
        substitutions.add(new InfixSubstitution("ÇíúÁó","ÇíÆó"));// EX: (ÇíúÆóÓ)
        substitutions.add(new InfixSubstitution("óíúÁó","óíúÆó"));// EX: (íóíúÆóÓ)
        substitutions.add(new InfixSubstitution("íÁó","íÆó"));// EX: (ÇíÆÈ)
        substitutions.add(new InfixSubstitution("úÁó","úÃó"));// EX: (ÇËúÃóÑú¡ ÇäúÃó[ÇáãÊØÑİÉ ÚÑæÖÇğ áåÇ Íßã ÇáãÊæÓØÉ ÃÕÇáÉ])
        substitutions.add(new InfixSubstitution("úÁõ","úÄõ"));// EX: (ÇÖúÄõá¡ ÇãúÄõ[ÇáãÊØÑİÉ ÚÑæÖÇğ áåÇ Íßã ÇáãÊæÓØÉ ÃÕÇáÉ])
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
