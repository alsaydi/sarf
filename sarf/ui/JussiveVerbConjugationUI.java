package sarf.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;
import sarf.*;
import javax.swing.border.*;
import java.awt.color.*;
import java.io.File;
import java.io.IOException;
import sarf.util.FileUtil;
import java.io.FileNotFoundException;

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
public class JussiveVerbConjugationUI extends JPanel implements IHtmlContentSaver  {
    List dataFieldsList = new ArrayList(13);
    public static final Font FONT = new Font("Traditional Arabic", Font.PLAIN, 30);
    public static final Border BORDER = BorderFactory.createEtchedBorder();

    private String title;

    /**
     * «ŸÂ«— «·ﬁ«∆„… »«” ⁄„«· Ê»œÊ‰ «·«œ€«„
     * @param verbConjugationList List
     * @param notGeminatedVerbConjugationList List
     */
    public JussiveVerbConjugationUI(List verbConjugationList, List notGeminatedVerbConjugationList, String title) {
        super(new GridLayout(7,4));
        this.title = title;
        setFont(FONT);
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        List pronounsList = SeparatedPronounsContainer.getInstance().getPronouns();
        JLabel lbl = null;
        JLabel lbl1 = null;
        JLabel lbl2 = null;
        for (int i=0; i<6;i++) {
            //≈÷«›… ‰’ Ì„À· «·÷„Ì—
            add(lbl = new JLabel((String) pronounsList.get(i)));
            decorateLabel(lbl);
            //≈÷«›… ‰’ Ì„À· «·›⁄·
            add(lbl1 = new JLabel(verbConjugationList.get(i)+""));
            decorateVerbLabel(lbl1);
            //≈÷«›… ‰’ Ì„À· «·÷„Ì—
            add(lbl = new JLabel((String) pronounsList.get(i+7)));
            decorateLabel(lbl);
            //≈÷«›… ‰’ Ì„À· «·›⁄·
            add(lbl2 = new JLabel(verbConjugationList.get(i+7)+""));
            decorateVerbLabel(lbl2);

            if (i == 0 || i == 1) {
                if (verbConjugationList.get(i)!= null && !verbConjugationList.get(i).equals(notGeminatedVerbConjugationList.get(i)))
                    lbl1.setText(lbl1.getText() + " / "+notGeminatedVerbConjugationList.get(i));
                if (verbConjugationList.get(i+7)!= null && !verbConjugationList.get(i+7).equals(notGeminatedVerbConjugationList.get(i+7)))
                    lbl2.setText(lbl2.getText() + " / "+notGeminatedVerbConjugationList.get(i+7));
            }
            else if (i == 2) {
                if (verbConjugationList.get(2) != null && !verbConjugationList.get(2).equals(notGeminatedVerbConjugationList.get(2)))
                    lbl1.setText(lbl1.getText() + " / "+notGeminatedVerbConjugationList.get(2));
            }
        }
        //≈÷«›… ‰’ Ì„À· «·÷„Ì—
        add(lbl = new JLabel((String) pronounsList.get(6)));
        decorateLabel(lbl);
        //≈÷«›… ‰’ Ì„À· «·›⁄·
        add(lbl = new JLabel(verbConjugationList.get(6)+""));
        decorateVerbLabel(lbl);

        add(lbl = new JLabel(" "));
        decorateLabel(lbl);
        add(lbl = new JLabel(" "));
        decorateVerbLabel(lbl);
    }

    private void decorateLabel(JLabel lbl) {
        lbl.setFont(FONT);
        lbl.setBorder(BORDER);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        if (lbl.getText().equals("null"))
            lbl.setText("");

        //lbl.setOpaque(true);
        //lbl.setBackground(backgroundcolor2);
    }

    static final Color backgroundcolor2 = new Color(250,231,226);
    private void decorateVerbLabel(JLabel lbl) {
        decorateLabel(lbl);
        lbl.setOpaque(true);
        lbl.setBackground(backgroundcolor2);
    }

    public boolean saveToHtml(File file) {
        String content = FileUtil.getContents(new File("db/verbs.html"));

        String docTitle = " ’—Ì› "+ " ( "+ title + " ) " +" ··›⁄· "+ " ( "+ ControlPaneContainer.getInstance().getVerbTxtFld().getText() +" )";
        //put the title
        content = content.replaceFirst("DocTitle", docTitle);

        for (int i = 0; i < 6; i++) {
            Object result = dataFieldsList.get(i);
            //vri verb right position
            String vri = result == null ? "&nbsp;" : result.toString();

            result = dataFieldsList.get(i+7);
            //vli verb left position
            String vli = result == null ? "&nbsp;" : result.toString();

            content = content.replaceFirst("vr" + i, vri);
            content = content.replaceFirst("vl" + (i), vli);
        }
        Object result = dataFieldsList.get(6);
        String vr6 = result == null ? "&nbsp;" : result.toString();
        content = content.replaceFirst("vr6" , vr6);

        try {
            FileUtil.saveContents(file, content);
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public String getSavedFileNameTitle() {
        return " ’—Ì› "+ " "+ title + " " +" ··›⁄· "+ "  "+ ControlPaneContainer.getInstance().getVerbTxtFld().getText();
    }

}
