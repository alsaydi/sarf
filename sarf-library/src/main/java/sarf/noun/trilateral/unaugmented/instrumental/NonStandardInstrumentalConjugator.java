package sarf.noun.trilateral.unaugmented.instrumental;

import com.google.inject.Inject;
import sarf.noun.*;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula1;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula2;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula3;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula4;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula5;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula6;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula7;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula8;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula9;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula10;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula11;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula12;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula13;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula14;
import sarf.noun.trilateral.unaugmented.instrumental.nonstandard.NounFormula15;
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
public class NonStandardInstrumentalConjugator implements IUnaugmentedTrilateralNounConjugator {
    private final Map<String, Class> formulaClassNamesMap = new HashMap<>();
    //map <symbol,formulaName>
    private final Map<String, String> formulaSymbolsNamesMap = new HashMap<>();
    private final DatabaseManager databaseManager;
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public NonStandardInstrumentalConjugator(DatabaseManager databaseManager, GenericNounSuffixContainer genericNounSuffixContainer) {
        this.databaseManager = databaseManager;
        this.genericNounSuffixContainer = genericNounSuffixContainer;
        buildFormulaClassNamesMap(new NounFormula1());
        buildFormulaClassNamesMap(new NounFormula2());
        buildFormulaClassNamesMap(new NounFormula3());
        buildFormulaClassNamesMap(new NounFormula4());
        buildFormulaClassNamesMap(new NounFormula5());
        buildFormulaClassNamesMap(new NounFormula6());
        buildFormulaClassNamesMap(new NounFormula7());
        buildFormulaClassNamesMap(new NounFormula8());
        buildFormulaClassNamesMap(new NounFormula9());
        buildFormulaClassNamesMap(new NounFormula10());
        buildFormulaClassNamesMap(new NounFormula11());
        buildFormulaClassNamesMap(new NounFormula12());
        buildFormulaClassNamesMap(new NounFormula13());
        buildFormulaClassNamesMap(new NounFormula14());
        buildFormulaClassNamesMap(new NounFormula15());
    }

    private void buildFormulaClassNamesMap(NonStandardInstrumentalNounFormula instance){
        formulaClassNamesMap.put(instance.getFormulaName(), instance.getClass());
        formulaSymbolsNamesMap.put(instance.getSymbol(), instance.getFormulaName());
    }

    private NounFormula createNoun(UnaugmentedTrilateralRoot root, int suffixNo, String formulaName, GenericNounSuffixContainer genericNounSuffixContainer) {
        Object[] parameters = {root, suffixNo + "", genericNounSuffixContainer};

        try {
            Class<NounFormula> formulaClass = formulaClassNamesMap.get(formulaName);
            return formulaClass.getConstructor(root.getClass(), "".getClass(), genericNounSuffixContainer.getClass()).newInstance(parameters);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * @deprecated Use the version of this method that takes an instance of GenericNounSuffixContainer
     * Having a single version of GenericNounSuffixContainer will cause an issue in multi-threaded environments
     */
    public List<NounFormula> createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        return this.createNounList(root, formulaName, this.genericNounSuffixContainer);
    }
    public List<NounFormula> createNounList(UnaugmentedTrilateralRoot root, String formulaName, GenericNounSuffixContainer genericNounSuffixContainer) {
        List<NounFormula> result = new LinkedList<>();
        for (int i = 0; i < 18; i++) {
            NounFormula noun = createNoun(root, i, formulaName, genericNounSuffixContainer);
            result.add(noun);
        }
        return result;
    }

    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        //فقط للفعل المتعدي
        if (!root.getTransitive().equals("م") && !root.getTransitive().equals("ك")) {
            return null;
        }

        XmlNonStandardInstrumentalNounFormulaTree formulaTree = databaseManager.getInstrumentalNounFormulaTree(root.getC1());
        if (formulaTree == null) {
            return null;
        }

        List<String> result = new LinkedList<>();

        for (XmlNonStandardInstrumentalNounFormula formula : formulaTree.getFormulaList()) {
            if (formula.getC2() == root.getC2() && formula.getC3() == root.getC3()) {
                if (formula.getForm1() != null && !formula.getForm1().equals("")) {
                    //add the formula pattern instead of the symbol (form1)
                    result.add(formulaSymbolsNamesMap.get(formula.getForm1()));
                }

                //may the verb has two forms of instrumentals
                if (formula.getForm2() != null && !formula.getForm2().equals("")) {
                    //add the formula pattern instead of the symbol (form2)
                    result.add(formulaSymbolsNamesMap.get(formula.getForm2()));
                }
            }
        }
        return result;
    }
}
