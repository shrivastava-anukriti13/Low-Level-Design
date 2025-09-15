class OneDollarHandler implements DispenseHandler {
    private int count;

    @Override
    public void setNextHandler(DispenseHandler nextHandler) {
        // This is the last handler in the chain
    }

    @Override
    public void dispense(int amount) {
        if (amount >= 1) {
            count += amount;
            System.out.println("Dispensing " + amount + " $1 bill(s)");
        }
    }

    public int getCount() {
        return count;
    }
}