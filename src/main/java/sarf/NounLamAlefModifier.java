package sarf;

import java.util.*;
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
public class NounLamAlefModifier extends SubstitutionsApplier{
	//TODO: appliedPronounsIndexes needs not to be a list of strings.
    protected static final List<String> appliedPronounsIndexes = new ArrayList<>(13);
    static {
        for (int i=0; i<18; i++) {
            appliedPronounsIndexes.add(i+1 +"");
        }
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

    protected List<String> getAppliedPronounsIndecies() {
        return appliedPronounsIndexes;
    }
}
