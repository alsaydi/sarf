package sarf.noun.trilateral.unaugmented.assimilate;

import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.*;
import java.util.*;
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
public class AssimilateAdjectiveConjugator implements IUnaugmentedTrilateralNounConjugator{

    private static AssimilateAdjectiveConjugator instance = new AssimilateAdjectiveConjugator();

    public static AssimilateAdjectiveConjugator getInstance() {
        return instance;
    }

    private Map formulaNamesMap = new HashMap();
    private Map formulaIDsMap = new HashMap();

    private AssimilateAdjectiveConjugator() {
        loadFormulaName("A");
        loadFormulaName("B");
        loadFormulaName("C");
        loadFormulaName("D");
        // „  ›—Ìﬁ Â–Â «·’Ì€… ≈·Ï ’Ì€ Ì‰
        loadFormulaName("E1");
        loadFormulaName("E2");
    }

    private void loadFormulaName(String formulaID) {
        String formulaClassName = getClass().getPackage().getName() + ".nonstandard.NounFormula" + formulaID;
        try {
            Class formulaClass = Class.forName(formulaClassName);

            String formulaName = ((NounFormula) formulaClass.newInstance()).getFormulaName();

            formulaNamesMap.put(formulaID, formulaName);
            formulaIDsMap.put(formulaName, formulaID);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public NounFormula createNoun(UnaugmentedTrilateralRoot root, int suffixNo, String formulaID) {
        Object[] parameters = {root, suffixNo + ""};

        try {
            String formulaClassName = getClass().getPackage().getName() + ".nonstandard.NounFormula" + formulaID;
            Class formulaClass = Class.forName(formulaClassName);
            NounFormula noun = (NounFormula) formulaClass.getConstructors()[1].newInstance(parameters);
            return noun;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        String formulaID = (String) formulaIDsMap.get(formulaName);
        List result = new LinkedList();
        for (int i = 0; i < 18; i++) {
            NounFormula noun = createNoun(root, i, formulaID);
            result.add(noun);
        }

        return result;

    }

    private void addAdjectiveResult(List result, String adj) {
        if (adj == null || adj.length() == 0) return;
        if (adj.equals("E")) {
            result.add(formulaNamesMap.get("E1"));
            result.add(formulaNamesMap.get("E2"));
        }
        else
            result.add(formulaNamesMap.get(adj));
    }

    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        AssimilateAdjectiveFormulaTree formulaTree = DatabaseManager.getInstance().getAssimilateAdjectiveFormulaTree(root.getC1());
        if (formulaTree == null) {
            return null;
        }

        List result = new LinkedList();

        Iterator iter = formulaTree.getFormulaList().iterator();
        while (iter.hasNext()) {
            AssimilateAdjectiveFormula formula = (AssimilateAdjectiveFormula) iter.next();
            if (formula.getConjugation().equals(root.getConjugation()) && formula.getC2() == root.getC2() && formula.getC3() == root.getC3()) {
                addAdjectiveResult(result,  formula.getAdj1());
                addAdjectiveResult(result,  formula.getAdj2());
                addAdjectiveResult(result,  formula.getAdj3());
            }
        }

        return result;
    }
}
