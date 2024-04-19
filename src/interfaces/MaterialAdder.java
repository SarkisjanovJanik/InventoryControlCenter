package interfaces;

import model.Material;
import model.Storage;

public interface MaterialAdder extends StorageHandler {

    void add(Storage storage, Material material, int quantity);
}
