package model;

public class WeaponKontener extends Kontener {
    private String typeOfPermissionToOpen;
    private boolean isSecret;
    private static String prefix = "WEK";

    public WeaponKontener(int id, double weight, double width, double height, double length, String productNumber, String color, boolean isPower, String typeOfPermissionToOpen, boolean isSecret) {
        super(id, weight, width, height, length, prefix+productNumber, color, isPower);
        this.typeOfPermissionToOpen = typeOfPermissionToOpen;
        this.isSecret = isSecret;
    }

    public String getTypeOfPermissionToOpen() {
        return typeOfPermissionToOpen;
    }

    public void setTypeOfPermissionToOpen(String typeOfPermissionToOpen) {
        this.typeOfPermissionToOpen = typeOfPermissionToOpen;
    }

    public boolean isSecret() {
        return isSecret;
    }

    public void setSecret(boolean secret) {
        isSecret = secret;
    }


    @Override
    public String toString() {
        String tmp = super.toString();
        return "WEAPONKONTENER{" +
                tmp +
                "," + typeOfPermissionToOpen +
                "," + isSecret + '}';
    }

    public String view() {
        String tmp = super.view() + "STARE ID: " + getId();
        return "WEAPONKONTENER{" +
                tmp +
                "\t" + typeOfPermissionToOpen +
                "\t" + isSecret + '}';
    }
}
