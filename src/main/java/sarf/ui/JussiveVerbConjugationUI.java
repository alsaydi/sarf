package sarf.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;
import sarf.*;
import javax.swing.border.*;
import java.io.File;
import java.io.IOException;
import sarf.util.FileUtil;

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
    private final IMainControlPanel controlPaneContainer;
    private final List dataFieldsList = new ArrayList(SystemConstants.PRONOUN_RANGE_END);
    public static final Font FONT = new Font("Traditional Arabic", Font.PLAIN, 30);
    private static final Border BORDER = BorderFactory.createEtchedBorder();

    private final String title;

    /**
     * اظهار القائمة باستعمال وبدون الادغام
     * @param verbConjugationList List
     * @param notGeminatedVerbConjugationList List
     */
    public JussiveVerbConjugationUI(IMainControlPanel controlPaneContainer, List<WordPresenter> verbConjugationList, List<WordPresenter> notGeminatedVerbConjugationList, String title) {
        super(new GridLayout(7,4));
        this.controlPaneContainer = controlPaneContainer;
        this.title = title;
        setFont(FONT);
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        List pronounsList = SeparatedPronounsContainer.getPronouns();
        JLabel lbl;
        JLabel lbl1;
        JLabel lbl2;
        for (int i=0; i<6;i++) {
            //إضافة نص يمثل الضمير
            add(lbl = new JLabel((String) pronounsList.get(i)));
            decorateLabel(lbl);
            //إضافة نص يمثل الفعل
            add(lbl1 = new JLabel(verbConjugationList.get(i)+""));
            decorateVerbLabel(lbl1);
            //إضافة نص يمثل الضمير
            add(lbl = new JLabel((String) pronounsList.get(i+7)));
            decorateLabel(lbl);
            //إضافة نص يمثل الفعل
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
        //إضافة نص يمثل الضمير
        add(lbl = new JLabel((String) pronounsList.get(6)));
        decorateLabel(lbl);
        //إضافة نص يمثل الفعل
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

    private static final Color backgroundcolor2 = new Color(250,231,226);
    private void decorateVerbLabel(JLabel lbl) {
        decorateLabel(lbl);
        lbl.setOpaque(true);
        lbl.setBackground(backgroundcolor2);
    }

    public boolean saveToHtml(File file) {
        String content = FileUtil.getContents("db/verbs.html");

        String docTitle = "تصريف "+ " ( "+ title + " ) " +" للفعل "+ " ( "+ controlPaneContainer.getVerbText() +" )";
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
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public String getSavedFileNameTitle() {
        return "تصريف "+ " "+ title + " " +" للفعل "+ "  "+ controlPaneContainer.getVerbText();
    }

}
