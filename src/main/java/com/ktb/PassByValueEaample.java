package com.ktb;

import com.ktb.mode.Dog;

public class PassByValueEaample {

    public static void main(String[] args) {
       Dog dog = new Dog("A");
       changeDog(dog);
       System.out.println(dog.getName());//A Not B
      // detail https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
    }
    private static  void changeDog(Dog dog){
        dog = new Dog("B");
    }
}
