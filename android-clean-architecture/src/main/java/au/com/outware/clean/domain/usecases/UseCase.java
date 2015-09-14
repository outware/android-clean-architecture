package au.com.outware.clean.domain.usecases;

/**
 * Represents a generic use case object that exposes an execute method.
 *
 * @author kamalmohamed
 */
public interface UseCase extends Runnable {

    /**
     * Cancels the execution of this piece of business logic.
     */
    void cancel();

}
