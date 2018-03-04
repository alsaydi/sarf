package sarf.noun.trilateral.unaugmented.modifier.activeparticiple.vocalizer;

import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ListedVocalizer;
import java.util.List;
import java.util.LinkedList;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.*;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModificationApplier;
import sarf.noun.trilateral.unaugmented.modifier.ConjugationResult;
import java.util.ArrayList;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:›Õ’ «·√ÃÊ› Õ”» ﬁ«∆„…    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class Ajwaf3YaeiListedVocalizer extends AbstractAjwafYaeiListedVocalizer implements IUnaugmentedTrilateralNounModificationApplier {
    private List substitutions = new LinkedList();

    public Ajwaf3YaeiListedVocalizer() {
        substitutions.add(new InfixSubstitution("«Ìˆ", "«∆ˆ")); // EX: (»«∆ˆ⁄Ò)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    protected static List appliedProunounsIndecies = new ArrayList(18);
    static {
        for (int i = 0; i < 18; i++) {
            appliedProunounsIndecies.add(i + 1 + "");
        }
    }

    protected List getAppliedPronounsIndecies() {
        return appliedProunounsIndecies;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return super.isApplied(conjugationResult);
    }

}
