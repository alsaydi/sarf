package sarf.gerund.modifier.trilateral.unaugmented.standard;

import java.util.*;

import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.noun.trilateral.unaugmented.modifier.ConjugationResult;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.*;
import sarf.NounLamAlefModifier;
import sarf.NounSunLamModifier;

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
public class UnaugmentedTrilateralStandardGerundModifier extends AbstractLamMahmouz implements IUnaugmentedTrilateralNounModifier{
    private List substitutions = new LinkedList();
    private String appliedCharactersString = "بتثجحخسشصضطظعغفقكلمنهي";

    private UnaugmentedTrilateralStandardGerundModifier() {
        substitutions.add(new ExpressionInfixSubstitution("C2ْءًا","C2ْئًا"));// EX: (خِطْئًا)
        substitutions.add(new InfixSubstitution("يءًا","يئًا"));// EX: (مَجِيئًا)
    }

    private static UnaugmentedTrilateralStandardGerundModifier instance = new UnaugmentedTrilateralStandardGerundModifier();

    public static UnaugmentedTrilateralStandardGerundModifier getInstance() {
        return instance;
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String formula) {
        ConjugationResult conjResult = new ConjugationResult(kov, root, conjugations, formula);
        if (isApplied(conjResult))
            apply(conjResult.getFinalResult(), root);
        NounLamAlefModifier.getInstance().apply(conjResult);
        NounSunLamModifier.getInstance().apply(conjResult);

        return conjResult;
    }

    //فحص شرط المهموز حسب KOV
    //ومن ثم فحص اذا كان الحرف مناسبا
    public boolean isApplied(ConjugationResult conjugationResult) {
        char c2 = conjugationResult.getRoot().getC2();
        return super.isApplied(conjugationResult) && appliedCharactersString.indexOf(c2) != -1;
    }

}
