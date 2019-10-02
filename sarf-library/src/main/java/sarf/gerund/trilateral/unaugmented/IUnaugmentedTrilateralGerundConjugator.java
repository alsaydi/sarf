package sarf.gerund.trilateral.unaugmented;

import java.util.List;

import sarf.Word;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

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
public interface IUnaugmentedTrilateralGerundConjugator {
    List<? extends Word> createGerundList(UnaugmentedTrilateralRoot root, String formulaName);
    List<String> getAppliedFormulaList(UnaugmentedTrilateralRoot root) throws Exception;
}
