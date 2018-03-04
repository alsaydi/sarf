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
public class ImperativeAjwafYaeiListedVocalizer extends AbstractAjwafYaeiListedVocalizer {
    private List substitutions = new LinkedList();

    public ImperativeAjwafYaeiListedVocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úíóC3õ", "C1óÇC3õ"));
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úíóC3ö", "C1óÇC3ö"));
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úíóC3ó", "C1óÇC3ó"));
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úíóC3ú", "C1óC3ú"));
    }

    public List getSubstitutions() {
        return substitutions;
    }


}
