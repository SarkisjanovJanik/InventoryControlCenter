# Inventory Control Center

Inventory Control Center is a Java project designed to manage warehouse operations efficiently. It provides an abstract class `Storage` for creating storage facilities like warehouses and implements methods for material management. The project leverages abstraction to support various storage types, including warehouses, chests, etc.

## Features

- **Abstract Class**: `Storage` serves as a blueprint for creating storage facilities.
- **Material Management**: Implementations for adding, removing, and relocating materials.
- **Validation**: Ensures material quantities are within capacity limits.
- **Singleton Pattern**: Singleton implementations for material adder, remover, and material relocation.
- **Model Classes**: Includes a template class `Material` with attributes like name, description, icon, and max capacity.
- **Warehouse Class**: Extends `Storage` and represents a warehouse with its own material storage.

## Usage

1. **Material Management**: Utilize `MaterialAdderImpl` and `MaterialRemoverImpl` for adding and removing materials.
2. **Material Relocation**: Use `MaterialRelocation` for moving materials between storage facilities.
3. **Model**: Customize material attributes in the `Material` class.
4. **Warehouse Creation**: Extend the `WareHouse` class to create specific storage facilities.

## How to Use

1. Clone the repository to your local machine.
2. Explore and modify classes as needed.
3. Compile and run the project to manage warehouse operations efficiently.

## Contributors

- Janik Sarkisjanov - Developer

---
Ensure optimal material management with Inventory Control Center. Simplify warehouse operations and enhance productivity.

