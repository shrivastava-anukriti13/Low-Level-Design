class FiftyDollarHandler implements DispenseHandler {
    private DispenseHandler nextHandler;
    private int count;

    @Override
    public void setNextHandler(DispenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void dispense(int amount) {
        if (amount >= 50) {
            int num = amount / 50;
            count += num;
            int remainder = amount % 50;
            System.out.println("Dispensing " + num + " $50 bill(s)");
            if (remainder != 0 && nextHandler != null) {
                nextHandler.dispense(remainder);
            }
        } else if (nextHandler != null) {
            nextHandler.dispense(amount);
        }
    }

    public int getCount() {
        return count;
    }
}