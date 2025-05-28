package com.example.effectiveways.singleton;

import javax.xml.crypto.Data;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;

public class SingletonExample {

    public static void main(String[] args) {
        //As we know there are many ways to create singleton by using static object creation
        // another one is by using double locking to ensure thread saftey you might have read about it
        // but there are caveat in these approached also we will discuss those in these example

        //consider below DatabasePool class . as we can see it is singleton
        // as constructor is private and object is getting created at the time of class loading into memory as it
        // is static field but here also has a caveat we can use reflection to make constructor accessible
        //see below

        Class<DatabasePool> dbPoolClass = DatabasePool.class;
        Constructor<?>[] declaredConstructors = dbPoolClass.getDeclaredConstructors();
        declaredConstructors[0].setAccessible(true);
        //or
        AccessibleObject.setAccessible(new AccessibleObject[]{declaredConstructors[0]},true);
       DatabasePool dbPool1=  new DatabasePool();
       DatabasePool dbPool2 = new DatabasePool();
        System.out.println("dbPool1 = "+dbPool1+" dbPool2 = "+dbPool2);
       //as you can see we are able to create multiple db pool instance
        //we can fix this by throwing exception from DatbasePool Constructor if one object is already present then
        // throw exception this is workaround here

        // another caveat is if you serialize your singleton class and again try to deserialize it
        // then it will create new instance
        // for this to fix we have to create all fields transient and public Object ReadResolve(){ return exisitingInstance;}
        // serialization process will use this method for deserialzing
    }



    public static class DatabasePool{
        private static final DatabasePool dbPool = new DatabasePool();
        public DatabasePool getInstance(){
            return dbPool;
        }
        private DatabasePool(){

        }
    }
}
