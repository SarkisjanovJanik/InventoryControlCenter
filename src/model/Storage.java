package model;

import java.util.Map;

/**
 * This abstract class defines a generic storage structure for materials.
 * It encapsulates a map of materials and their respective quantities.
 * The purpose of this abstract class is to provide blueprint for various types of storage facilities
 * that may handle materials differently but share common functionality,
 * it enables scalability and flexibility in designing different storage implementations.
 **/
public abstract class Storage {

    Map<Material, Integer> materialStorage;

    public Map<Material, Integer> getMaterialStorage() {
        return materialStorage;
    }

    public int getExistingQuantity(Material material) {
        if (materialStorage.containsKey(material)) {
            return materialStorage.get(material);
        } else {
            System.out.println("\u001B[31m ERROR: Storage does not contain material \u001B[0m");
            return 0;
        }
    }

    public void fetchStorageData() {
        System.out.println("Material | Quantity");
        materialStorage.forEach((materialType, quantity) -> {
            System.out.println(materialType.getName() + " | " + quantity);
        });
    }
}

