package sarf.noun.trilateral.unaugmented.modifier.activeparticiple.vocalizer;

import sarf.ConjugationResult;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf.AbstractAjwafYaeiListedVocalizer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:فحص الأجوف حسب قائمة    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class Ajwaf3YaeiListedVocalizer extends AbstractAjwafYaeiListedVocalizer {
    private final List<Substitution> substitutions = new LinkedList<>();

    public Ajwaf3YaeiListedVocalizer() {
        substitutions.add(new InfixSubstitution("ايِ", "ائِ")); // EX: (بائِعٌ)
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    private static final List<String> appliedPronounIndexes = new ArrayList<>(18);

    static {
        for (int i = 0; i < 18; i++) {
            appliedPronounIndexes.add(i + 1 + "");
        }
    }

    @Override
    protected List<String> getAppliedPronounsIndexes() {
        return appliedPronounIndexes;
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        return super.isApplied(conjugationResult);
    }
}
