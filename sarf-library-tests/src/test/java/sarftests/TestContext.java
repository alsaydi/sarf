package sarftests;

import io.cucumber.guice.ScenarioScoped;
import sarftests.noun.NounType;

@ScenarioScoped
public class TestContext {
    public TestContext(){
        VerbState = sarftests.VerbState.Nominative;
        NounType = sarftests.noun.NounType.ActiveParticiple;
        RootType = sarftests.RootType.TrilateralUnaugmented;
    }
    public VerbState VerbState;
    public RootType RootType;
    public NounType NounType;
}

