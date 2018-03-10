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
public class VerbLamAlefModifier extends SubstitutionsApplier{
    List substitutions = new LinkedList();

    private VerbLamAlefModifier() {

        substitutions.add(new InfixSubstitution("لَا","لا"));// EX: (قالا)
        substitutions.add(new InfixSubstitution("لَّا","لاَّ"));// EX: (انْشَلاَّ)
        substitutions.add(new InfixSubstitution("لَأ","لأ"));// EX: (مَلأَ، مَلأْتُ)
        substitutions.add(new InfixSubstitution("لًا","لاً"));// EX: (حملاً)

    }

    private static VerbLamAlefModifier instance = new VerbLamAlefModifier();

    public static VerbLamAlefModifier getInstance() {
        return instance;
    }

    public void apply(sarf.verb.trilateral.unaugmented.ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), null);
    }

    public void apply(sarf.verb.trilateral.augmented.ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), null);
    }

    public void apply(sarf.verb.quadriliteral.ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), null);
    }

    public List getSubstitutions() {
        return substitutions;
    }

}
