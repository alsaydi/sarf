package sarf.noun.trilateral.unaugmented.timeandplace;

import com.google.inject.Inject;
import sarf.noun.*;
import sarf.noun.trilateral.unaugmented.timeandplace.nonstandard.NounFormula1;
import sarf.noun.trilateral.unaugmented.timeandplace.nonstandard.NounFormula2;
import sarf.noun.trilateral.unaugmented.timeandplace.nonstandard.NounFormula3;
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
public class TimeAndPlaceConjugator implements IUnaugmentedTrilateralNounConjugator{
    private final Map<String, Class> formulaClassNamesMap = new HashMap<>();

    //map <symbol,formulaName>
    private final Map<String, String> formulaSymbolsNamesMap = new HashMap<>();
    private final DatabaseManager databaseManager;
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public TimeAndPlaceConjugator(DatabaseManager databaseManager, GenericNounSuffixContainer genericNounSuffixContainer) {
        this.databaseManager = databaseManager;
        this.genericNounSuffixContainer = genericNounSuffixContainer;
        addNonStandardNounFormulaToMap(NounFormula1.class, new NounFormula1());
        addNonStandardNounFormulaToMap(NounFormula2.class, new NounFormula2());
        addNonStandardNounFormulaToMap(NounFormula3.class, new NounFormula3());
    }

    private void addNonStandardNounFormulaToMap(Class formulaClass, NonStandardTimeAndPlaceNounFormula instance){
        formulaClassNamesMap.put(instance.getFormulaName(), formulaClass);
        formulaSymbolsNamesMap.put(instance.getSymbol(), instance.getFormulaName());
    }

    public NounFormula createNoun(UnaugmentedTrilateralRoot root, int suffixNo, String formulaName) {
        Object [] parameters = {root, suffixNo+"", genericNounSuffixContainer};

        try {
            var formulaClass = formulaClassNamesMap.get(formulaName);

            var constructor = formulaClass.getConstructor(root.getClass(), "".getClass(), genericNounSuffixContainer.getClass());
            return (NounFormula) constructor.newInstance(parameters);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<NounFormula> createNounList(UnaugmentedTrilateralRoot root, String formulaName) {
        List<NounFormula> result = new ArrayList<>();
        for (int i = 0; i < SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            NounFormula noun = createNoun(root, i, formulaName);
            result.add(noun);
        }

        return result;
    }

    /**
     * إعادة الصيغ الممكنة للجذر
     * @param root UnaugmentedTrilateralRoot
     * @return List
     */
    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        XmlTimeAndPlaceNounFormulaTree formulaTree =  databaseManager.getTimeAndPlaceNounFormulaTree(root.getC1());
        if (formulaTree == null)
            return null;

        List<String> result = new ArrayList<>();

        for (Object o : formulaTree.getFormulaList()) {
            XmlTimeAndPlaceNounFormula formula = (XmlTimeAndPlaceNounFormula) o;
            if (formula.getNoc().equals(root.getConjugation()) && formula.getC2() == root.getC2() && formula.getC3() == root.getC3()) {
                if (formula.getForm1() != null && !formula.getForm1().equals(""))
                    //add the formula pattern instead of the symbol (form1)
                    result.add(formulaSymbolsNamesMap.get(formula.getForm1()));

                //may the verb has two forms of instrumentals
                if (formula.getForm2() != null && !formula.getForm2().equals(""))
                    //add the formula pattern instead of the symbol (form2)
                    result.add(formulaSymbolsNamesMap.get(formula.getForm2()));
            }
        }
        return result;
    }
}
