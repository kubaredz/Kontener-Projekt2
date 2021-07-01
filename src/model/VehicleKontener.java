package model;

public class VehicleKontener extends Kontener{
    private int countCars;
    private boolean isSecret;
    private static String prefix = "VK";

    public VehicleKontener(int id, double weight, double width, double height, double length, String productNumber, String color, boolean isPower, int countCars, boolean isSecret) {
        super(id, weight, width, height, length, prefix+productNumber, color, isPower);
        this.countCars = countCars;
        this.isSecret = isSecret;
    }

    public int getCountCars() {
        return countCars;
    }

    public void setCountCars(int countCars) {
        this.countCars = countCars;
    }

    public boolean isSecret() {
        return isSecret;
    }

    public void setSecret(boolean secret) {
        isSecret = secret;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static void setPrefix(String prefix) {
        VehicleKontener.prefix = prefix;
    }

    @Override
    public String toString() {
        String tmp = super.toString();
        return "VEHICLEKONTENER{" +
                tmp +
                "," + countCars +
                "," + isSecret +
                '}';
    }

    public String view() {
        String tmp = super.view();
        return "VEHICLEKONTENER{" +
                tmp +
                "\t" + countCars +
                "\t" + isSecret +
                '}';
    }
}
