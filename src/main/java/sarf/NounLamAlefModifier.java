package sarf;

import java.util.*;
import java.util.stream.IntStream;

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
public final class NounLamAlefModifier extends SubstitutionsApplier {
	//TODO: appliedPronounsIndexes needs not to be a list of strings.
    static final List<String> appliedPronounsIndexes = new ArrayList<>(SystemConstants.PRONOUN_RANGE_END);
    static {
        IntStream.range(0, SystemConstants.NOUN_POSSIBLE_STATES)
                .mapToObj(i -> i + 1 + "").forEachOrdered(appliedPronounsIndexes::add);
    }

    private final List<Substitution> substitutions = new LinkedList<>();

    private NounLamAlefModifier() {
        substitutions.add(new InfixSubstitution("لَا","لا"));// EX: (قالا)
        substitutions.add(new InfixSubstitution("لَّا","لاَّ"));// EX: (انْشَلاَّ)
        substitutions.add(new InfixSubstitution("لَأ","لأ"));// EX: (مَلأَ، مَلأْتُ)
        substitutions.add(new InfixSubstitution("لًا","لاً"));// EX: (حملاً)
    }

    private static final NounLamAlefModifier instance = new NounLamAlefModifier();

    public static NounLamAlefModifier getInstance() {
        return instance;
    }

    public void apply(sarf.verb.trilateral.unaugmented.ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), null);
        //قد يوجد لام ألف أخرى تتطابق مع قانون أخر
        apply(conjResult.getFinalResult(), null);
    }

    public void apply(sarf.verb.trilateral.augmented.ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), null);
        //قد يوجد لام ألف أخرى تتطابق مع قانون أخر
        apply(conjResult.getFinalResult(), null);
    }


    public void apply(sarf.verb.quadriliteral.ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), null);
        //قد يوجد لام ألف أخرى تتطابق مع قانون أخر
        apply(conjResult.getFinalResult(), null);
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
