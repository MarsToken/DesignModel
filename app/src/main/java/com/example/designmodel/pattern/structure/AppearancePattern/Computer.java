package com.example.designmodel.pattern.structure.AppearancePattern;

/**
 * Created by hp on 2020/3/13.
 */
public class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.disk = new Disk();
    }

    public void startUp() {
        cpu.startUp();
        memory.startUp();
        disk.startUp();
    }

    public void shutDown() {
        cpu.shutDown();
        memory.shutDown();
        disk.shutDown();
    }
}
