package com.example.effectiveways.builder;

public class Laptop {
    private final String name;
    private final String model;
    private final double price;
    private Laptop(String name,String model, double price){
        this.name = name;
        this.model = model;
        this.price = price;
    }

    public String getName(){
        return name;
    }
    public String getModel(){
        return model;
    }
    public double getPrice() {
        return price;
    }

    public static class LaptopBuilder{
        String name;
        String model;
        double price;
        public LaptopBuilder withName(String name){
            this.name = name;
            return this;
        }
        public LaptopBuilder withModel(String model){
            this.model = model;
            return this;
        }

        public LaptopBuilder withPrice(double price){
            this.price = price;
            return this;
        }

        public Laptop build(){
            if(name!=null&&model!=null&&price>0){
                return new Laptop(name,model,price);
            }else{
                throw new IllegalArgumentException();
            }
        }
    }
}
