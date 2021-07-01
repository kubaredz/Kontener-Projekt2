package file;

public enum KontenerType {
    DEFAULTKONTENER,
    VEHICLEKONTENER,
    FREEZERKONTENER,
    HERMETICKONTENER,
    POWDERKONTENER,
    TANKKONTENER,
    WASTEKONTENER,
    WEAPONKONTENER;

    public static KontenerType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }



}
