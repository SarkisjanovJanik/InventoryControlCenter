package impl;

import model.Material;
import model.Storage;
import interfaces.MaterialAdder;

import java.util.Map;

public class MaterialAdderImpl implements MaterialAdder {

    private static MaterialAdderImpl adderImpl;

    private MaterialAdderImpl() {

    }

    public static MaterialAdderImpl getAdderImpl() {
        if (adderImpl == null) {
            adderImpl = new MaterialAdderImpl();
        }
        return adderImpl;
    }

    @Override
    public void add(Storage storage, Material material, int quantity) {
        checkQuantityValidation(material, quantity);

        System.out.println("Adding " + material.getName() + " to WareHouse with quantity " + quantity);

        changeMaterialQuantity(storage, material, quantity);

        System.out.println("Material " + material.getName() + " added to WareHouse successfully");
    }

    @Override
    public void changeMaterialQuantity(Storage storage, Material material, int quantity) {
        Map<Material, Integer> wareHouseMaterials = storage.getMaterialStorage();

        if (wareHouseMaterials.containsKey(material)) {
            int previousQuantity = wareHouseMaterials.get(material);
            int newQuantity = previousQuantity + quantity;

            checkQuantityOutOfCapacity(material, newQuantity);

            wareHouseMaterials.put(material, newQuantity);
        } else {
            System.out.println("\u001B[31m ERROR: WareHouse does not contain material: \u001B[0m" + material.getName());

            wareHouseMaterials.put(material, quantity);
            System.out.println("Added not existed material " + material.getName() + " to WareHouse with quantity " + quantity);
        }
    }
}