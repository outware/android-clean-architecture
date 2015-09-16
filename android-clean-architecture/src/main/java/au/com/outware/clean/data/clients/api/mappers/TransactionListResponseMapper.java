package au.com.outware.clean.data.clients.api.mappers;

import java.util.ArrayList;
import java.util.List;

import au.com.outware.clean.data.clients.api.reponses.TransactionListResponse;
import au.com.outware.clean.data.clients.api.reponses.TransactionListResponse.TransactionResponse;
import au.com.outware.clean.domain.entities.Transaction;

public final class TransactionListResponseMapper {

    private TransactionListResponseMapper() {}

    public List<Transaction> mapTransactionListResponse(TransactionListResponse listResponse) {
        List<Transaction> transactions = new ArrayList<>();
        for (TransactionResponse response : listResponse.transactionResponseList) {
            transactions.add(mapTransactionResponse(response));
        }
        return transactions;
    }

    public Transaction mapTransactionResponse(TransactionResponse response) {
        String location;
        switch (response.locationId) {
        case 0:
            location = "Central Avenue";
            break;
        case 1:
            location = "Sideshow Lane";
            break;
        default:
            location = "";
            break;
        }
        return new Transaction(response.amount, location);
    }

}
