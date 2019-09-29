package sarftests.noun;

import com.google.inject.Inject;
import sarftests.RootType;
import sarftests.noun.quad.augmented.QuadrilateralAugmentedActiveParticipleNounProvider;
import sarftests.noun.quad.augmented.QuadrilateralAugmentedPassiveParticipleNounProvider;
import sarftests.noun.quad.augmented.QuadrilateralAugmentedTimeAndPlaceNounProvider;
import sarftests.noun.quad.augmented.gerund.QuadrilateralAugmentedGerundNounProvider;
import sarftests.noun.quad.augmented.gerund.QuadrilateralAugmentedMeemGerundNounProvider;
import sarftests.noun.quad.augmented.gerund.QuadrilateralAugmentedNomenGerundNounProvider;
import sarftests.noun.quad.unaugmented.QuadrilateralUnaugmentedActiveParticipleNounProvider;
import sarftests.noun.quad.unaugmented.QuadrilateralUnaugmentedPassiveParticipleNounProvider;
import sarftests.noun.quad.unaugmented.QuadrilateralUnaugmentedTimeAndPlaceNounProvider;
import sarftests.noun.quad.unaugmented.gerund.QuadrilateralUnaugmentedGerundNounProvider;
import sarftests.noun.quad.unaugmented.gerund.QuadrilateralUnaugmentedMeemGerundNounProvider;
import sarftests.noun.quad.unaugmented.gerund.QuadrilateralUnaugmentedNomenGerundNounProvider;
import sarftests.noun.tri.augmented.AugmentedActiveParticipleNounProvider;
import sarftests.noun.tri.augmented.AugmentedPassiveParticipleNounProvider;
import sarftests.noun.tri.augmented.AugmentedTimeAndPlaceNounProvider;
import sarftests.noun.tri.augmented.gerund.AugmentedGerundNounProvider;
import sarftests.noun.tri.augmented.gerund.AugmentedMeemGerundNounProvider;
import sarftests.noun.tri.augmented.gerund.AugmentedNomenGerundNounProvider;
import sarftests.noun.tri.unaugmented.*;
import sarftests.noun.tri.unaugmented.gerund.GerundNounProvider;
import sarftests.noun.tri.unaugmented.gerund.MeemGerundNounProvider;
import sarftests.noun.tri.unaugmented.gerund.NomenGerundNounProvider;
import sarftests.noun.tri.unaugmented.gerund.QualityGerundNounProvider;

public class NounProviderFactory {
    private final ActiveParticipleNounProvider activeParticipleNounProvider;
    private final PassiveParticipleNounProvider passiveParticipleNounProvider;
    private final EmphasizedActiveParticipleNounProvider emphasizedActiveParticipleNounProvider;
    private final TimeAndPlaceNounProvider timeAndPlaceNounProvider;
    private final InstrumentNounProvider instrumentNounProvider;
    private final AssimilateNounProvider assimilateNounProvider;
    private final ElativeNounProvider elativeNounProvider;
    private final GerundNounProvider gerundNounProvider;
    private final MeemGerundNounProvider meemGerundNounProvider;
    private final NomenGerundNounProvider nomenGerundNounProvider;
    private final QualityGerundNounProvider qualityGerundNounProvider;

    private final AugmentedActiveParticipleNounProvider augmentedActiveParticipleNounProvider;
    private final AugmentedPassiveParticipleNounProvider augmentedPassiveParticipleNounProvider;
    private final AugmentedTimeAndPlaceNounProvider augmentedTimeAndPlaceNounProvider;
    private final AugmentedGerundNounProvider augmentedGerundNounProvider;
    private final AugmentedNomenGerundNounProvider augmentedNomenGerundNounProvider;
    private final AugmentedMeemGerundNounProvider augmentedMeemGerundNounProvider;

    private final QuadrilateralUnaugmentedActiveParticipleNounProvider quadrilateralUnaugmentedActiveParticipleNounProvider;
    private final QuadrilateralUnaugmentedPassiveParticipleNounProvider quadrilateralUnaugmentedPassiveParticipleNounProvider;
    private final QuadrilateralUnaugmentedTimeAndPlaceNounProvider quadrilateralUnaugmentedTimeAndPlaceNounProvider;
    private final QuadrilateralUnaugmentedGerundNounProvider quadrilateralUnaugmentedGerundNounProvider;
    private final QuadrilateralUnaugmentedNomenGerundNounProvider quadrilateralUnaugmentedNomenGerundNounProvider;
    private final QuadrilateralUnaugmentedMeemGerundNounProvider quadrilateralUnaugmentedMeemGerundNounProvider;

    private final QuadrilateralAugmentedActiveParticipleNounProvider quadrilateralAugmentedActiveParticipleNounProvider;
    private final QuadrilateralAugmentedPassiveParticipleNounProvider quadrilateralAugmentedPassiveParticipleNounProvider;
    private final QuadrilateralAugmentedTimeAndPlaceNounProvider quadrilateralAugmentedTimeAndPlaceNounProvider;
    private final QuadrilateralAugmentedGerundNounProvider quadrilateralAugmentedGerundNounProvider;
    private final QuadrilateralAugmentedMeemGerundNounProvider quadrilateralAugmentedMeemGerundNounProvider;
    private final QuadrilateralAugmentedNomenGerundNounProvider quadrilateralAugmentedNomenGerundNounProvider;

    @Inject
    public NounProviderFactory(ActiveParticipleNounProvider activeParticipleNounProvider
            , PassiveParticipleNounProvider passiveParticipleNounProvider
            , EmphasizedActiveParticipleNounProvider emphasizedActiveParticipleNounProvider
            , TimeAndPlaceNounProvider timeAndPlaceNounProvider
            , InstrumentNounProvider instrumentNounProvider
            , AssimilateNounProvider assimilateNounProvider
            , ElativeNounProvider elativeNounProvider
            , GerundNounProvider gerundNounProvider
            , MeemGerundNounProvider meemGerundNounProvider, NomenGerundNounProvider nomenGerundNounProvider
            , QualityGerundNounProvider qualityGerundNounProvider
            , AugmentedActiveParticipleNounProvider augmentedActiveParticipleNounProvider
            , AugmentedPassiveParticipleNounProvider augmentedPassiveParticipleNounProvider
            , AugmentedTimeAndPlaceNounProvider augmentedTimeAndPlaceNounProvider
            , AugmentedGerundNounProvider augmentedGerundNounProvider
            , AugmentedNomenGerundNounProvider augmentedNomenGerundNounProvider
            , AugmentedMeemGerundNounProvider augmentedMeemGerundNounProvider
            , QuadrilateralUnaugmentedActiveParticipleNounProvider quadrilateralUnaugmentedActiveParticipleNounProvider
            , QuadrilateralUnaugmentedPassiveParticipleNounProvider quadrilateralUnaugmentedPassiveParticipleNounProvider
            , QuadrilateralUnaugmentedTimeAndPlaceNounProvider quadrilateralUnaugmentedTimeAndPlaceNounProvider
            , QuadrilateralUnaugmentedGerundNounProvider quadrilateralUnaugmentedGerundNounProvider
            , QuadrilateralUnaugmentedNomenGerundNounProvider quadrilateralUnaugmentedNomenGerundNounProvider
            , QuadrilateralUnaugmentedMeemGerundNounProvider quadrilateralUnaugmentedMeemGerundNounProvider
            , QuadrilateralAugmentedActiveParticipleNounProvider quadrilateralAugmentedActiveParticipleNounProvider
            , QuadrilateralAugmentedPassiveParticipleNounProvider quadrilateralAugmentedPassiveParticipleNounProvider
            , QuadrilateralAugmentedTimeAndPlaceNounProvider quadrilateralAugmentedTimeAndPlaceNounProvider
            , QuadrilateralAugmentedGerundNounProvider quadrilateralAugmentedGerundNounProvider
            , QuadrilateralAugmentedMeemGerundNounProvider quadrilateralAugmentedMeemGerundNounProvider
            , QuadrilateralAugmentedNomenGerundNounProvider quadrilateralAugmentedNomenGerundNounProvider) {
        this.activeParticipleNounProvider = activeParticipleNounProvider;
        this.passiveParticipleNounProvider = passiveParticipleNounProvider;
        this.emphasizedActiveParticipleNounProvider = emphasizedActiveParticipleNounProvider;
        this.timeAndPlaceNounProvider = timeAndPlaceNounProvider;
        this.instrumentNounProvider = instrumentNounProvider;
        this.assimilateNounProvider = assimilateNounProvider;
        this.elativeNounProvider = elativeNounProvider;
        this.gerundNounProvider = gerundNounProvider;
        this.meemGerundNounProvider = meemGerundNounProvider;
        this.nomenGerundNounProvider = nomenGerundNounProvider;
        this.qualityGerundNounProvider = qualityGerundNounProvider;
        this.augmentedActiveParticipleNounProvider = augmentedActiveParticipleNounProvider;
        this.augmentedPassiveParticipleNounProvider = augmentedPassiveParticipleNounProvider;
        this.augmentedTimeAndPlaceNounProvider = augmentedTimeAndPlaceNounProvider;
        this.augmentedGerundNounProvider = augmentedGerundNounProvider;
        this.augmentedNomenGerundNounProvider = augmentedNomenGerundNounProvider;
        this.augmentedMeemGerundNounProvider = augmentedMeemGerundNounProvider;
        this.quadrilateralUnaugmentedActiveParticipleNounProvider = quadrilateralUnaugmentedActiveParticipleNounProvider;
        this.quadrilateralUnaugmentedPassiveParticipleNounProvider = quadrilateralUnaugmentedPassiveParticipleNounProvider;
        this.quadrilateralUnaugmentedTimeAndPlaceNounProvider = quadrilateralUnaugmentedTimeAndPlaceNounProvider;
        this.quadrilateralUnaugmentedGerundNounProvider = quadrilateralUnaugmentedGerundNounProvider;
        this.quadrilateralUnaugmentedNomenGerundNounProvider = quadrilateralUnaugmentedNomenGerundNounProvider;
        this.quadrilateralUnaugmentedMeemGerundNounProvider = quadrilateralUnaugmentedMeemGerundNounProvider;
        this.quadrilateralAugmentedActiveParticipleNounProvider = quadrilateralAugmentedActiveParticipleNounProvider;
        this.quadrilateralAugmentedPassiveParticipleNounProvider = quadrilateralAugmentedPassiveParticipleNounProvider;
        this.quadrilateralAugmentedTimeAndPlaceNounProvider = quadrilateralAugmentedTimeAndPlaceNounProvider;
        this.quadrilateralAugmentedGerundNounProvider = quadrilateralAugmentedGerundNounProvider;
        this.quadrilateralAugmentedMeemGerundNounProvider = quadrilateralAugmentedMeemGerundNounProvider;
        this.quadrilateralAugmentedNomenGerundNounProvider = quadrilateralAugmentedNomenGerundNounProvider;
    }

    public INounProvider create(RootType rootType, NounType nounType) {
        if (rootType == RootType.TrilateralUnaugmented) {
            return createTrilateralUnaugmented(nounType);
        }
        if (rootType == RootType.TrilateralAugmented) {
            return createTrilateralAugmented(nounType);
        }
        if (rootType == RootType.QuadrilateralUnaugmented) {
            return createQuadrilateralUnaugmented(nounType);
        }
        if(rootType == RootType.QuadrilateralAugmented){
            return createQuadrilateralAugmented(nounType);
        }
        return null;
    }

    private INounProvider createTrilateralUnaugmented(NounType nounType) {
        switch (nounType) {
            case ActiveParticiple:
                return activeParticipleNounProvider;
            case PassiveParticiple:
                return passiveParticipleNounProvider;
            case EmphasizedActiveParticiple:
                return emphasizedActiveParticipleNounProvider;
            case TimeAndPlace:
                return timeAndPlaceNounProvider;
            case Instrument:
                return instrumentNounProvider;
            case Assimilate:
                return assimilateNounProvider;
            case Elative:
                return elativeNounProvider;
            case Gerund:
                return gerundNounProvider;
            case MeemGerund:
                return meemGerundNounProvider;
            case NomenGerund:
                return nomenGerundNounProvider;
            case QualityGerund:
                return qualityGerundNounProvider;
        }
        return null;
    }

    private INounProvider createTrilateralAugmented(NounType nounType) {
        switch (nounType) {
            case ActiveParticiple:
                return augmentedActiveParticipleNounProvider;
            case PassiveParticiple:
                return augmentedPassiveParticipleNounProvider;
            case TimeAndPlace:
                return augmentedTimeAndPlaceNounProvider;
            case Gerund:
                return augmentedGerundNounProvider;
            case NomenGerund:
                return augmentedNomenGerundNounProvider;
            case MeemGerund:
                return augmentedMeemGerundNounProvider;
        }
        return null;
    }

    private INounProvider createQuadrilateralUnaugmented(NounType nounType) {
        switch (nounType) {
            case ActiveParticiple:
                return quadrilateralUnaugmentedActiveParticipleNounProvider;
            case PassiveParticiple:
                return quadrilateralUnaugmentedPassiveParticipleNounProvider;
            case TimeAndPlace:
                return quadrilateralUnaugmentedTimeAndPlaceNounProvider;
            case Gerund:
                return quadrilateralUnaugmentedGerundNounProvider;
            case NomenGerund:
                return quadrilateralUnaugmentedNomenGerundNounProvider;
            case MeemGerund:
                return quadrilateralUnaugmentedMeemGerundNounProvider;
        }
        return null;
    }

    private INounProvider createQuadrilateralAugmented(NounType nounType) {
        switch (nounType) {
            case ActiveParticiple:
                return quadrilateralAugmentedActiveParticipleNounProvider;
            case PassiveParticiple:
                return quadrilateralAugmentedPassiveParticipleNounProvider;
            case TimeAndPlace:
                return quadrilateralAugmentedTimeAndPlaceNounProvider;
            case Gerund:
                return quadrilateralAugmentedGerundNounProvider;
            case NomenGerund:
                return quadrilateralAugmentedNomenGerundNounProvider;
            case MeemGerund:
                return quadrilateralAugmentedMeemGerundNounProvider;
        }
        return null;
    }
}
