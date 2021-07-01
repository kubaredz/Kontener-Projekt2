package model;

public class HermeticKontener extends Kontener {
    private double nitrogenConcetration;
    private static String prefix = "HK";

    public HermeticKontener(int id, double weight, double width, double height, double length, String productNumber, String color, boolean isPower, double nitrogenConcetration) {
        super(id, weight, width, height, length, prefix+productNumber, color, isPower);
        this.nitrogenConcetration = nitrogenConcetration;
    }

    public double getNitrogenConcetration() {
        return nitrogenConcetration;
    }

    public void setNitrogenConcetration(double nitrogenConcetration) {
        this.nitrogenConcetration = nitrogenConcetration;
    }

    @Override
    public String toString() {
        String tmp = super.toString();
        return "HERMETICKONTENER{" +
                tmp +
                "," + nitrogenConcetration +
                '}';
    }

    public String view(){
        String tmp = super.view();
        return "HERMETICKONTENER{" +
                tmp +
                "\t" + nitrogenConcetration +
                '}';
    }
}