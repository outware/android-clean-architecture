package au.com.outware.clean.domain.repositories;

import java.util.List;

import au.com.outware.clean.domain.entities.DomainError;
import au.com.outware.clean.domain.entities.Transaction;

public interface TransactionRepository {

    void getTransactionList(GetTransactionListCallback callback);

    void unregisterGetTransactionListCallback(GetTransactionListCallback callback);

    interface GetTransactionListCallback {

        void onGetTransactionListSuccess(List<Transaction> transactionList);

        void onGetTransactionListError(DomainError error);

    }

}
