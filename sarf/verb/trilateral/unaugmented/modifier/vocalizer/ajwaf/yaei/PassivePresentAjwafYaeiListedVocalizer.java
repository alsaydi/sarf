package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.yaei;

import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ListedVocalizer;
import java.util.List;
import java.util.LinkedList;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.AbstractAjwafYaeiListedVocalizer;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:İÍÕ ÇáÃÌæİ ÍÓÈ ŞÇÆãÉ    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PassivePresentAjwafYaeiListedVocalizer extends AbstractAjwafYaeiListedVocalizer {
    private List substitutions = new LinkedList();

    public PassivePresentAjwafYaeiListedVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("úíóC3õ","óÇC3õ"));// EX: (íõÈÇÚ¡ íõÈÇÊ¡ áä ÊõÈÇÊæÇ)
        substitutions.add(new ExpressionInfixSubstitution("úíóC3ö","óÇC3ö"));// EX: (ÊõÈÇÚöíäó¡ ÊõÈÇÊíä¡ áä ÊõÈÇÊí )
        substitutions.add(new ExpressionInfixSubstitution("úíóC3ó","óÇC3ó"));// EX: (ÊõÈÇÚÇä¡ ÊõÈÇÊÇä¡ áä íõÈÇÊó¡ íõÈÇÊóäøó)
        substitutions.add(new ExpressionInfixSubstitution("úíóC3ú","óC3ú"));// EX: (íõÈóÚúäó¡ íõÈóÊúäó¡ áã ÊõÈóÊú)
        substitutions.add(new ExpressionInfixSubstitution("úíóC3ø","óC3ø"));// EX: (ÃäÊä Êõáóäøó¡ åä íõáóäøó)
    }


    public List getSubstitutions() {
        return substitutions;
    }


}
