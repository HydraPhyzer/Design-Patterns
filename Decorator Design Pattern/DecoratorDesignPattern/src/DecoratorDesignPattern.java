interface Shape{
    void Draw();
}
class Rectangle implements Shape{

    @Override
    public void Draw() {
        System.out.println("Rectangle Shape");
    }
}
class Circle implements Shape{

    @Override
    public void Draw() {
        System.out.println("Rectangle Circle");
    }
}
abstract class ShapeDecorator implements Shape{
    Shape Target;
    ShapeDecorator(Shape Target){
        this.Target=Target;
    }
}
class RedBorderDecorator extends ShapeDecorator{
    RedBorderDecorator(Shape S1){
        super(S1);
    }
    @Override
    public void Draw() {
        Target.Draw();
        SetRedBorder();
    };
    void SetRedBorder(){
        System.out.println("Border : Red");
    }
}
class GreenBorderDecorator extends ShapeDecorator{
    GreenBorderDecorator(Shape S1){
        super(S1);
    }
    @Override
    public void Draw() {
        Target.Draw();
        SetRedBorder();
    };
    void SetRedBorder(){
        System.out.println("Border : Green");
    }
}
public class DecoratorDesignPattern {
    public static void main(String[] args){
        Shape S1=new Rectangle();
        System.out.println("Simple Without Border");
        S1.Draw();

        System.out.println("========================");

        Shape R1=new RedBorderDecorator(S1);
        Shape R2=new GreenBorderDecorator(R1);
        R2.Draw();

        System.out.println("========================");

        Shape S2=new Circle();
        System.out.println("Simple Without Border");
        S2.Draw();
        System.out.println("========================");

        Shape R3=new GreenBorderDecorator(S2);
        R3.Draw();
    }
}
