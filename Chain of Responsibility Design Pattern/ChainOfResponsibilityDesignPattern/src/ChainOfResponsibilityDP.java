import java.util.Queue;

//This is Example of How ATM, Dispense Different Notes
class Currency {
    private int Amount;

    public Currency(int Am) {
        this.Amount = Am;
    }

    public int GetAmount() {
        return Amount;
    }
}

//This Acts as Handler Interface
interface Dispenser {
    void SetNext(Dispenser D1);

    void Dispense(Currency C1);
}
//This Acts as BaseHandler
class RupeeDispenser implements Dispenser {
    private Dispenser Next = null;
    private int Worth;
    public RupeeDispenser(int W1){
        this.Worth=W1;
    }

    @Override
    public void SetNext(Dispenser D1) {
        this.Next = D1;
    }

    @Override
    public void Dispense(Currency C1) {
        if(C1.GetAmount()>=Worth){
            int Qou=C1.GetAmount()/Worth;
            int Rem=C1.GetAmount()%Worth;
            System.out.println("Dispensing "+ Qou+" ("+Worth+")");
            if(Rem!=0 && Next!=null){
                Next.Dispense(new Currency(Rem));
            }
        }
        else if(Next!=null){
            Next.Dispense(C1);
        }
        else{
            System.out.println("Can't Process "+C1.GetAmount() +" Rs");
        }
    }
}
//This Class Helps In Making Chain, This is Optional , We Can Also Make it int Main Client
class DispenserChain{
    Dispenser D1;
    DispenserChain(){
        D1=new RupeeDispenser(5000);
        Dispenser D2=new RupeeDispenser(1000);
        Dispenser D3=new RupeeDispenser(500);
        Dispenser D4=new RupeeDispenser(100);
        Dispenser D5=new RupeeDispenser(50);
        Dispenser D6=new RupeeDispenser(20);
        Dispenser D7=new RupeeDispenser(10);
        Dispenser D8=new RupeeDispenser(5);
        Dispenser D9=new RupeeDispenser(1);

        D1.SetNext(D2);
        D2.SetNext(D3);
        D3.SetNext(D4);
        D4.SetNext(D5);
        D5.SetNext(D6);
        D6.SetNext(D7);
        D7.SetNext(D8);
        D8.SetNext(D9);
    }
    public void Dispense(Currency C){
        D1.Dispense(C);
    }
}

public class ChainOfResponsibilityDP {
    public static void main(String args[]){
        DispenserChain DS=new DispenserChain();
        DS.Dispense(new Currency(1533));
    }
}
