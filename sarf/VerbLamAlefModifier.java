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

        substitutions.add(new InfixSubstitution("·Û«","·«"));// EX: (ﬁ«·«)
        substitutions.add(new InfixSubstitution("·¯Û«","·«¯Û"));// EX: («‰˙‘Û·«¯Û)
        substitutions.add(new InfixSubstitution("·Û√","·√"));// EX: („Û·√Û° „Û·√˙ ı)
        substitutions.add(new InfixSubstitution("·«","·«"));// EX: (Õ„·«)

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
