interface DiscountStrategy{
    void GiveDiscount();
}
class FlatDiscount implements DiscountStrategy{

    @Override
    public void GiveDiscount() {
        System.out.println("Flat Discount");
    }
}
class CashbackDiscount implements DiscountStrategy{

    @Override
    public void GiveDiscount() {
        System.out.println("Cashback Discount");
    }
}
class CouponDiscount implements DiscountStrategy{

    @Override
    public void GiveDiscount() {
        System.out.println("Coupon Discount");
    }
}
class ApplyDiscount{
    DiscountStrategy DS;
    public ApplyDiscount(DiscountStrategy D1){
        this.DS=D1;
    }
    void GiveDiscount(){
        DS.GiveDiscount();
    }
    void SetStrategy(DiscountStrategy D1){
        this.DS=D1;
    }
}
public class StrategyDP {
    public static void main(String args[]){
        ApplyDiscount AD=new ApplyDiscount(new FlatDiscount());
        AD.GiveDiscount();

        AD.SetStrategy(new CashbackDiscount());
        AD.GiveDiscount();
    }
}
