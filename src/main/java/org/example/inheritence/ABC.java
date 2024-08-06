package org.example.inheritence;

public class ABC {
    public static void main(String[] args) {
        C c = new C();

    }
}
class A{
     A(){
        System.out.println("A");
    }
}
class B extends A{
   // B(){
   //     System.out.println("B");
   // }
    B(String s){
        System.out.println(" 1st const" +s);
    }
    B(int i){
        System.out.println("B"+i);
    }
}
class C extends B{
     C(){
         super("from C");
        //super(1);
         System.out.println("C");
    }
}