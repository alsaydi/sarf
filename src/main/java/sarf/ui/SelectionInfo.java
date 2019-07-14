package sarf.ui;

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
public class SelectionInfo {

    public boolean trilateral;
    private boolean augmented;
    private boolean active;
    private int kov;

    private Object root;

    private int augmentationFormulaNo;

    private String formulaText;
    private String verbText;

    public SelectionInfo(Object root, boolean trilateral, boolean augmented, int kov) {
        this.root = root;
        this.trilateral = trilateral;
        this.augmented = augmented;
        this.kov = kov;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isTrilateral() {
        return trilateral;
    }

    public boolean isAugmented() {
        return augmented;
    }

    public Object getRoot() {
        return root;
    }

    public int getAugmentationFormulaNo() {
        return augmentationFormulaNo;
    }

    public String getFormulaText() {
        return formulaText;
    }

    public String getVerbText() {
        return verbText;
    }

    public int getKov() {
        return kov;
    }

    public void setTrilateral(boolean trilateral) {
        this.trilateral = trilateral;
    }

    public void setAugmented(boolean augmented) {
        this.augmented = augmented;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRoot(Object root) {
        this.root = root;
    }

    public void setAugmentationFormulaNo(int augmentationFormulaNo) {
        this.augmentationFormulaNo = augmentationFormulaNo;
    }

    public void setVerbText(String verbText) {
        this.verbText = verbText;
    }

    public void setFormulaText(String formulaText) {
        this.formulaText = formulaText;
    }
}
