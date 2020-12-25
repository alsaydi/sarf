package sarfwebservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sarf.SarfDictionary;
import sarf.Validator;
import sarf.verb.Root;

import java.util.HashSet;
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

    public List<? extends Root> getRoots(String rootLetters) {
        try {
            var unaugmentedTrilateralRoots = sarfDictionary.getUnaugmentedTrilateralRoots(rootLetters);
            var augmentedTrilateralRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var augmentationFormulas =  augmentedTrilateralRoot.getAugmentationList();
            for(var formula : augmentationFormulas) {
                formula
            }
            var set = new HashSet<Root>(unaugmentedTrilateralRoots);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
