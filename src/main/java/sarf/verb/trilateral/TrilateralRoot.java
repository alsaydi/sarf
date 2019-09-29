package sarf.verb.trilateral;

import sarf.verb.Root;
import sarf.verb.RootLetter;
import java.util.List;
import static sarf.verb.RootLetter.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الصف الأب للجذر الثلاثي المزيد والناقص     </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class TrilateralRoot extends Root {
    protected TrilateralRoot() {
        super();
    }

    protected TrilateralRoot(char c1, char c2, char c3) {
        super(c1, c2, c3);
    }

    @Override
    public List<RootLetter> getCharacters() {
        return List.of(new RootLetter(C1, getC1())
                , new RootLetter(C2, getC2())
                , new RootLetter(C3, getC3()));
    }
}
