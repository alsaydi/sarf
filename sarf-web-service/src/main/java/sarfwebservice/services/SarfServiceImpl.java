package sarfwebservice.services;

import sarf.Validator;

public abstract class SarfServiceImpl implements SarfService {
    private final Validator sarfValidator;
    public SarfServiceImpl(Validator sarfValidator){
        this.sarfValidator = sarfValidator;
    }

    public boolean isArabic(String letters){
        return sarfValidator.checkArabicLetters(letters);
    }
}
