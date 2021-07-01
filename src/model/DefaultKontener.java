package model;

public class DefaultKontener extends Kontener {
    private String typeOfProduct;
    private static String prefix = "DK";

    public DefaultKontener(int id, double weight, double width, double height, double length, String productNumber, String color, boolean isPower, String typeOfProduct) {
        super(id, weight, width, height, length, prefix + productNumber, color, isPower);
        this.typeOfProduct = typeOfProduct;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    @Override
    public String toString() {
        String tmp = super.toString();
        return "DEFAULTKONTENER{" +
                tmp +
                "," + typeOfProduct +
                '}';
    }

    public String view(){
        String tmp = super.view();
        return "DEFAULTKONTENER{" +
                tmp +
                "\t" + typeOfProduct +
                '}';
    }
}
