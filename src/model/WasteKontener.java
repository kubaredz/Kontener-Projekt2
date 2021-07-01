package model;

public class WasteKontener extends Kontener {
    private String typeOfWaste;
    private boolean isDangerous;
    private static String prefix = "WK";

    public WasteKontener(int id, double weight, double width, double height, double length, String productNumber, String color, boolean isPower, String typeOfWaste, boolean isDangerous) {
        super(id, weight, width, height, length, prefix + productNumber, color, isPower);
        this.typeOfWaste = typeOfWaste;
        this.isDangerous = isDangerous;
    }

    public String getTypeOfWaste() {
        return typeOfWaste;
    }

    public void setTypeOfWaste(String typeOfWaste) {
        this.typeOfWaste = typeOfWaste;
    }

    public boolean isDangerous() {
        return isDangerous;
    }

    public void setDangerous(boolean dangerous) {
        isDangerous = dangerous;
    }


    @Override
    public String toString() {
        String tmp = super.toString();
        return "WASTEKONTENER{" +
                tmp +
                "," + typeOfWaste +
                "," + isDangerous +
                '}';
    }

    public String view() {
        String tmp = super.view();
        return "WASTEKONTENER{" +
                tmp +
                "\t" + typeOfWaste +
                "\t" + isDangerous +
                '}';
    }
}
