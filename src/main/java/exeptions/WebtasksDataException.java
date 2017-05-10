package exeptions;

/**
 * Created by Валера on 20.03.2017.
 */
public class WebtasksDataException extends Exception {

    public WebtasksDataException(String message) {
        super(message);
    }

    public WebtasksDataException(Throwable cause) {
        super(cause);
    }

    public WebtasksDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
