package sarf.noun.trilateral.unaugmented.assimilate;

import com.google.inject.Inject;
import sarf.noun.*;
import sarf.noun.trilateral.unaugmented.assimilate.nonstandard.*;
import sarf.verb.trilateral.unaugmented.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import sarf.*;

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
public class AssimilateAdjectiveConjugator implements IUnaugmentedTrilateralNounConjugator {
    private final Map<String, String> formulaNamesMap = new HashMap<>();
    private final Map<String, String> formulaIDsMap = new HashMap<>();
    private final DatabaseManager databaseManager;

    @Inject
    public AssimilateAdjectiveConjugator(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        loadFormulaName("A", new NounFormulaA());
        loadFormulaName("B", new NounFormulaB());
        loadFormulaName("C", new NounFormulaC());
        loadFormulaName("D", new NounFormulaD());
        //تم تفريق هذه الصيغة إلى صيغتين
        loadFormulaName("E1", new NounFormulaE1());
        loadFormulaName("E2", new NounFormulaE2());
    }

    private void loadFormulaName(String formulaId, NounFormula instance) {
        formulaNamesMap.put(formulaId, instance.getFormulaName());
        formulaIDsMap.put(instance.getFormulaName(), formulaId);
    }


    public NounFormula createNoun(UnaugmentedTrilateralRoot root, int suffixNo, String formulaID) {
        Object[] parameters = {root, suffixNo + ""};
        try {
            /*
                لكي تكون هنا: جرب بالفعل صب المضعف.
             */
            var formulaClassName = getClass().getPackage().getName() + ".nonstandard.NounFormula" + formulaID;
            Class formulaClass = Class.forName(formulaClassName);
            return (NounFormula) formulaClass.getConstructor(root.getClass(), formulaID.getClass())
                    .newInstance(parameters);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<NounFormula> createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        String formulaID = formulaIDsMap.get(formulaName);
        return IntStream.range(0, SystemConstants.NOUN_POSSIBLE_STATES).mapToObj(i -> createNoun(root, i, formulaID)).collect(Collectors.toList());
    }

    private void addAdjectiveResult(List<String> result, String adj) {
        if (adj == null || adj.length() == 0) return;
        if (adj.equals("E")) {
            result.add(formulaNamesMap.get("E1"));
            result.add(formulaNamesMap.get("E2"));
        } else
            result.add(formulaNamesMap.get(adj));
    }

    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        AssimilateAdjectiveFormulaTree formulaTree = databaseManager.getAssimilateAdjectiveFormulaTree(root.getC1());
        if (formulaTree == null) {
            return null;
        }

        var result = new ArrayList<String>();

        for (AssimilateAdjectiveFormula formula : formulaTree.getFormulaList()) {
            if (formula.getConjugation().equals(root.getConjugation()) && formula.getC2() == root.getC2() && formula.getC3() == root.getC3()) {
                addAdjectiveResult(result, formula.getAdj1());
                addAdjectiveResult(result, formula.getAdj2());
                addAdjectiveResult(result, formula.getAdj3());
            }
        }
        return result;
    }
}