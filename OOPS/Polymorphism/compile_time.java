class sample{
    sample(){
        System.out.println("this is sample class");
    }

    void func(String s){
        System.out.println(s);
    }

    void func(int i){
        System.out.println(i);
    }
}

public class Polymorphism {

    public static void main(String[] args){

        sample obj = new sample();
        obj.func(5);
        obj.func("apple");
    }
}
