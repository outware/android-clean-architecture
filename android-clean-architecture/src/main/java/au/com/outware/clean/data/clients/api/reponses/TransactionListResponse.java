package au.com.outware.clean.data.clients.api.reponses;

import java.util.List;

public class TransactionListResponse {

    public int userId;

    public List<TransactionResponse> transactionResponseList;

    public class TransactionResponse {

        public int amount;

        public int locationId;

    }

}
