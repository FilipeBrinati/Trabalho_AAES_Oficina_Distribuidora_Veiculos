package FactoryMethod;


public class Sedan implements Carro {
    @Override
    public String getModelo() {
        return "Sedan";
    }
}