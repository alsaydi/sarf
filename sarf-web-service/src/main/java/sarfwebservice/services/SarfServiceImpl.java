package sarfwebservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sarf.SarfDictionary;
import sarf.Validator;
import sarf.verb.Root;

import java.util.List;

@Service
public class SarfServiceImpl implements SarfService {

    private final SarfDictionary sarfDictionary;
    private final Validator sarfValidator;

    @Autowired
    public SarfServiceImpl(SarfDictionary sarfDictionary, Validator sarfValidator){
        this.sarfDictionary = sarfDictionary;
        this.sarfValidator = sarfValidator;
    }

    public boolean isArabic(String letters){
        return sarfValidator.checkArabicLetters(letters);
    }

    public List<? extends Root> getRoot(String rootLetters) {
        try {
            return sarfDictionary.getUnaugmentedTrilateralRoots(rootLetters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
