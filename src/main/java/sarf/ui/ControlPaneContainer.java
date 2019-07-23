package sarf.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.prefs.*;

import javax.swing.*;

import sarf.*;
import sarf.kov.*;
import sarf.ui.controlpane.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.unaugmented.*;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.unaugmented.*;

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
public class ControlPaneContainer extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, IControlPane> controlPaneMap = new HashMap<>();
    private JButton startBtn = new RenderedButton("أدخل جذراً ثلاثياً أو رباعياً");
    private JButton backBtn = new RenderedButton("عودة");
    private JTextField rootFld = new JTextField(5);
    private JPanel container = new JPanel(new BorderLayout());

    private JPanel resultPane = new JPanel(new BorderLayout());
    private Preferences pref;

    //store the opened panels so you can go back and forward
    private List<IControlPane> panelCashSet = new LinkedList<IControlPane>();
    //used a s a reference to the current panel for the back-forward
    private IControlPane currentControlPane;
    private JTextField kovFld = new JTextField(14);
    private JTextField transitiveTypeFld = new JTextField(8);
    private int kov;
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem backMnuItm = new JMenuItem("عودة");
    private JMenuItem help1MnuItm = new JMenuItem("قواعد النحو والصرف");
    private JMenuItem help2MnuItm = new JMenuItem("دليل الاستعمال");
    private JMenuItem help3MnuItm = new JMenuItem("تعريف بالنظام");
    private JMenuItem saveMnuItm = new JMenuItem("حفظ الجدول");
    private JMenuItem aboutMnuItm = new JMenuItem("حول البرنامج");
    private JMenuItem showIntroMnuItm = new JCheckBoxMenuItem("إظهار الشاشة التقديمية");
    private JMenuItem exitMnuItm = new JMenuItem("خروج");

    private JTextField verbTxtFld = new JTextField(8);

    private String kovText;


    private ControlPaneContainer() {
        super(new BorderLayout());

        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JMenu helpMainMenu = new JMenu("مساعدة");
        JMenu fileMainMenu = new JMenu("ملف");

        menuBar.add(fileMainMenu);
        menuBar.add(helpMainMenu);

        helpMainMenu.setFont(RenderedButton.FONT);
        fileMainMenu.setFont(RenderedButton.FONT);
        //menu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        helpMainMenu.add(help3MnuItm);
        help3MnuItm.addActionListener(e -> {
            try {
                Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL .\\documents\\progspec.htm");
            }
            catch (IOException ex) {
                ex.printStackTrace();
                ShowMessageBox(ex);
            }
        });
        help3MnuItm.setFont(RenderedButton.FONT);
        help3MnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        helpMainMenu.add(help2MnuItm);
        help2MnuItm.addActionListener(e -> {
            try {
                //for all win
                Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL .\\documents\\userguide.doc");
                //for winnt and xp just
//                    Runtime.getRuntime().exec("cmd /c .\\documents\\userguide.doc");
            }
            catch (IOException ex) {
                ex.printStackTrace();
                ShowMessageBox(ex);
            }
        });
        help2MnuItm.setFont(RenderedButton.FONT);
        help2MnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        helpMainMenu.add(help1MnuItm);
        help1MnuItm.addActionListener(e -> {
            try {
                Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL .\\documents\\rules.doc");
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        help1MnuItm.setFont(RenderedButton.FONT);
        help1MnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        fileMainMenu.add(saveMnuItm);
        saveMnuItm.setEnabled(false);
        saveMnuItm.addActionListener(e -> {
            IHtmlContentSaver htmlContentSaverComponent = (IHtmlContentSaver) currentResultPane;
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setSelectedFile(new File(htmlContentSaverComponent.getSavedFileNameTitle()));
            if (fileChooser.showSaveDialog(ControlPaneContainer.this) == JFileChooser.APPROVE_OPTION) {
                String fileName = fileChooser.getSelectedFile().getAbsolutePath();
                int index = fileName.indexOf(".");
                fileName = index == -1 ? fileName : fileName.substring(0, index);

                File file = new File(fileName + ".html");
                htmlContentSaverComponent.saveToHtml(file);
            }
        });
        saveMnuItm.setFont(RenderedButton.FONT);
        //saveMnuItm.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        fileMainMenu.add(showIntroMnuItm);
        showIntroMnuItm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pref.put("HideIntro", (!showIntroMnuItm.isSelected()) + "");
            }
        });
        showIntroMnuItm.setFont(RenderedButton.FONT);
        showIntroMnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        helpMainMenu.add(aboutMnuItm);
        aboutMnuItm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AboutDialog dialog = new AboutDialog();
                dialog.setVisible(true);
            }
        });
        aboutMnuItm.setFont(RenderedButton.FONT);
        aboutMnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        fileMainMenu.add(backMnuItm);
        backMnuItm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        backMnuItm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPreviousPane();
            }
        });
        backMnuItm.setFont(RenderedButton.FONT);
        backMnuItm.setEnabled(false);
        backMnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        fileMainMenu.add(exitMnuItm);
        exitMnuItm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitMnuItm.setFont(RenderedButton.FONT);
        exitMnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        Font font = new Font("Traditional Arabic", Font.BOLD, 22);
        Font font2 = new Font("Simplified Arabic", Font.PLAIN, 18);

        verbTxtFld.setFont(font);
        verbTxtFld.setForeground(Color.BLUE);
        verbTxtFld.setEditable(false);
        verbTxtFld.setHorizontalAlignment(JTextField.CENTER);

        JPanel topPane = new APanel();

        kovFld.setEditable(false);
        transitiveTypeFld.setEditable(false);

        JLabel lbl = new JLabel("نوع الفعل المجرد:");
        JLabel transitiveLbl = new JLabel("التعدية واللزوم:");

        lbl.setFont(RenderedButton.FONT);
        transitiveLbl.setFont(RenderedButton.FONT);

        transitiveTypeFld.setFont(RenderedButton.FONT);

        rootFld.setFont(font2);
        transitiveTypeFld.setFont(RenderedButton.FONT);
        kovFld.setFont(RenderedButton.FONT);

        Font font3 = new Font("Simplified Arabic", Font.BOLD, 14);
        backBtn.setFont(font3);

        kovFld.setHorizontalAlignment(SwingConstants.RIGHT);
        transitiveTypeFld.setHorizontalAlignment(SwingConstants.RIGHT);
        rootFld.setHorizontalAlignment(SwingConstants.RIGHT);
        Insets insets = new Insets(0, 0, 0, 10);
        rootFld.setMargin(insets);

        topPane.add(startBtn);
        topPane.add(rootFld);
        topPane.add(Box.createHorizontalStrut(5));
        topPane.add(verbTxtFld);
        topPane.add(Box.createHorizontalStrut(5));
        topPane.add(lbl);
        topPane.add(kovFld);
        topPane.add(Box.createHorizontalStrut(5));
        topPane.add(transitiveLbl);
        topPane.add(transitiveTypeFld);
        topPane.add(Box.createHorizontalStrut(25));
        topPane.add(backBtn);

        verbTxtFld.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                rootFld.requestFocus();
            }

            public void focusLost(FocusEvent e) {
            }
        });

        backBtn.setBackground(new Color(255, 233, 233));

        rootFld.addActionListener(e -> {
            try {
                rootEntered();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        JPanel controlPane = new JPanel(new BorderLayout());
        add(controlPane, BorderLayout.NORTH);
        add(resultPane);

        controlPane.add(topPane, BorderLayout.NORTH);
        controlPane.add(container);

        backBtn.setEnabled(false);
        backBtn.addActionListener(e -> showPreviousPane());

        startBtn.addActionListener(e -> {
            try {
                rootEntered();
            } catch (Exception e1) {
                e1.printStackTrace();
                ShowMessageBox(e1);
            }
        });
    }

    private void rootEntered() throws Exception {
        reset();
        String root = rootFld.getText();

        if (!Validator.getInstance().checkLength(root)) {
            container.removeAll();
            displayErrorMessage("عدد أحرف الجذر يجب أن يكون ثلاثة أو أربعة");
            return;
        }
        if (Validator.getInstance().checkStartedWithAlef(root)) {
            container.removeAll();
            displayErrorMessage("لا يمكن أن يبدأ الجذر بحرف الألف      ");
            return;
        }
        if (Validator.getInstance().checkAlefMamdoda(root)) {
            container.removeAll();
            displayErrorMessage("الحرف ( آ ) ليس من حروف المعجم    ");
            return;
        }
        if (Validator.getInstance().checkTashkil(root)) {
            container.removeAll();
            displayErrorMessage("علامات الشكل (الحركات) ليست من حروف المعجم    ");
            return;
        }

        //رد الهمزة إلى أصلها
        root = Validator.getInstance().correctHamza(root);
        //لكي لا تظهر رسالة التصحيح التلقائي للهمزة
        rootFld.setText(root);

        if (!Validator.getInstance().checkArabicLetters(root)) {
            container.removeAll();
            displayErrorMessage("خطأ في أحد أحرف الجذر");
            return;
        }

        if (root.length() == 3) {
            processTrilateral(root);
        }
        else
        if (rootFld.getText().length() == 4) {
            processQuadrilateral(root);
        }
        else {
            container.removeAll();
            JOptionPane.showMessageDialog(ControlPaneContainer.this, "الرجاء ادخال جذر ثلاثي أو رباعي     ", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void processTrilateral(String root) throws Exception {
        List<String> alefAlternatives = Validator.getInstance().getTrilateralAlefAlternatives(root);
        if (alefAlternatives.isEmpty()) {
            //لا يوجد احتمالات للألف
            AugmentedTrilateralRoot augmentedRoot = SarfDictionary.getInstance().getAugmentedTrilateralRoot(root);
            List<UnaugmentedTrilateralRoot> unaugmentedList = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(root);
            if (augmentedRoot == null && unaugmentedList.isEmpty()) {
                container.removeAll();
                validate();
                repaint();
                displayErrorMessage("لم يرد هذا الجذر في قاعدة المعطيات      ");
            }
            else {
                displayTrilateral(root, augmentedRoot, unaugmentedList);
            }
        }
        else {
            //تجريب بدائل الألف
            List<String> rootTextList = new LinkedList<>();
            List<AugmentedTrilateralRoot> augmentedList = new LinkedList<AugmentedTrilateralRoot>();
            List<List<UnaugmentedTrilateralRoot>> unaugmentedLists = new LinkedList<List<UnaugmentedTrilateralRoot>>();

            for (String alternativeRoot : alefAlternatives) {
                AugmentedTrilateralRoot augmentedRoot = SarfDictionary.getInstance().getAugmentedTrilateralRoot(alternativeRoot);
                List<UnaugmentedTrilateralRoot> unaugmentedList = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(alternativeRoot);

                if (augmentedRoot != null || !unaugmentedList.isEmpty()) {
                    rootTextList.add(alternativeRoot);
                    augmentedList.add(augmentedRoot);
                    unaugmentedLists.add(unaugmentedList);
                }
            }
            //فحص اذا نجح احتمال أو أكثر
            if (rootTextList.isEmpty()) {
                //لم ينجح أي بديل
                displayErrorMessage("لم يرد هذا الجذر في قاعدة المعطيات      ");
                return;
            }

            //اذا كان هناك بديل واحد فقط فيتم عرض معلوماته فوراً
            int index = 0;
            if (rootTextList.size() > 1) {
                //عرض أكثر من احتمال للمستخدم ليتم انتقاء واحد
                String dialogTitle = "يوجد أكثر من جذر   ";
                String dialogInput = "اختر أحد الجذرين  ";
                int selectionResult = JOptionPane.showOptionDialog(this, dialogInput, dialogTitle, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, rootTextList.toArray(),
                        rootTextList.get(0));
                /*for (int i = 0; i < rootTextList.size(); i++) {
                    if (selectedValue.equals(rootTextList.get(i))) {
                        index = i;
                        break;
                    }
                                 }*/
                index = selectionResult == JOptionPane.YES_OPTION ? 0 : 1;
            }
            //عرض معلومات الجذر المنتقى
            AugmentedTrilateralRoot augmentedRoot = augmentedList.get(index);
            List<UnaugmentedTrilateralRoot> unaugmentedList = unaugmentedLists.get(index);
            String newRoot = rootTextList.get(index).toString();
            //حتى لا يتم عرض رسالة نتبيهية
            //إلا في حالة جذر واحد
            if (rootTextList.size() > 1) {
                rootFld.setText(newRoot);
            }
            displayTrilateral(newRoot, augmentedRoot, unaugmentedList);
        }

    }


    private void displayTrilateral(String rootText, AugmentedTrilateralRoot augmentedRoot, List<UnaugmentedTrilateralRoot> unaugmentedRoots) {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);

        TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
        kovText = rule.getDesc();
        kov = rule.getKov();

        //عرض رسالة تنبيهية اذا تم تصحيح تلقائي
        if (!rootText.equals(rootFld.getText())) {
            String msg = "لقد تم تصحيح الجذر المدخل إلى       ";
            msg += rootText;
            //JOptionPane.showMessageDialog(this, msg, "", JOptionPane.INFORMATION_MESSAGE);

            //عرضه بعد التعديل اذا جرى تعديل
            rootFld.setText(rootText);
        }

        TrilateralControlPane trilateralControlPane = (TrilateralControlPane) openControlPane(TrilateralControlPane.class.getName());
        trilateralControlPane.disableAll();

        if (augmentedRoot != null) {
            for (AugmentationFormula formula : augmentedRoot.getAugmentationList()) {
                trilateralControlPane.enableAugmentedButton(formula.getFormulaNo() - 1, augmentedRoot);
            }
        }

        for (UnaugmentedTrilateralRoot root : unaugmentedRoots) {
            trilateralControlPane.enableUnaugmentedButton(root.getConjugation().getValue() - 1, root);
        }
    }

    private void processQuadrilateral(String root) throws Exception {
        //فحص إذا كان الفعل يبتدأ بهمزة
        if (root.charAt(0) == 'ء') {
            displayErrorMessage("لا يوجد رباعي يبتدئ بهمزة");
            return;
        }

        List<String> alefAlternatives = Validator.getInstance().getQuadrilateralAlefAlternatives(root);
        if (alefAlternatives.isEmpty()) {
            //لا يوجد احتمالات للألف
            AugmentedQuadrilateralRoot augmentedRoot = SarfDictionary.getInstance().getAugmentedQuadrilateralRoot(root);
            UnaugmentedQuadrilateralRoot unaugmentedRoot = SarfDictionary.getInstance().getUnaugmentedQuadrilateralRoot(root);
            if (augmentedRoot == null && unaugmentedRoot == null) {
                displayErrorMessage("لم يرد هذا الجذر في قاعدة المعطيات      ");
            }
            else {
                displayQuadrilateral(root, augmentedRoot, unaugmentedRoot);
            }

        }
        else {
            //تجريب بدائل الألف
            List<String> rootTextList = new LinkedList<String>();
            List<AugmentedQuadrilateralRoot> augmentedList = new LinkedList<>();
            List<UnaugmentedQuadrilateralRoot> unaugmentedList = new LinkedList<>();

            for (String alterativeRoot : alefAlternatives) {
                AugmentedQuadrilateralRoot augmentedRoot = SarfDictionary.getInstance().getAugmentedQuadrilateralRoot(alterativeRoot);
                UnaugmentedQuadrilateralRoot unaugmentedRoot = SarfDictionary.getInstance().getUnaugmentedQuadrilateralRoot(alterativeRoot);
                if (augmentedRoot != null || unaugmentedRoot != null) {
                    rootTextList.add(alterativeRoot);
                    augmentedList.add(augmentedRoot);
                    unaugmentedList.add(unaugmentedRoot);
                }
            }
            //فحص اذا نجح احتمال أو أكثر
            if (rootTextList.isEmpty()) {
                //لم ينجح أي بديل
                displayErrorMessage("لم يرد هذا الجذر في قاعدة المعطيات      ");
                return;
            }

            //اذا كان هناك بديل واحد فقط فيتم عرض معلوماته فوراً
            int index = 0;
            if (rootTextList.size() > 1) {
                //عرض أكثر من احتمال للمستخدم ليتم انتقاء واحد
                String dialogTitle = "يوجد أكثر من جذر   ";
                String dialogInput = "اختر أحد الجذرين  ";
                int selectionResult = JOptionPane.showOptionDialog(this, dialogInput, dialogTitle, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, rootTextList.toArray(), rootTextList.get(0));
                index = selectionResult == JOptionPane.YES_OPTION ? 0 : 1;
            }
            //عرض معلومات الجذر المنتقى
            AugmentedQuadrilateralRoot augmentedRoot = augmentedList.get(index);
            UnaugmentedQuadrilateralRoot unaugmentedRoot = unaugmentedList.get(index);

            String newRoot = rootTextList.get(index).toString();
            //حتى لا يتم عرض رسالة نتبيهية
            //إلا في حالة جذر واحد
            if (rootTextList.size() > 1) {
                rootFld.setText(newRoot);
            }
            displayQuadrilateral(newRoot, augmentedRoot, unaugmentedRoot);
        }
    }


    private void displayQuadrilateral(String rootText, AugmentedQuadrilateralRoot augmentedRoot, UnaugmentedQuadrilateralRoot unaugmentedRoot) {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);
        char c4 = rootText.charAt(3);

        QuadrilateralKovRule rule = KovRulesManager.getInstance().getQuadrilateralKovRule(c1, c2, c3, c4);
        kovText = rule.getDesc();
        kov = rule.getKov();

        //عرض رسالة تنبيهية اذا تم تصحيح تلقائي
        if (!rootText.equals(rootFld.getText())) {
            String msg = "لقد تم تصحيح الجذر المدخل إلى       ";
            msg += rootText;
            //JOptionPane.showMessageDialog(this, msg, "", JOptionPane.INFORMATION_MESSAGE);

            //عرضه بعد التعديل اذا جرى تعديل
            rootFld.setText(rootText);
        }

        QuadrilateralControlPane quadrilateralControlPane = (QuadrilateralControlPane) openControlPane(QuadrilateralControlPane.class.getName());
        quadrilateralControlPane.disableAll();

        if (unaugmentedRoot != null) {
            quadrilateralControlPane.enableUnaugmentedButton(unaugmentedRoot);
        }

        if (augmentedRoot != null) {
            for (Object o : augmentedRoot.getAugmentationList()) {
                AugmentationFormula formula = (AugmentationFormula) o;
                quadrilateralControlPane.enableAugmentedButton(formula.getFormulaNo() - 1, augmentedRoot);
            }
        }
    }


    private void displayErrorMessage(String msg) {
        resultPane.removeAll();
        resultPane.validate();
        resultPane.repaint();
        saveMnuItm.setEnabled(false);
        container.removeAll();

        validate();
        repaint();

        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(this, msg, "", JOptionPane.ERROR_MESSAGE);
    }


    private static ControlPaneContainer instance = new ControlPaneContainer();

    public static ControlPaneContainer getInstance() {
        return instance;
    }

    public int getKov() {
        return kov;
    }

    JMenuBar getMenuBar() {
        return menuBar;
    }

    JTextField getRootFld() {
        return rootFld;
    }

    JTextField getVerbTxtFld() {
        return verbTxtFld;
    }

    private IControlPane getControlPane(String className) {
        IControlPane controlPane = controlPaneMap.get(className);
        if (controlPane == null) {
            try {
                controlPane = (IControlPane) Class.forName(className).newInstance();
                controlPaneMap.put(className, controlPane);
            }
            catch (Exception ex) {
                ex.printStackTrace();
                ShowMessageBox(ex);
            }
        }
        return controlPane;
    }

    public IControlPane openControlPane(String className) {
        resultPane.removeAll();
        resultPane.validate();
        resultPane.repaint();
        saveMnuItm.setEnabled(false);

        validate();
        repaint();

        container.removeAll();
        IControlPane controlPane = getControlPane(className);
        container.add(controlPane.getComponent());
        validate();
        repaint();

        if (!panelCashSet.contains(controlPane)) {
            panelCashSet.add(controlPane);
        }
        if (panelCashSet.indexOf(controlPane) > 0) {
            backBtn.setEnabled(true);
            backMnuItm.setEnabled(true);
        }
        controlPane.controlPaneOpened();
        if (currentControlPane != null) {
            currentControlPane.controlPaneClosed();
        }

        currentControlPane = controlPane;
        return controlPane;
    }

    private void showPreviousPane() {
        if (currentControlPane == null) {
            return;
        }
        int index = panelCashSet.indexOf(currentControlPane);
        if (index > 0) {
            IControlPane controlPane = panelCashSet.get(index - 1);
            //first remove it from the cash so the flow will not get effected
            panelCashSet.remove(index);

            openControlPane(controlPane.getClass().getName());
            index--;

            if (index == 0) {
                backBtn.setEnabled(false);
                backMnuItm.setEnabled(false);

                transitiveTypeFld.setText("");
                setVerbText("");
                kovFld.setText("");
            }
        }

    }

    private void reset() {
        panelCashSet.clear();
        currentControlPane = null;
        backBtn.setEnabled(false);
        saveMnuItm.setEnabled(false);
        kovFld.setText("");
        transitiveTypeFld.setText("");
        setVerbText("");

        resultPane.removeAll();
        resultPane.validate();
        resultPane.repaint();
        container.removeAll();

        validate();
        repaint();

    }

    private JComponent currentResultPane = null;
    public void openResult(JComponent resultComponent) {
        resultPane.removeAll();
        resultPane.add(resultComponent);
        resultPane.validate();
        resultPane.repaint();

        validate();
        repaint();

        currentResultPane = resultComponent;
        saveMnuItm.setEnabled(true);
    }

    public void setTransitiveType(String type) {
        if (type.equals("م")) {
            transitiveTypeFld.setText("متعد");
        }
        else if (type.equals("ل")) {
            transitiveTypeFld.setText("لازم");
        }
        else {
            transitiveTypeFld.setText("لازم ومتعد ");
        }
    }

    public void setVerbText(String text) {
        verbTxtFld.setText(text);
        kovFld.setText(kovText);
    }

    void setPref(Preferences pref) {
        this.pref = pref;
        String result = pref.get("HideIntro", null);
        showIntroMnuItm.setSelected(result.equals("false"));
    }
    
    private void ShowMessageBox(Object message) {
    	JOptionPane.showMessageDialog(ControlPaneContainer.this, message, "البرنامج واجه خطأ", JOptionPane.ERROR_MESSAGE);
    }

}
