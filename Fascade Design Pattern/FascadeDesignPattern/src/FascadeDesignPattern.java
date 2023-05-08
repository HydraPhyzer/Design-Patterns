import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface MobileShop{
    void ModelNo();
    void Price();
}
class BlackBerry implements MobileShop{
    String Model;
    int Price;
    BlackBerry(String Model,int Price){
        this.Model=Model;
        this.Price=Price;
    };

    @Override
    public void ModelNo() {
        System.out.println("My Model IS : "+Model);
    }

    @Override
    public void Price() {
        System.out.println("My Price IS : "+Price);
    }
}
class IPhone implements MobileShop{

    String Model;
    int Price;
    IPhone(String Model,int Price){
        this.Model=Model;
        this.Price=Price;
    };

    @Override
    public void ModelNo() {
        System.out.println("My Model IS : "+Model);
    }

    @Override
    public void Price() {
        System.out.println("My Price IS : "+Price);
    }
}
class Samsung implements MobileShop{

    String Model;
    int Price;
    Samsung(String Model,int Price){
        this.Model=Model;
        this.Price=Price;
    };

    @Override
    public void ModelNo() {
        System.out.println("My Model IS : "+Model);
    }

    @Override
    public void Price() {
        System.out.println("My Price IS : "+Price);
    }
}
class ShopKeeperFascade{
    private Samsung    S1;
    private IPhone     I1;
    private BlackBerry B1;

    ShopKeeperFascade(){
        S1=new Samsung("Samsung S1",200);
        I1=new IPhone("IPhone 12",300);
        B1=new BlackBerry("Blackberry B1",400);
    }
    void SellIPhone(){
        I1.ModelNo();
        I1.Price();
    }
    void SellBlackBerry(){
        B1.ModelNo();
        B1.Price();
    }
    void SellSamsung(){
        S1.ModelNo();
        S1.Price();
    }
}
public class FascadeDesignPattern {
    public static void main(String[] args) throws IOException {
        ShopKeeperFascade SKF=new ShopKeeperFascade();

        System.out.println("========================");
        System.out.println("Press 1) For Selling IPhone");
        System.out.println("Press 2) For Selling Samsung");
        System.out.println("Press 3) For Selling Blackberry");
        System.out.println("Choice >>");

        BufferedReader BR=new BufferedReader(new InputStreamReader(System.in));
        int Choice=Integer.parseInt(BR.readLine());

        if(Choice==1){
            SKF.SellIPhone();
        }
        else if(Choice==2){
            SKF.SellSamsung();
        }
        else{
            SKF.SellBlackBerry();
        }
    }
}
