import java.util.HashMap;
import java.util.Map;

abstract class Game implements Cloneable {
    private String Name;

    public String GetName(){
        return Name;
    }
    public void SetName(String Name){
        this.Name=Name;
    }
    public abstract void PlayGame();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Pubg extends Game{
    @Override
    public void PlayGame(){
        System.out.println("Playing "+ GetName()+ " Game");
    }
}
class Ludo extends Game{
    @Override
    public void PlayGame(){
        System.out.println("Playing "+ GetName()+ " Game");
    }
}
//========================================
enum GameType{
    LUDO,
    PUBG
}
class GameRepository{
    private Map<GameType,Game> AllGames=new HashMap<GameType,Game>();

    GameRepository(){
        this.Initialize();
    }

    private void Initialize() {
        Ludo L1=new Ludo();
        L1.SetName("Ludo Star");

        Pubg P1=new Pubg();
        P1.SetName("Pubg Star");

        AllGames.put(GameType.LUDO,L1);
        AllGames.put(GameType.PUBG,P1);
    }
    public Game GetGame(GameType Type) throws CloneNotSupportedException {
        try{
            return (Game) AllGames.get(Type).clone();
        }
        catch (Exception E){
            System.out.println("Error While Cloning Objects");
        }
        return null;
    }
}
public class PrototypePattern {
    public static void main(String [] args) throws CloneNotSupportedException{

        System.out.println("1) Shallow Copy Happens ");

        Ludo L1=new Ludo();
        L1.SetName("Ludo Star");
        L1.PlayGame();
        L1.SetName("Ludo Pakistan");

        Ludo L2=(Ludo) L1.clone();
        L2.PlayGame();

        System.out.println("==========================");

        System.out.println("2) Deep Copy Happens ");

        GameRepository GR=new GameRepository();
        Game G1=GR.GetGame(GameType.LUDO);
        Game G2=GR.GetGame(GameType.PUBG);
        G1.PlayGame();
        G2.PlayGame();

        System.out.println("==========================");
    }
}
