package impl;

import model.Material;
import model.Storage;
import interfaces.MaterialRemover;

import java.util.Map;

public class MaterialRemoverImpl implements MaterialRemover {

    private static MaterialRemoverImpl removerImpl;

    private MaterialRemoverImpl() {

    }

    public static MaterialRemoverImpl getRemoverImpl() {
        if (removerImpl == null) {
            removerImpl = new MaterialRemoverImpl();
        }
        return removerImpl;
    }

    @Override
    public void remove(Storage storage, Material material, int quantity) {
        checkQuantityValidation(material, quantity);

        System.out.println("Removing " + material.getName() + " from WareHouse with quantity " + quantity);

        changeMaterialQuantity(storage, material, quantity);

        System.out.println("Material " + material.getName() + " removed from WareHouse successfully");
    }

    @Override
    public void changeMaterialQuantity(Storage storage, Material material, int quantity) {

        Map<Material, Integer> wareHouseMaterials = storage.getMaterialStorage();

        if (wareHouseMaterials.containsKey(material)) {
            int previousQuantity = wareHouseMaterials.get(material);
            int newQuantity = previousQuantity - quantity;

            checkQuantityOutOfCapacity(material, newQuantity);

            wareHouseMaterials.put(material, newQuantity);
        } else {
            throw new IllegalArgumentException("WareHouse does not contain material " + material.getName());
        }
    }
}
