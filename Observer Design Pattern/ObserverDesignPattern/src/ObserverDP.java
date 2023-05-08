import java.util.ArrayList;

interface Subscriber{
    void Update();
}
class Person implements Subscriber{
    private String Name;
    Person(String N){
        this.Name=N;
    }
    public String GetName(){
        return this.Name;
    }
    @Override
    public void Update() {
        System.out.println("Hello "+Name+" Product Is Now in Stock");
    }
}
interface Publisher{
    void Subscribe(Subscriber S);
    void UnSubscribe(Subscriber S);
    void Notify();
}
class WhiteShirt implements Publisher{
    private ArrayList<Subscriber>AllSubscribers=new ArrayList<Subscriber>();
    private boolean InStock=false;

    public boolean IsInStock(){
        return InStock;
    }
    public void SetInStock(boolean In){
        this.InStock=In;
        Notify();
    }
    @Override
    public void Subscribe(Subscriber S) {
        AllSubscribers.add(S);
    }

    @Override
    public void UnSubscribe(Subscriber S) {
        AllSubscribers.remove(S);
    }
    @Override
    public void Notify() {
        System.out.println("Notifying All the Subscribers of WhiteShirt");
        for (Subscriber S:AllSubscribers){
            S.Update();
        }
    }
}
public class ObserverDP {
    public static void main(String args[]){
        Person Ahmad=new Person("Ahmad");
        Person Bilal=new Person("Bilal");

        WhiteShirt WS=new WhiteShirt();
        WS.Subscribe(Ahmad);
        WS.Subscribe(Bilal);
        WS.Notify();
        System.out.println("==============");
        WS.UnSubscribe(Ahmad);
        WS.Notify();
    }
}
