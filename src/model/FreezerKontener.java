package model;

public class FreezerKontener extends Kontener {
    private String typeOfFood;
    private double temperature;
    private boolean isCooling;
    private static String prefix = "FK";


    public FreezerKontener(int id, double weight, double width, double height, double length, String productNumber, String color, boolean isPower, String typeOfFood, double temperature, boolean isCooling) {
        super(id, weight, width, height, length, prefix+productNumber, color, isPower);
        this.typeOfFood = typeOfFood;
        this.temperature = temperature;
        this.isCooling = isCooling;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isCooling() {
        return isCooling;
    }

    public void setCooling(boolean cooling) {
        isCooling = cooling;
    }

    @Override
    public String toString() {
        String tmp = super.toString();
        return "FREEZERKONTENER{" +
                tmp +
                "," + typeOfFood +
                "," + temperature +
                "," + isCooling +
                '}';
    }

    public String view(){
        String tmp = super.view();
        return "FREEZERKONTENER{" +
                tmp +
                "\t" + typeOfFood +
                "\t" + temperature +
                "\t" + isCooling +
                '}';
    }
}

