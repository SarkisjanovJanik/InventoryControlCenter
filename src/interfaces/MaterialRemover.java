package interfaces;

import model.Material;
import model.Storage;

public interface MaterialRemover extends StorageHandler {

    void remove(Storage storage, Material material, int quantity);
}
