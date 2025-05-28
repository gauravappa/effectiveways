package com.example.effectiveways.creatinganddestroyingobjects;

public class StaticHelperMethodExample {

    //In Below Example We have person class if we try to create two constructor using same parameters types
    // compiler won't give us error but if user of this api by mistakenly used another constructor
    // then we sure will get error at runtime due wrong value assigned to wrong parameters
    // in such case instead of using Constructor we can use static methods to create objects
    // advantage of this we can name these static methods, also we can return any subtype of return type mentioned as return type
    // also we can manage creation of object consider if we want to cache objects and return same object if
    //requested then we can easily achieve this by simple checks in this static method.
    // disadvantage of this is as we are making our Person class constructor private we can subclass it
    public static void main(String args[]){
       Person person1 = Person.createPersonByIdandAge("1",15);
       Person person2 = Person.createPersonByNameAndAge("Gaurav",28);

       Animal lion=Animal.getAnimal("Lion");
    }


    private static class Person{
        private String name;
        private String id;
        private int age;
        private Person(String name,String id,int age){
            this.name = name;
            this.id=id;
            this.age=age;
        }

        public static Person createPersonByNameAndAge(String name,int age){
           return new Person(name,"not_assigned",age);
        }
        public static Person createPersonByIdandAge(String id,int age){
            return new Person("Undefined",id,age);
        }
    }

     public static abstract class Animal{
        private Animal(){

        }
        public static Animal getAnimal(String name){
            if(name.equals("Lion"))
                return new Lion();
            else if(name.equals("Tiger"))
                return new Tiger();
            else
                return new Cat();
        }

        public static class Lion extends Animal{
            private Lion(){
                super();
            }


        }
         public static class Tiger extends Animal{
             private Tiger(){
                 super();
             }
         }
         public static class Cat extends Animal{
             private Cat(){
                 super();
             }
         }

     }


}
