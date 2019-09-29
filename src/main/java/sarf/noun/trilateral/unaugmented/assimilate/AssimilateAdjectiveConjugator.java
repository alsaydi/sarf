package sarf.noun.trilateral.unaugmented.assimilate;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
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
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public AssimilateAdjectiveConjugator(DatabaseManager databaseManager, GenericNounSuffixContainer genericNounSuffixContainer) {
        this.databaseManager = databaseManager;
        this.genericNounSuffixContainer = genericNounSuffixContainer;
        loadFormulaName("A", new NounFormulaA(new UnaugmentedTrilateralRoot(), "0", genericNounSuffixContainer));
        loadFormulaName("B", new NounFormulaB(new UnaugmentedTrilateralRoot(), "0", genericNounSuffixContainer));
        loadFormulaName("C", new NounFormulaC(new UnaugmentedTrilateralRoot(), "0", genericNounSuffixContainer));
        loadFormulaName("D", new NounFormulaD(new UnaugmentedTrilateralRoot(), "0", genericNounSuffixContainer));
        //تم تفريق هذه الصيغة إلى صيغتين
        loadFormulaName("E1", new NounFormulaE1(new UnaugmentedTrilateralRoot(), "0", genericNounSuffixContainer));
        loadFormulaName("E2", new NounFormulaE2(new UnaugmentedTrilateralRoot(), "0", genericNounSuffixContainer));
    }

    private void loadFormulaName(String formulaId, NounFormula instance) {
        formulaNamesMap.put(formulaId, instance.getFormulaName());
        formulaIDsMap.put(instance.getFormulaName(), formulaId);
    }

    private NounFormula createNoun(UnaugmentedTrilateralRoot root, int suffixNo, String formulaID) {
            /*
                لكي تكون هنا: جرب بالفعل صب المضعف.
             */
        switch (formulaID) {
            case "A":
                return new NounFormulaA(root, suffixNo + "", genericNounSuffixContainer);
            case "B":
                return new NounFormulaB(root, suffixNo + "", genericNounSuffixContainer);
            case "C":
                return new NounFormulaC(root, suffixNo + "", genericNounSuffixContainer);
            case "D":
                return new NounFormulaD(root, suffixNo + "", genericNounSuffixContainer);
            case "E1":
                return new NounFormulaE1(root, suffixNo + "", AssimilateFormulaE1SuffixContainer.getInstance());
            case "E2":
                return new NounFormulaE2(root, suffixNo + "", genericNounSuffixContainer);
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

    @NotNull
    public List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) {
        var result = new ArrayList<String>();

        AssimilateAdjectiveFormulaTree formulaTree = databaseManager.getAssimilateAdjectiveFormulaTree(root.getC1());
        if (formulaTree == null) {
            return result;
        }

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