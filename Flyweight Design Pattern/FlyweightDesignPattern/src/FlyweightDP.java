import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum Colors{
    GREEN,ORANGE
}

class TreeType{
    private String Name;
    private String OtherData;
    private Colors Color;

    public TreeType(String Na, Colors C1, String Other){
        this.OtherData=Other;
        this.Name=Na;
        this.Color=C1;
    }
    public void Plant(int X, int Y){
        System.out.println(this.toString()+" IS Planted At ("+X+ " and "+Y+")");
    }

    @Override
    public String toString() {
        return "TreeType [Name= "+Name+ " , Color= "+Color +" ,OtherData= "+OtherData+ "]";
    }
}
class Tree{
    private int X;
    private int Y;
    private TreeType Type;

    Tree(int X,int Y,TreeType Ty){
        this.X=X;
        this.Y=Y;
        this.Type=Ty;
    }
    public void Plant(){
        Type.Plant(X,Y);
    }

}
class TreeFactory{
    static Map<String,TreeType> AllTreeTypes=new HashMap<>();

    public static TreeType GetTreeType(String Name,Colors C1, String Other){
        TreeType Res=AllTreeTypes.get(Name);
        if(Res==null){
            Res=new TreeType(Name,C1,Other);
            AllTreeTypes.put(Name,Res);
        }
        return Res;
    }
}
class Forest{
    private List<Tree> Trees=new ArrayList<>();

    public void PlantTree(int X,int Y,String Name,Colors Col,String Other){
        TreeType Typ=TreeFactory.GetTreeType(Name,Col,Other);

        Tree T1=new Tree(X,Y,Typ);
        Trees.add(T1);
    }
    public void Display(){
        for(Tree tree :Trees){
            tree.Plant();
        }
    }
}

public class FlyweightDP {
    public static void main(String args[]){

        Forest F1=new Forest();
        F1.PlantTree(10,20,"Ack",Colors.GREEN,"Full");
        F1.PlantTree(10,20,"Ack",Colors.GREEN,"Full");
        F1.PlantTree(10,20,"Ack",Colors.GREEN,"Full");


        F1.PlantTree(20,30,"Oak",Colors.ORANGE,"Half");
        F1.PlantTree(20,30,"Oak",Colors.GREEN,"Full");
        F1.PlantTree(20,30,"Oak",Colors.ORANGE,"Full");

        F1.Display();
    }
}
