package au.com.outware.clean.data.clients.api;

import java.util.List;

import au.com.outware.clean.domain.entities.Transaction;

public class ApiClient {

    // Interacts with a singleton API connection

    public ApiClient() {
        // Instantiate API connection
    }

    public void getTransactionList(RequestTransactionListCallback callback) {
        // Fire request
    }

    public interface RequestTransactionListCallback {

        void onSuccess(List<Transaction> transactionList);

        void onError();

    }

}
