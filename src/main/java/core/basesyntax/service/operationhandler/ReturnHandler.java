package core.basesyntax.service.operationhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {

    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {
        Integer currentQuantity = Storage.fruits.get(transaction.getFruit());
        if (currentQuantity != null && currentQuantity >= transaction.getQuantity()) {
            Storage.fruits.put(transaction.getFruit(), currentQuantity + transaction.getQuantity());
        } else {
            System.out.println("Not enough quantity returned for " + transaction.getFruit());
        }
    }
}
