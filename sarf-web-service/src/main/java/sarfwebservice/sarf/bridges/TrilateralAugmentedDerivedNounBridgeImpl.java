package sarfwebservice.sarf.bridges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.WordPresenter;
import sarf.noun.trilateral.augmented.AugmentedTrilateralActiveParticipleConjugator;
import sarf.noun.trilateral.augmented.AugmentedTrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.trilateral.augmented.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.ui.controlpane.NamesSelectionUI;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarfwebservice.models.DerivedNounConjugation;
import sarfwebservice.sarf.factories.SuffixContainerFactory;

import java.util.List;

@Service
public class TrilateralAugmentedDerivedNounBridgeImpl implements TrilateralAugmentedDerivedNounBridge {

    private final ActiveParticipleModifier activeParticipleModifier;
    private final PassiveParticipleModifier passiveParticipleModifier;
    private final SuffixContainerFactory suffixContainerFactory;
    private final AugmentedTrilateralActiveParticipleConjugator augmentedTrilateralActiveParticipleConjugator;
    private final AugmentedTrilateralPassiveParticipleConjugator augmentedTrilateralPassiveParticipleConjugator;

    @Autowired
    public TrilateralAugmentedDerivedNounBridgeImpl(ActiveParticipleModifier activeParticipleModifier
            , PassiveParticipleModifier passiveParticipleModifier
            , SuffixContainerFactory suffixContainerFactory
            , AugmentedTrilateralActiveParticipleConjugator augmentedTrilateralActiveParticipleConjugator
            , AugmentedTrilateralPassiveParticipleConjugator augmentedTrilateralPassiveParticipleConjugator)
    {

        this.activeParticipleModifier = activeParticipleModifier;
        this.passiveParticipleModifier = passiveParticipleModifier;
        this.suffixContainerFactory = suffixContainerFactory;
        this.augmentedTrilateralActiveParticipleConjugator = augmentedTrilateralActiveParticipleConjugator;
        this.augmentedTrilateralPassiveParticipleConjugator = augmentedTrilateralPassiveParticipleConjugator;
    }

    @Override
    public List<DerivedNounConjugation> getActiveParticiple(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo)
    {
        var nounSuffixContainer = suffixContainerFactory.create();
        var derivedNounConjugation = new DerivedNounConjugation();
        derivedNounConjugation.setKey(""); /* there is only one key */

        nounSuffixContainer.selectInDefiniteMode();
        var result = augmentedTrilateralActiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        var conjResult = this.activeParticipleModifier.build(root, kov, formulaNo, result, () -> true);
        var indefinite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setIndefiniteNouns(indefinite);

        nounSuffixContainer.selectAnnexedMode();
        result = augmentedTrilateralActiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        conjResult = this.activeParticipleModifier.build(root, kov, formulaNo, result, () -> true);
        var annexed = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setAnnexedNouns(annexed);

        nounSuffixContainer.selectDefiniteMode();
        result = augmentedTrilateralActiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        conjResult = this.activeParticipleModifier.build(root, kov, formulaNo, result, () -> true);
        var definite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setDefiniteNouns(definite);

        return List.of(derivedNounConjugation);
    }
    @Override
    public List<DerivedNounConjugation> getPassiveParticiple(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo){
        var nounSuffixContainer = suffixContainerFactory.create();
        var derivedNounConjugation = new DerivedNounConjugation();
        derivedNounConjugation.setKey(""); /* there is only one key */

        nounSuffixContainer.selectInDefiniteMode();
        var result = augmentedTrilateralPassiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        var conjResult = this.passiveParticipleModifier.build(root, kov, formulaNo, result, () -> true);
        var indefinite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setIndefiniteNouns(indefinite);

        nounSuffixContainer.selectAnnexedMode();
        result = augmentedTrilateralPassiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        conjResult = this.passiveParticipleModifier.build(root, kov, formulaNo, result, () -> true);
        var annexed = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setAnnexedNouns(annexed);

        nounSuffixContainer.selectDefiniteMode();
        result = augmentedTrilateralPassiveParticipleConjugator.createNounList(root, formulaNo, nounSuffixContainer);
        conjResult = this.passiveParticipleModifier.build(root, kov, formulaNo, result, () -> true);
        var definite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setDefiniteNouns(definite);

        return List.of(derivedNounConjugation);
    }

    @Override
    public List<DerivedNounConjugation> getTimeAndPlaceNouns(AugmentedTrilateralRoot root, KindOfVerb kov, int formulaNo){
        var nounSuffixContainer = suffixContainerFactory.create();
        var derivedNounConjugation = new DerivedNounConjugation();
        derivedNounConjugation.setKey(""); /* there is only one key */

        nounSuffixContainer.selectInDefiniteMode();
        var result = augmentedTrilateralPassiveParticipleConjugator.createTimeAndPlaceNounList(root, formulaNo, nounSuffixContainer);
        var conjResult = this.passiveParticipleModifier.build(root, kov, formulaNo, result, () -> true);
        var indefinite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setIndefiniteNouns(indefinite);

        nounSuffixContainer.selectAnnexedMode();
        result = augmentedTrilateralPassiveParticipleConjugator.createTimeAndPlaceNounList(root, formulaNo, nounSuffixContainer);
        conjResult = this.passiveParticipleModifier.build(root, kov, formulaNo, result, () -> true);
        var annexed = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setAnnexedNouns(annexed);

        nounSuffixContainer.selectDefiniteMode();
        result = augmentedTrilateralPassiveParticipleConjugator.createTimeAndPlaceNounList(root, formulaNo, nounSuffixContainer);
        conjResult = this.passiveParticipleModifier.build(root, kov, formulaNo, result, () -> true);
        var definite = conjResult.getFinalResult().stream().map(WordPresenter::toString).toList();
        derivedNounConjugation.setDefiniteNouns(definite);

        return List.of(derivedNounConjugation);
    }
}
