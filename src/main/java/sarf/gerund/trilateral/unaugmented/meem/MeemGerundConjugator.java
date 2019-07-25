package sarf.gerund.trilateral.unaugmented.meem;

import sarf.*;
import java.util.*;
import sarf.verb.trilateral.unaugmented.*;
import sarf.gerund.trilateral.unaugmented.meem.pattern.*;
import sarf.noun.*;
import sarf.gerund.trilateral.unaugmented.IUnaugmentedTrilateralGerundConjugator;

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
public class MeemGerundConjugator implements IUnaugmentedTrilateralGerundConjugator {
    private static final MeemGerundConjugator instance = new MeemGerundConjugator();

    private final Map symbolToFormulaNameMap = new HashMap();
    private final Map formulaNameToSymbolMap = new HashMap();

    private MeemGerundConjugator() {
        symbolToFormulaNameMap.put("C","مَفْعَلَة");
        symbolToFormulaNameMap.put("D","مَفْعُلَة");
        symbolToFormulaNameMap.put("E","مَفْعِلَة");

        formulaNameToSymbolMap.put("مَفْعَلَة", "C");
        formulaNameToSymbolMap.put("مَفْعُلَة", "D");
        formulaNameToSymbolMap.put("مَفْعِلَة", "E");
    }


    public static MeemGerundConjugator getInstance() {
        return instance;
    }

    public List createGerundList(UnaugmentedTrilateralRoot root, String formulaName) {
        //check if it is standard
        if (formulaName.equals("مَفْعِل") || formulaName.equals("مَفْعَل")) {
            List standardGerunds = createEmptyList();
            standardGerunds.set(0, new StandardGerundPattern(root, "0"));
            standardGerunds.set(6, new StandardGerundPattern(root, "6"));
            standardGerunds.set(12, new StandardGerundPattern(root, "12"));
            return standardGerunds;
        }
        //non standard
        List gerundDisplayList = createEmptyList();
        String formulaSymbol = (String) formulaNameToSymbolMap.get(formulaName);
        String gerundText = appliedXmlMeemGerundNounFormula.getSymbol1().equals(formulaSymbol)? appliedXmlMeemGerundNounFormula.getGerund1(): appliedXmlMeemGerundNounFormula.getGerund2();

        //لعدم حذف التاء المربوطة من قاعدة المعطيات وحذفها من توليد القانون لأنها موجودة في اللاحقة
        //وحذف الفتحة من قاعدة المعطيات لأنها موجودة في اللاحقة
        gerundText = gerundText.substring(0, gerundText.length()-2);
        gerundText = GenericNounSuffixContainer.getInstance().getPrefix()+ gerundText;
        gerundDisplayList.set(1, gerundText+GenericNounSuffixContainer.getInstance().get(1));
        gerundDisplayList.add(7, gerundText+GenericNounSuffixContainer.getInstance().get(7));
        gerundDisplayList.add(13, gerundText+GenericNounSuffixContainer.getInstance().get(13));

        return gerundDisplayList;
    }

    public List createEmptyList() {
        List result = new ArrayList(18);
        for (int i = 1; i <= 18; i++) {
            result.add("");
        }
        return result;
    }

    private XmlMeemGerundNounFormula appliedXmlMeemGerundNounFormula;
    public List getAppliedFormulaList(UnaugmentedTrilateralRoot root) throws Exception {
        LinkedList result = new LinkedList();

        //add the standard pattern first
        StandardGerundPattern standardGerundPattern = new StandardGerundPattern(root, "0");
        result.add(standardGerundPattern.getPattern());

        XmlMeemGerundNounFormulaTree formulaTree = DatabaseManager.getInstance().getMeemGerundFormulaTree(root.getC1());
        if (formulaTree != null) {

            Iterator iter = formulaTree.getFormulaList().iterator();
            while (iter.hasNext()) {
                XmlMeemGerundNounFormula formula = (XmlMeemGerundNounFormula) iter.next();
                if (formula.getC2() == root.getC2() && formula.getC3() == root.getC3()) {
                    result.add(symbolToFormulaNameMap.get(formula.getSymbol1()));
                    if (formula.getSymbol2() != null && formula.getSymbol2().length() != 0) {
                        result.add(symbolToFormulaNameMap.get(formula.getSymbol2()));
                    }
                    appliedXmlMeemGerundNounFormula = formula;
                    break;
                }
            }
        }
        return result;
    }

}
