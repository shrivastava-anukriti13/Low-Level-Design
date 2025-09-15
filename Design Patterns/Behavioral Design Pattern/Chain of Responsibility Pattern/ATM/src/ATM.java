// ATM class using Chain of Responsibility
class ATM {
    private DispenseHandler chain;
    private int balance;

    public ATM(int initialBalance) {
        this.balance = initialBalance;
        setupDispenseChain();
    }

    private void setupDispenseChain() {
        // Create the handlers
        FiftyDollarHandler fiftyHandler = new FiftyDollarHandler();
        TwentyDollarHandler twentyHandler = new TwentyDollarHandler();
        TenDollarHandler tenHandler = new TenDollarHandler();
        FiveDollarHandler fiveHandler = new FiveDollarHandler();
        OneDollarHandler oneHandler = new OneDollarHandler();

        // Set up the chain
        fiftyHandler.setNextHandler(twentyHandler);
        twentyHandler.setNextHandler(tenHandler);
        tenHandler.setNextHandler(fiveHandler);
        fiveHandler.setNextHandler(oneHandler);

        // Set the starting point of the chain
        chain = fiftyHandler;
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        System.out.println("Dispensing $" + amount + ":");
        chain.dispense(amount);
        balance -= amount;
        System.out.println("Remaining balance: $" + balance);
    }

    public int getBalance() {
        return balance;
    }
}