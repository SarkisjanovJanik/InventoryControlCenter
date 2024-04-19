import impl.MaterialAdderImpl;
import impl.MaterialRemoverImpl;
import interfaces.MaterialAdder;
import interfaces.MaterialRemover;
import model.Material;
import model.Storage;
import model.WareHouse;
import utility.MaterialRelocation;

public class Main {
    public static void main(String[] args) {

        Material iron = new Material("Iron", "Strong metal material", "images/iron.png", 1000);
        Material wood = new Material("Wood", "Natural material derived from trees", "images/wood.png", 5000);
        Material plastic = new Material("Plastic", "Synthetic material", "images/plastic.png", 2800);

        MaterialAdder materialAdder = MaterialAdderImpl.getAdderImpl();
        MaterialRemover materialRemover = MaterialRemoverImpl.getRemoverImpl();
        MaterialRelocation materialRelocation = MaterialRelocation.getMaterialRelocation();

        Storage wareHouse1 = new WareHouse();
        Storage wareHouse2 = new WareHouse();


        materialAdder.add(wareHouse1, iron, 200);
        materialAdder.add(wareHouse1, wood, 2100);
        materialAdder.add(wareHouse2, plastic, 1200);
        materialAdder.add(wareHouse2, plastic, 1200);
        materialAdder.add(wareHouse2, wood, 100);

        materialRemover.remove(wareHouse1, iron, 75);
        materialRemover.remove(wareHouse1, wood, 1050);
        materialRemover.remove(wareHouse2, plastic, 200);
        materialRemover.remove(wareHouse2, plastic, 400);

        materialRelocation.move(wareHouse1, wareHouse2, iron, 20);
        materialRelocation.move(wareHouse2, wareHouse1, wood, 30);
        materialRelocation.move(wareHouse2, wareHouse1, plastic, 400);

        wareHouse1.fetchStorageData();
        wareHouse2.fetchStorageData();

    }
}