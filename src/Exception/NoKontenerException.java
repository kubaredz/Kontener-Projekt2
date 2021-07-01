package Exception;

public class NoKontenerException extends RuntimeException {

    public NoKontenerException(Enum kontenerType) {
        super("No kontener type.." + kontenerType);
    }
}
