class TenDollarHandler implements DispenseHandler {
    private DispenseHandler nextHandler;
    private int count;

    @Override
    public void setNextHandler(DispenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void dispense(int amount) {
        if (amount >= 10) {
            int num = amount / 10;
            count += num;
            int remainder = amount % 10;
            System.out.println("Dispensing " + num + " $10 bill(s)");
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