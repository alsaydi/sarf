package sarfwebservice.sarf.bridges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sarf.*;
import sarf.gerund.modifier.trilateral.unaugmented.meem.TrilateralUnaugmentedMeemModifier;
import sarf.gerund.modifier.trilateral.unaugmented.nomen.TrilateralUnaugmentedNomenModifier;
import sarf.gerund.modifier.trilateral.unaugmented.quality.TrilateralUnaugmentedQualityModifier;
import sarf.gerund.modifier.trilateral.unaugmented.standard.UnaugmentedTrilateralStandardGerundModifier;
import sarf.gerund.trilateral.unaugmented.QualityGerundConjugator;
import sarf.gerund.trilateral.unaugmented.TrilateralUnaugmentedGerundConjugator;
import sarf.gerund.trilateral.unaugmented.TrilateralUnaugmentedNomenGerundConjugator;
import sarf.gerund.trilateral.unaugmented.meem.MeemGerundConjugator;
import sarf.noun.TrilateralUnaugmentedNouns;
import sarf.noun.trilateral.unaugmented.UnaugmentedTrilateralActiveParticipleConjugator;
import sarf.noun.trilateral.unaugmented.UnaugmentedTrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.unaugmented.assimilate.AssimilateAdjectiveConjugator;
import sarf.noun.trilateral.unaugmented.elative.ElativeNounConjugator;
import sarf.noun.trilateral.unaugmented.exaggeration.NonStandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.exaggeration.StandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.instrumental.StandardInstrumentalConjugator;
import sarf.noun.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.trilateral.unaugmented.modifier.assimilate.AssimilateModifier;
import sarf.noun.trilateral.unaugmented.modifier.elative.ElativeModifier;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.ExaggerationModifier;
import sarf.noun.trilateral.unaugmented.modifier.instrumental.InstrumentalModifier;
import sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.noun.trilateral.unaugmented.modifier.timeandplace.TimeAndPlaceModifier;
import sarf.noun.trilateral.unaugmented.timeandplace.TimeAndPlaceConjugator;
import sarf.verb.trilateral.unaugmented.UnaugmentedImperativeConjugator;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.active.ActivePastConjugator;
import sarf.verb.trilateral.unaugmented.active.ActivePastVerb;
import sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.passive.PassivePastConjugator;
import sarf.verb.trilateral.unaugmented.passive.PassivePresentConjugator;

import java.util.List;

@Service
public class TrilateralUnaugmentedBridgeImpl implements TrilateralUnaugmentedBridge {

    private final ActivePastConjugator triActivePastConjugator;
    private final PassivePastConjugator triPassivePastConjugator;
    private final UnaugmentedTrilateralActiveParticipleConjugator unaugmentedTrilateralActiveParticipleConjugator;
    private final ActiveParticipleModifier activeParticipleModifier;
    private final UnaugmentedTrilateralPassiveParticipleConjugator unaugmentedTrilateralPassiveParticipleConjugator;
    private final PassiveParticipleModifier trilateralUnaugmentedPassiveParticipleModifier;
    private final TrilateralUnaugmentedNouns trilateralUnaugmentedNouns;
    private final StandardExaggerationConjugator standardExaggerationConjugator;
    private final ExaggerationModifier exaggerationModifier;
    private final NonStandardExaggerationConjugator nonStandardExaggerationConjugator;
    private final TimeAndPlaceConjugator timeAndPlaceConjugator;
    private final TimeAndPlaceModifier timeAndPlaceModifier;
    private final StandardInstrumentalConjugator standardInstrumentalConjugator;
    private final InstrumentalModifier instrumentalModifier;
    private final AssimilateAdjectiveConjugator assimilateConjugator;
    private final AssimilateModifier assimilateModifier;
    private final ElativeNounConjugator elativeConjugator;
    private final ElativeModifier elativeModifier;
    private final TrilateralUnaugmentedGerundConjugator trilateralUnaugmentedGerundConjugator;
    private final UnaugmentedTrilateralStandardGerundModifier unaugmentedTrilateralStandardGerundModifier;
    private final MeemGerundConjugator meemGerundConjugator;
    private final TrilateralUnaugmentedMeemModifier trilateralUnaugmentedMeemModifier;
    private final TrilateralUnaugmentedNomenGerundConjugator trilateralUnaugmentedNomenGerundConjugator;
    private final TrilateralUnaugmentedNomenModifier trilateralUnaugmentedNomenModifier;
    private final QualityGerundConjugator qualityGerundConjugator;
    private final TrilateralUnaugmentedQualityModifier qualityGerundModifier;
    private final UnaugmentedTrilateralModifier unaugmentedTrilateralModifier;
    private final ActivePresentConjugator triUnaugmentedActivePresentConjugator;
    private final UnaugmentedImperativeConjugator unaugmentedImperativeConjugator;
    private final PassivePresentConjugator passivePresentConjugator;

    @Autowired
    public TrilateralUnaugmentedBridgeImpl(ActivePastConjugator triActivePastConjugator
            , PassivePastConjugator triPassivePastConjugator
            , UnaugmentedTrilateralActiveParticipleConjugator unaugmentedTrilateralActiveParticipleConjugator
            , ActiveParticipleModifier activeParticipleModifier
            , UnaugmentedTrilateralPassiveParticipleConjugator unaugmentedTrilateralPassiveParticipleConjugator
            , PassiveParticipleModifier trilateralUnaugmentedPassiveParticipleModifier
            , TrilateralUnaugmentedNouns trilateralUnaugmentedNouns
            , StandardExaggerationConjugator standardExaggerationConjugator
            , ExaggerationModifier exaggerationModifier
            , NonStandardExaggerationConjugator nonStandardExaggerationConjugator
            , TimeAndPlaceConjugator timeAndPlaceConjugator
            , TimeAndPlaceModifier timeAndPlaceModifier
            , StandardInstrumentalConjugator standardInstrumentalConjugator
            , InstrumentalModifier instrumentalModifier
            , AssimilateAdjectiveConjugator assimilateConjugator
            , AssimilateModifier assimilateModifier
            , ElativeNounConjugator elativeConjugator
            , ElativeModifier elativeModifier
            , TrilateralUnaugmentedGerundConjugator trilateralUnaugmentedGerundConjugator
            , UnaugmentedTrilateralStandardGerundModifier unaugmentedTrilateralStandardGerundModifier
            , MeemGerundConjugator meemGerundConjugator
            , TrilateralUnaugmentedMeemModifier trilateralUnaugmentedMeemModifier
            , TrilateralUnaugmentedNomenGerundConjugator trilateralUnaugmentedNomenGerundConjugator
            , TrilateralUnaugmentedNomenModifier trilateralUnaugmentedNomenModifier
            , QualityGerundConjugator qualityGerundConjugator
            , TrilateralUnaugmentedQualityModifier qualityGerundModifier
            , UnaugmentedTrilateralModifier unaugmentedTrilateralModifier
            , ActivePresentConjugator triUnaugmentedActivePresentConjugator
            , UnaugmentedImperativeConjugator unaugmentedImperativeConjugator
            , PassivePresentConjugator passivePresentConjugator) {
        this.triActivePastConjugator = triActivePastConjugator;
        this.triPassivePastConjugator = triPassivePastConjugator;
        this.unaugmentedTrilateralActiveParticipleConjugator = unaugmentedTrilateralActiveParticipleConjugator;
        this.activeParticipleModifier = activeParticipleModifier;
        this.unaugmentedTrilateralPassiveParticipleConjugator = unaugmentedTrilateralPassiveParticipleConjugator;
        this.trilateralUnaugmentedPassiveParticipleModifier = trilateralUnaugmentedPassiveParticipleModifier;
        this.trilateralUnaugmentedNouns = trilateralUnaugmentedNouns;
        this.standardExaggerationConjugator = standardExaggerationConjugator;
        this.exaggerationModifier = exaggerationModifier;
        this.nonStandardExaggerationConjugator = nonStandardExaggerationConjugator;
        this.timeAndPlaceConjugator = timeAndPlaceConjugator;
        this.timeAndPlaceModifier = timeAndPlaceModifier;
        this.standardInstrumentalConjugator = standardInstrumentalConjugator;
        this.instrumentalModifier = instrumentalModifier;
        this.assimilateConjugator = assimilateConjugator;
        this.assimilateModifier = assimilateModifier;
        this.elativeConjugator = elativeConjugator;
        this.elativeModifier = elativeModifier;
        this.trilateralUnaugmentedGerundConjugator = trilateralUnaugmentedGerundConjugator;
        this.unaugmentedTrilateralStandardGerundModifier = unaugmentedTrilateralStandardGerundModifier;
        this.meemGerundConjugator = meemGerundConjugator;
        this.trilateralUnaugmentedMeemModifier = trilateralUnaugmentedMeemModifier;
        this.trilateralUnaugmentedNomenGerundConjugator = trilateralUnaugmentedNomenGerundConjugator;
        this.trilateralUnaugmentedNomenModifier = trilateralUnaugmentedNomenModifier;
        this.qualityGerundConjugator = qualityGerundConjugator;

        this.qualityGerundModifier = qualityGerundModifier;
        this.unaugmentedTrilateralModifier = unaugmentedTrilateralModifier;
        this.triUnaugmentedActivePresentConjugator = triUnaugmentedActivePresentConjugator;
        this.unaugmentedImperativeConjugator = unaugmentedImperativeConjugator;
        this.passivePresentConjugator = passivePresentConjugator;
    }

    @Override
    public List<WordPresenter> retrieveActivePastConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active){
        List<? extends Word> result = active ? triActivePastConjugator.createVerbList(root) : triPassivePastConjugator.createVerbList(root);
        var conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.PAST_TENSE, active);
        var finalResult = conjResult.getFinalResult();
        return  finalResult;
    }

    @Override
    public List<WordPresenter> retrieveActiveNominativePresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active) {
        var result = active ? triUnaugmentedActivePresentConjugator.createNominativeVerbList(root)
                : passivePresentConjugator.createNominativeVerbList(root);
        ConjugationResult conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.PRESENT_TENSE, active);
        return conjResult.getFinalResult();
    }

    @Override
    public List<WordPresenter> retrieveActiveAccusativePresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active) {
        var result = active ? triUnaugmentedActivePresentConjugator.createAccusativeVerbList(root):
                passivePresentConjugator.createAccusativeVerbList(root);
        ConjugationResult conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.PRESENT_TENSE, active);
        return conjResult.getFinalResult();
    }

    @Override
    public List<WordPresenter> retrieveActiveJussivePresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active) {
        var result = active ? triUnaugmentedActivePresentConjugator.createJussiveVerbList(root) :
                passivePresentConjugator.createJussiveVerbList(root);
        ConjugationResult conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.PRESENT_TENSE, active);
        return conjResult.getFinalResult();
    }

    @Override
    public List<WordPresenter> retrieveActiveEmphasizedPresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active) {
        var result = active ? triUnaugmentedActivePresentConjugator.createEmphasizedVerbList(root) :
                passivePresentConjugator.createEmphasizedVerbList(root);
        ConjugationResult conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.PRESENT_TENSE, active);
        return conjResult.getFinalResult();
    }

    @Override
    public List<WordPresenter> retrieveImperative(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var result = unaugmentedImperativeConjugator.createVerbList(root);
        ConjugationResult conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true);
        return conjResult.getFinalResult()
                .stream().map(wp -> wp.isEmpty() ? WordPresenter.fromText("-") : wp).toList();
    }

    @Override
    public List<WordPresenter> retrieveEmphasizedImperative(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        var result = unaugmentedImperativeConjugator.createEmphasizedVerbList(root);
        ConjugationResult conjResult = unaugmentedTrilateralModifier.build(root, kov, result, SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true);
        return conjResult.getFinalResult()
                .stream().map(wp -> wp.isEmpty() ? WordPresenter.fromText("-") : wp).toList();
    }
}
