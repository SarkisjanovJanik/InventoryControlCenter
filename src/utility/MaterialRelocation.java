package utility;

import model.Material;
import model.Storage;
import impl.MaterialAdderImpl;
import impl.MaterialRemoverImpl;

public class MaterialRelocation {

    private static MaterialRelocation materialRelocation;
    private static final MaterialAdderImpl adder = MaterialAdderImpl.getAdderImpl();
    private static final MaterialRemoverImpl remover = MaterialRemoverImpl.getRemoverImpl();

    private MaterialRelocation() {

    }

    public static MaterialRelocation getMaterialRelocation() {
        if (materialRelocation == null) {
            materialRelocation = new MaterialRelocation();
        }
        return materialRelocation;
    }

    public void move(Storage sender, Storage target, Material material, int quantity) {
        int senderQuantity = sender.getExistingQuantity(material);
        int targetQuantity = target.getExistingQuantity(material);
        int maxCapacity = material.getMaxCapacity();

        System.out.println("Starting to move:" + material.getName() + " with quantity:" + quantity);
        if (senderQuantity < quantity) {
            throw new IllegalStateException("Warehouse doesn't have enough material");
        }

        int totalTargetQuantity = targetQuantity + quantity;

        if (totalTargetQuantity < maxCapacity) {
            remover.remove(sender, material, quantity);
            adder.add(target, material, quantity);
        } else {
            int availableSpace = maxCapacity - targetQuantity;

            remover.remove(sender, material, availableSpace);
            System.out.println("\u001B[31mERROR: There is no enough space, so the allowed amount will be moved.Allowed quantity:\u001B[0m" + availableSpace);
            adder.add(target, material, availableSpace);
        }
        System.out.println("The move was completed successfully");
    }
}
