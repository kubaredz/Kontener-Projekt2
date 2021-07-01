package model;

public class PowderKontener extends Kontener {
    private boolean powderLoader;
    private int loadingHatches;
    private static String prefix = "PK";

    public PowderKontener(int id, double weight, double width, double height, double length, String productNumber, String color, boolean isPower, boolean powderLoader, int loadingHatches) {
        super(id, weight, width, height, length, prefix + productNumber, color, isPower);
        this.powderLoader = powderLoader;
        this.loadingHatches = loadingHatches;
    }

    public boolean isPowderLoader() {
        return powderLoader;
    }

    public void setPowderLoader(boolean powderLoader) {
        this.powderLoader = powderLoader;
    }

    public int getLoadingHatches() {
        return loadingHatches;
    }

    public void setLoadingHatches(int loadingHatches) {
        this.loadingHatches = loadingHatches;
    }

    @Override
    public String toString() {
        String tmp = super.toString();
        return "POWDERKONTENER{" +
                tmp +
                "," + powderLoader +
                "," + loadingHatches +
                '}';
    }

    public String view() {
        String tmp = super.view();
        return "POWDERKONTENER{" +
                tmp +
                "\t" + powderLoader +
                "\t" + loadingHatches +
                '}';
    }
}
