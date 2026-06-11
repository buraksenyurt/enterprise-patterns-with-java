package DesignPatterns.Creational.Structural.CommandSimple;

// Command arayüzü
public interface SmartHomeCommand {
    void execute();
    void undo();
}
