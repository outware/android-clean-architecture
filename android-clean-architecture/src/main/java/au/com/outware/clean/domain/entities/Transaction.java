package au.com.outware.clean.domain.entities;

public class Transaction {

    private static final String SOME_FREE_LOCATION = "Center of town";

    private final int mAmount;
    private final String mLocation;

    public Transaction(int amount, String location) {
        mAmount = amount;
        mLocation = location;
    }

    public boolean isFreeTransaction() {
        return mAmount == 0 || mLocation.equals(SOME_FREE_LOCATION);
    }

}
