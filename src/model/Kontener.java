package model;

public class Kontener {
    protected int id;
    protected double weight;
    protected double width;
    protected double height;
    protected double length;
    protected String productNumber;
    protected String color;
    protected boolean isPower;

    public Kontener(int id, double weight, double width, double height, double length, String productNumber, String color, boolean isPower) {
        this.id = id;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.length = length;
        this.productNumber = productNumber;
        this.color = color;
        this.isPower = isPower;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return id +
                "," + weight +
                "," + width +
                "," + height +
                "," + length +
                "," + productNumber +
                "," + color  +
                "," + isPower;
    }

    public String view(){
        return id +
                "\t" + weight +
                "\t" + width +
                "\t" + height +
                "\t" + length +
                "\t" + productNumber +
                "\t" + color  +
                "\t" + isPower;
    }
}
