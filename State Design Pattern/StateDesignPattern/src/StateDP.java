interface State {
    public void DoAction(Context context);
}
class StartState implements State {

    @Override
    public void DoAction(Context context) {
        System.out.println("Player is in start state");
        context.SetState(this);
    }

    public String toString(){
        return "Start State";
    }
}
class StopState implements State {

    @Override
    public void DoAction(Context context) {
        System.out.println("Player is in stop state");
        context.SetState(this);
    }

    public String toString(){
        return "Stop State";
    }
}
class Context {
    private State state;

    public Context(){
        state = null;
    }

    public void SetState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}
public class StateDP {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.DoAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.DoAction(context);

        System.out.println(context.getState().toString());
    }
}
