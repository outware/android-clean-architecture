package au.com.outware.clean.data.managers;

import java.util.ArrayList;
import java.util.List;

import au.com.outware.clean.data.clients.api.ApiClient;
import au.com.outware.clean.data.clients.api.ApiClient.RequestTransactionListCallback;
import au.com.outware.clean.domain.entities.DomainError;
import au.com.outware.clean.domain.entities.Transaction;
import au.com.outware.clean.domain.repositories.TransactionRepository;

public class TransactionsManager implements TransactionRepository, RequestTransactionListCallback {

    private final ApiClient mApiClient;
    private final List<GetTransactionListCallback> callbacks = new ArrayList<>();

    private boolean mRequestInProgress;

    public TransactionsManager(ApiClient apiClient) {
        mApiClient = apiClient;
    }

    @Override
    public void getTransactionList(GetTransactionListCallback callback) {
        callbacks.add(callback);
        if (!mRequestInProgress) {
            mApiClient.getTransactionList(this);
        }
    }

    @Override
    public void unregisterGetTransactionListCallback(GetTransactionListCallback callback) {
        callbacks.remove(callback);
    }

    @Override
    public void onSuccess(List<Transaction> transactionList) {
        for (GetTransactionListCallback callback : callbacks) {
            callback.onGetTransactionListSuccess(transactionList);
        }
    }

    @Override
    public void onError() {
        for (GetTransactionListCallback callback : callbacks) {
            callback.onGetTransactionListError(DomainError.API_FAILURE);
        }
    }
}
