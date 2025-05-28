package com.example.effectiveways.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Paratha {
    List<String> ingredients = new ArrayList<>();

    private  Paratha(ParathaBuilder<?> builder){
        this.ingredients = builder.ingredients.stream().collect(Collectors.toList());
    }

    public static abstract class ParathaBuilder<T extends ParathaBuilder<T>>{
        List<String> ingredients = new ArrayList<>();
        public ParathaBuilder<T> addIngredient(String ingredient){
            ingredients.add(ingredient);
            return self();
        }
        public abstract T self();

        abstract Paratha build();
    }



    public static class AlloParatha extends  Paratha{
        double weightInGm;
        private AlloParatha(AlloParathaBuilder builder) {
            super(builder);
            this.weightInGm = builder.weightInGm;
        }

        public static class AlloParathaBuilder extends ParathaBuilder<AlloParathaBuilder>{
            double weightInGm;

            public AlloParathaBuilder(double weightInGm){
                this.weightInGm =weightInGm;
            }

            @Override
            public AlloParathaBuilder self() {
                return this;
            }

            @Override
            Paratha build() {
                return new AlloParatha(this);

            }
        }
    }
}
