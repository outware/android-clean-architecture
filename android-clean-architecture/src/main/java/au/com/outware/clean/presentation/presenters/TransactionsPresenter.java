package au.com.outware.clean.presentation.presenters;

import java.util.List;

import au.com.outware.clean.domain.entities.DomainError;
import au.com.outware.clean.domain.entities.Transaction;
import au.com.outware.clean.domain.repositories.AccountRepository;
import au.com.outware.clean.domain.repositories.TransactionRepository;
import au.com.outware.clean.domain.usecases.ViewMyTransactionsUseCase;
import au.com.outware.clean.presentation.system.ResourcesSurface;
import au.com.outware.clean.presentation.system.VibrationSurface;
import au.gov.nsw.transport.ocra.R;

public class TransactionsPresenter extends BasePresenter implements
        ViewMyTransactionsUseCase.Callback {

    private final ViewSurface mViewSurface;
    private final ViewMyTransactionsUseCase mViewMyTransactionsUseCase;
    private final ResourcesSurface mResourcesSurface;
    private final VibrationSurface mVibrationSurface;

    public TransactionsPresenter(ViewSurface viewSurface,
                                 TransactionRepository transactionRepository,
                                 AccountRepository accountRepository,
                                 ResourcesSurface resourcesSurface,
                                 VibrationSurface vibrationSurface) {
        mViewSurface = viewSurface;
        mResourcesSurface = resourcesSurface;
        mVibrationSurface = vibrationSurface;
        mViewMyTransactionsUseCase =
                new ViewMyTransactionsUseCase(this, transactionRepository, accountRepository);
    }

    @Override
    public void onResume() {
        mViewMyTransactionsUseCase.run();
    }

    @Override
    public void onDestroy() {
        mViewMyTransactionsUseCase.cancel();
    }

    public void onTransactionItemClicked(Transaction transaction) {
        mViewSurface.navigateToTransactionDetailScreen(transaction);
    }

    @Override
    public void presentTransactions(List<Transaction> transactionList) {
        mViewSurface.updateTransactionsList(transactionList);
    }

    @Override
    public void promptUserToSignIn() {
        mViewSurface.showSignInPrompt();
        try {
            mVibrationSurface.vibrate(1000);
        } catch (UnsupportedOperationException ex) {
            // Do nothing
        }
    }

    @Override
    public void presentGenericError(DomainError error) {
        mViewSurface.showError(mResourcesSurface.getString(R.string.error_message)
                + error.toString());
    }

    public interface ViewSurface {

        void navigateToTransactionDetailScreen(Transaction transaction);

        void updateTransactionsList(List<Transaction> transactionList);

        void showSignInPrompt();

        void showError(String errorMessage);

    }

}
