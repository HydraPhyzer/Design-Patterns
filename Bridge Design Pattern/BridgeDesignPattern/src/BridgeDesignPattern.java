interface Device{
    boolean IsEnabled();
    void Enable();
    void Disable();
    int GetVolume();
    void SetVolume(int Percent);
    int GetChannel();
    void SetChannel(int Channel);
}
class Television implements Device{
    boolean On=false;
    int Volume=30;
    int Channel=1;
    @Override
    public boolean IsEnabled() {
        return On;
    }

    @Override
    public void Enable() {
        On=true;
    }

    @Override
    public void Disable() {
        On=false;
    }

    @Override
    public int GetVolume() {
        return Volume;
    }

    @Override
    public void SetVolume(int Percent) {
        if(Percent>100) Volume=100;
        if(Percent<0) Volume=0;
        else Volume=Percent;
    }

    @Override
    public int GetChannel() {
        return Channel;
    }

    @Override
    public void SetChannel(int Chan) {
        Channel=Chan;
    }
    public void PrintStatus(){
        System.out.println("============TV Status===========");
        System.out.println("Enabled Status  : "+(On?"Enabled":"Disabled"));
        System.out.println("Volume Status   : "+Volume);
        System.out.println("Channel Status  : "+Channel);
    }
}
class Radio implements Device{
    boolean On=false;
    int Volume=40;
    int Channel=100;
    @Override
    public boolean IsEnabled() {
        return On;
    }

    @Override
    public void Enable() {
        On=true;
    }

    @Override
    public void Disable() {
        On=false;
    }

    @Override
    public int GetVolume() {
        return Volume;
    }

    @Override
    public void SetVolume(int Percent) {
        if(Percent>100) Volume=100;
        if(Percent<0) Volume=0;
        else Volume=Percent;
    }

    @Override
    public int GetChannel() {
        return Channel;
    }

    @Override
    public void SetChannel(int Chan) {
        Channel=Chan;
    }
    public void PrintStatus(){
        System.out.println("============Radio Status===========");
        System.out.println("Enabled Status  : "+(On?"Enabled":"Disabled"));
        System.out.println("Volume Status   : "+Volume);
        System.out.println("Channel Status  : "+Channel);
    }
}
interface Remote{
    void TogglePower();
    void VolumeUp();
    void VolumeDown();
    void ChannelUp();
    void ChannelDown();
}
class BasicRemote implements Remote{
    protected Device DeviceName;
    BasicRemote(Device Dev){
        super();
        this.DeviceName=Dev;
    }
    @Override
    public void TogglePower() {
        if(DeviceName.IsEnabled()){
            DeviceName.Disable();
        }
        else DeviceName.Disable();
    }

    @Override
    public void VolumeUp() {
        DeviceName.SetVolume(DeviceName.GetVolume()+10);
    }

    @Override
    public void VolumeDown() {
        DeviceName.SetVolume(DeviceName.GetVolume()-10);
    }

    @Override
    public void ChannelUp() {
        DeviceName.SetChannel(DeviceName.GetChannel()+1);
    }

    @Override
    public void ChannelDown() {
        DeviceName.SetChannel(DeviceName.GetChannel()-1);
    }
}
class AdvanceRemote extends BasicRemote{
    AdvanceRemote(Device Dev) {
        super(Dev);
    }
    public void Mute() {
        DeviceName.SetVolume(0);
    }
}
public class BridgeDesignPattern {
    public static void main(String[] args){
        Television TV1=new Television();
        BasicRemote Basic=new BasicRemote(TV1);
        Basic.VolumeUp();
        TV1.PrintStatus();

        AdvanceRemote Advance=new AdvanceRemote(TV1);
        Advance.Mute();
        TV1.PrintStatus();

        Radio R1=new Radio();
        BasicRemote BasicR=new BasicRemote(R1);
        BasicR.VolumeUp();
        R1.PrintStatus();

        AdvanceRemote AdvanceR=new AdvanceRemote(R1);
        AdvanceR.Mute();
        R1.PrintStatus();
    }
}