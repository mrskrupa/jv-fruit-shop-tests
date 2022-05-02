package core.basesyntax.service.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        if (storageDao.get(fruitTransaction.getFruit()) < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enought fruits");
        }
        storageDao.update(fruitTransaction.getFruit(), -fruitTransaction.getQuantity());
    }
}
