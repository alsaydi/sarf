package sarfwebservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sarf.SarfDictionary;
import sarf.verb.Root;

import java.util.List;

@Service
public class SarfServiceImpl implements SarfService {

    private final SarfDictionary sarfDictionary;

    @Autowired
    public SarfServiceImpl(SarfDictionary sarfDictionary){
        this.sarfDictionary = sarfDictionary;
    }

    public List<? extends Root> getRoot(String rootLetters) throws Exception {
        return sarfDictionary.getUnaugmentedTrilateralRoots(rootLetters);
    }
}
