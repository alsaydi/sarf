package sarfwebservice.services;

import sarf.Validator;
import sarfwebservice.models.RootResult;

public class SarfServiceQuadImpl extends SarfServiceImpl implements SarfServiceQuad{
    public SarfServiceQuadImpl(Validator sarfValidator) {
        super(sarfValidator);
    }

    @Override
    public RootResult getRoots(String rootLetters) throws Exception {
        return null;
    }
}
