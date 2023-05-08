import javax.lang.model.type.NullType;
import java.util.*;

interface Phone{
    String Model="";
    String Brand="";
    String Body="";

    void Print();
}
class Iphone12 implements Phone {
    String Model="IPhone 12";
    String Brand="IPhone";
    String Body="Metallic";

    public void Print(){
        System.out.println("Model : " + Model);
        System.out.println("Brand : " + Brand);
        System.out.println("Body  : " + Body);
        System.out.println("=================");
    }
}
class Iphone13 implements Phone {
    String Model="IPhone 13";
    String Brand="IPhone";
    String Body="Metallic";

    public void Print(){
        System.out.println("Model : " + Model);
        System.out.println("Brand : " + Brand);
        System.out.println("Body  : " + Body);
        System.out.println("=================");
    }
}
class OnePlus1 implements Phone {
    String Model="One Plus +1";
    String Brand="One Plus";
    String Body="Metallic";

    public void Print(){
        System.out.println("Model : " + Model);
        System.out.println("Brand : " + Brand);
        System.out.println("Body  : " + Body);
        System.out.println("=================");

    }
}
class OnePlus2 implements Phone {
    String Model="One Plus +2";
    String Brand="One Plus";
    String Body="Metallic";

    public void Print(){
        System.out.println("Model : " + Model);
        System.out.println("Brand : " + Brand);
        System.out.println("Body  : " + Body);
        System.out.println("=================");
    }
}
interface PhoneSection{
    Phone First();
    Phone Second();
}
class IPhoneFactory implements PhoneSection{
    public Phone First(){ return new Iphone12();}
    public Phone Second(){ return new Iphone13();}
}
class OnePlusFactory implements PhoneSection{
    public Phone First(){ return new OnePlus1();}
    public Phone Second(){ return new OnePlus2();}
}
class PhoneStore{
    public static PhoneSection CreatePhone(int Ch){
        if(Ch==1){
            return new IPhoneFactory();
        }
        if(Ch==2){
            return new OnePlusFactory();
        }
        return null;
    }
}
public class Example {
    public static void main(String[] args) {
        System.out.println("Press 1) For All IPhones");
        System.out.println("Press 2) For All OnePlus");
        System.out.println("========================");
        System.out.print("Choice >>");
        Scanner sc = new Scanner(System.in);
        int Ch = sc.nextInt();
        if(Ch>=1 && Ch<=2){
            PhoneSection PS=PhoneStore.CreatePhone(Ch);
            PS.First().Print();
            PS.Second().Print();
        }
    }
}
