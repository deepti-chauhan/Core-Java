class parent{

    int val = 5;
    parent(){
        System.out.println("this is parent class constructor");
    }

    void fun(){
        System.out.println("this is parent class function");
    }
}

class child extends parent{

    int val = 10;
    child(){
        System.out.println("this is child class constructor");
    }

    @Override
    void fun(){
        System.out.println("this is child class function");
    }
}

public class Polymorphism {

    public static void main(String[] args){

        child c = new child();
        c.fun();
        System.out.println(c.val);
      
        /*
        OUTPUT :-
          this is parent class constructor
          this is child class constructor
          this is child class function
          10
        */

        parent p = new parent();
        p.fun();
        System.out.println(p.val);
      
      /*
          this is parent class constructor
          this is parent class function
          5
      */

        parent myChild = new child();
        myChild.fun();
        System.out.println(myChild.val);
      
      /*
          this is parent class constructor
          this is child class constructor
          this is child class function
          5
      */
      
       /*
          child obj = new parent();
          this will give compilation error but we can parent class can use few members of its child class through downcasting.
          child obj = (child) new parent(); this will not give compilation error but not very useful.
       */

    }
}
