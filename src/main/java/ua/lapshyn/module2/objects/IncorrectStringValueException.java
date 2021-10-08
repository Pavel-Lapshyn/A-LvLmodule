package ua.lapshyn.module2.objects;

public class IncorrectStringValueException extends IllegalArgumentException {
    public IncorrectStringValueException(String mes) {
        super(mes);
    }
}
