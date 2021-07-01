package model;

public class TankKontener extends Kontener {
    private boolean isVacuum;
    private String typeOfSubstain;
    private static String prefix = "TK";

    public TankKontener(int id, double weight, double width, double height, double length, String productNumber, String color, boolean isPower, boolean isVacuum, String typeOfSubstain) {
        super(id, weight, width, height, length, prefix + productNumber, color, isPower);
        this.isVacuum = isVacuum;
        this.typeOfSubstain = typeOfSubstain;
    }

    public boolean isVacuum() {
        return isVacuum;
    }

    public void setVacuum(boolean vacuum) {
        isVacuum = vacuum;
    }

    public String getTypeOfSubstain() {
        return typeOfSubstain;
    }

    public void setTypeOfSubstain(String typeOfSubstain) {
        this.typeOfSubstain = typeOfSubstain;
    }

    @Override
    public String toString() {
        String tmp = super.toString();
        return "TANKKONTENER{" +
                tmp +
                "," + isVacuum +
                "," + typeOfSubstain +
                '}';
    }

    public String view() {
        String tmp = super.view();
        return "TANKKONTENER{" +
                tmp +
                "\t" + isVacuum +
                "\t" + typeOfSubstain +
                '}';
    }
}
