interface Duck{
    void Quack();
    void Fly();
}
interface Turkey{
    void Gobble();
    void Fly();
}
class MallardDuck implements Duck {
    public void Quack(){
        System.out.println("Duck Doing Quack Quack");
    }
    public void Fly(){
        System.out.println("Duck Doing Fly Fly");
    }
}
class WildTurkey implements Turkey{
    public void Gobble(){
        System.out.println("Turkey Doing Gobble Gobble");
    }
    public void Fly(){
        System.out.println("Turkey Doing Fly Fly");
    }
}
class AdapterForTurkey implements Duck {
    Turkey Trk; //Object Adapter
    AdapterForTurkey(Turkey T1){
        this.Trk=T1;
    }
    public void Quack(){
        Trk.Gobble();
    }
    public void Fly(){
        int I;
        for(I=0 ; I<5 ; I++)
            Trk.Fly();
    }
}
public class AdapterDesignPattern {
    public static void main(String args[]){
        Duck D1=new MallardDuck();
        D1.Quack();
        D1.Fly();
        System.out.println("==================");

        Turkey T1=new WildTurkey();
        T1.Gobble();
        T1.Fly();
        System.out.println("==================");

        AdapterForTurkey AFT=new AdapterForTurkey(T1);
        AFT.Quack();
        AFT.Fly();
        System.out.println("==================");
    }
}

//This is ADP Implemented With Object Adapter, Because Class Adapter is not Supported
//By Java Due to Multiple Inheritance
