public interface DispenseHandler {
    void setNextHandler(DispenseHandler nextHandler);
    void dispense(int amount);
}