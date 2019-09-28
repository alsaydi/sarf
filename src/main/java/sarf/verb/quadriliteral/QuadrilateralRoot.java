package sarf.verb.quadriliteral;

import sarf.verb.Root;
import sarf.verb.RootLetter;

import java.util.List;

import static sarf.verb.RootLetter.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class QuadrilateralRoot extends Root {
    private char c4;

    public char getC4() {
        return c4;
    }

    public void setC4(char c4) {
        this.c4 = c4;
    }

    @Override
    public List<RootLetter> getCharacters() {
        return List.of(new RootLetter(C1, getC1())
                , new RootLetter(C2, getC2())
                , new RootLetter(C3, getC3())
                , new RootLetter(C4, getC4()));
    }
}
