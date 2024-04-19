package interfaces;

import model.Material;
import model.Storage;

public interface StorageHandler {

    void changeMaterialQuantity(Storage storage, Material material, int quantity);

    default void checkQuantityValidation(Material material, int quantity) {
        boolean capacityExceeded = material.getMaxCapacity() < quantity;

        boolean quantityIsNegative = quantity <= 0;

        if (quantityIsNegative) {
            throw new IllegalArgumentException("Quantity must be greater than zero" );
        }

        if (capacityExceeded) {
            throw new IllegalArgumentException("Capacity is exceeded,allowed capacity size : " + material.getMaxCapacity());
        }
    }

    default void checkQuantityOutOfCapacity(Material selectedMaterial, int newQuantity) {
        boolean isOutOfLimit = selectedMaterial.getMaxCapacity() < newQuantity || newQuantity < 0;

        if (isOutOfLimit) {
            throw new IllegalArgumentException("Capacity size is exceeded");
        }
    }
}
