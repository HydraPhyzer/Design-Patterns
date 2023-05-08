import java.util.ArrayList;

interface Component {
    String Operation();
    void AddChild(Component Child);
    void RemoveChild(Component Child);
    boolean HasChild();
}
class Leaf implements Component{

    @Override
    public String Operation() {
        return "Leaf";
    }

    @Override
    public void AddChild(Component Child) {
        // Nothing to Implement
    }

    @Override
    public void RemoveChild(Component Child) {
        // Nothing to Implement
    }

    @Override
    public boolean HasChild() {
        return false;
    }
}
class Container implements Component{
    private ArrayList<Component> Childrens=new ArrayList<Component>();

    @Override
    public String Operation() {
        int I=0;
        String Result="Branch(";

        for (Component CMP : Childrens){
            Result+=CMP.Operation();
            if(I!=Childrens.size()-1){
                Result+="+";
            }
            I++;
        }
        return Result+")";
    }

    @Override
    public void AddChild(Component Child) {
        Childrens.add(Child);
    }

    @Override
    public void RemoveChild(Component Child) {
        Childrens.remove(Child);
    }

    @Override
    public boolean HasChild() {
        return true;
    }
}
public class CompositeDP {
    public static void main(String args[]){
        Leaf L1=new Leaf();
        Container Tree=new Container();

        Container B1=new Container();
        B1.AddChild(new Leaf());
        B1.AddChild(new Leaf());

        Container B2=new Container();
        B2.AddChild(L1);

        Tree.AddChild(B1);
        Tree.AddChild(B2);

        //Implemented Tree Like Structure With Composite Design Pattern
        System.out.println(Tree.Operation());
    }
}
