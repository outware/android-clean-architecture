package au.com.outware.clean.domain.usecases;

import java.util.List;

import au.com.outware.clean.domain.entities.Achievement;
import au.com.outware.clean.domain.entities.DomainError;
import au.com.outware.clean.domain.entities.Transaction;
import au.com.outware.clean.domain.repositories.AccountRepository;
import au.com.outware.clean.domain.repositories.TransactionRepository;
import au.com.outware.clean.domain.repositories.TransactionRepository.GetTransactionListCallback;

public class ViewMyTransactionsUseCase implements UseCase, GetTransactionListCallback {

    private final Callback mCallback;
    private final TransactionRepository mTransactionRepository;
    private final AccountRepository mAccountRepository;

    public ViewMyTransactionsUseCase(Callback callback,
                                     TransactionRepository transactionRepository,
                                     AccountRepository accountRepository) {
        mCallback = callback;
        mTransactionRepository = transactionRepository;
        mAccountRepository = accountRepository;
    }

    @Override
    public void run() {
        if (mAccountRepository.isUserSignedIn()) {
            mTransactionRepository.getTransactionList(this);
        } else {
            mCallback.promptUserToSignIn();
        }
    }

    @Override
    public void cancel() {
        mTransactionRepository.unregisterGetTransactionListCallback(this);
    }

    @Override
    public void onGetTransactionListSuccess(List<Transaction> transactionList) {
        mCallback.presentTransactions(transactionList);
        int freeTransactionCount = 0;
        for (Transaction transaction : transactionList) {
            if (transaction.isFreeTransaction()) {
                freeTransactionCount++;
            }
        }
        if (freeTransactionCount >= 10) {
            mAccountRepository.grantAchievement(Achievement.TEN_FREE_TRANSACTIONS);
        }
    }

    @Override
    public void onGetTransactionListError(DomainError error) {
        if (error == DomainError.UNAUTHORISED) {
            mCallback.promptUserToSignIn();
        } else {
            mCallback.presentGenericError(error);
        }
    }

    public interface Callback {

        void presentTransactions(List<Transaction> transactionList);

        void promptUserToSignIn();

        void presentGenericError(DomainError error);

    }

}
