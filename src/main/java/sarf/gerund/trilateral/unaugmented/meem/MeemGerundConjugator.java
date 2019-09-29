package sarf.gerund.trilateral.unaugmented.meem;

import com.google.inject.Inject;
import sarf.DatabaseManager;
import sarf.SystemConstants;
import sarf.gerund.trilateral.unaugmented.IUnaugmentedTrilateralGerundConjugator;
import sarf.gerund.trilateral.unaugmented.meem.pattern.NonStandardGerundPattern;
import sarf.gerund.trilateral.unaugmented.meem.pattern.StandardGerundPattern;
import sarf.kov.KovRulesManager;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private final Map<String, String> symbolToFormulaNameMap = new HashMap<>();
    private final Map<String, String> formulaNameToSymbolMap = new HashMap<>();
    private final KovRulesManager kovRulesManager;
    private final DatabaseManager databaseManager;
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public MeemGerundConjugator(KovRulesManager kovRulesManager, DatabaseManager databaseManager, GenericNounSuffixContainer genericNounSuffixContainer) {
        this.kovRulesManager = kovRulesManager;
        this.databaseManager = databaseManager;
        this.genericNounSuffixContainer = genericNounSuffixContainer;

        symbolToFormulaNameMap.put("C", "مَفْعَلَة");
        symbolToFormulaNameMap.put("D", "مَفْعُلَة");
        symbolToFormulaNameMap.put("E", "مَفْعِلَة");

        formulaNameToSymbolMap.put("مَفْعَلَة", "C");
        formulaNameToSymbolMap.put("مَفْعُلَة", "D");
        formulaNameToSymbolMap.put("مَفْعِلَة", "E");
    }

    public List<? extends MeemGerund> createGerundList(UnaugmentedTrilateralRoot root, String formulaName) {
        //check if it is standard
        if (formulaName.equals("مَفْعِل") || formulaName.equals("مَفْعَل")) {
            List<StandardGerundPattern> standardGerunds = createEmptyList();
            var kov = kovRulesManager.getTrilateralKov(root.getC1(), root.getC2(), root.getC3());
            standardGerunds.set(0, new StandardGerundPattern(root, "0", kov, genericNounSuffixContainer));
            standardGerunds.set(6, new StandardGerundPattern(root, "6", kov, genericNounSuffixContainer));
            standardGerunds.set(12, new StandardGerundPattern(root, "12", kov, genericNounSuffixContainer));
            return standardGerunds;
        }
        //FIXME: this function relies on this.getAppliedFormulaList being called. Otherwise, appliedXmlMeemGerundNounFormula will be null.

        //non standard
        var gerundDisplayList = createNonStandardEmptyList();
        String formulaSymbol = formulaNameToSymbolMap.get(formulaName);
        String gerundText = appliedXmlMeemGerundNounFormula.getSymbol1().equals(formulaSymbol) ? appliedXmlMeemGerundNounFormula.getGerund1() : appliedXmlMeemGerundNounFormula.getGerund2();

        //لعدم حذف التاء المربوطة من قاعدة المعطيات وحذفها من توليد القانون لأنها موجودة في اللاحقة
        //وحذف الفتحة من قاعدة المعطيات لأنها موجودة في اللاحقة
        gerundText = gerundText.substring(0, gerundText.length() - 2);
        gerundText = genericNounSuffixContainer.getPrefix() + gerundText;
        gerundDisplayList.set(1, new NonStandardGerundPattern(gerundText + genericNounSuffixContainer.get(1)));
        gerundDisplayList.set(7, new NonStandardGerundPattern(gerundText + genericNounSuffixContainer.get(7)));
        gerundDisplayList.set(13, new NonStandardGerundPattern(gerundText + genericNounSuffixContainer.get(13)));

        return gerundDisplayList;
    }

    public List<StandardGerundPattern> createEmptyList() {
        List<StandardGerundPattern> result = new ArrayList<>();
        for (int i = 1; i <= SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            result.add(StandardGerundPattern.Empty);
        }
        return result;
    }

    private static List<NonStandardGerundPattern> createNonStandardEmptyList() {
        List<NonStandardGerundPattern> result = new ArrayList<>();
        for (int i = 1; i <= SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            result.add(new NonStandardGerundPattern(""));
        }
        return result;
    }

    private XmlMeemGerundNounFormula appliedXmlMeemGerundNounFormula;

    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) throws Exception {
        var result = new ArrayList<String>();
        var kov = kovRulesManager.getTrilateralKov(root.getC1(), root.getC2(), root.getC3());

        //add the standard pattern first
        StandardGerundPattern standardGerundPattern = new StandardGerundPattern(root, "0", kov, genericNounSuffixContainer);
        result.add(standardGerundPattern.getPattern());

        XmlMeemGerundNounFormulaTree formulaTree = databaseManager.getMeemGerundFormulaTree(root.getC1());
        if (formulaTree != null) {

            for (Object o : formulaTree.getFormulaList()) {
                XmlMeemGerundNounFormula formula = (XmlMeemGerundNounFormula) o;
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
