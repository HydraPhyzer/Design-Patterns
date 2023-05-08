import java.io.File;

//This is a Service Interface
interface Image{
    void Display();
}
class ProxyImage implements Image{
    private String FileName;
    private RealImage Service;
    public ProxyImage(String FN){
        super();
        this.FileName=FN;
    }
    public String GetFileName(){
        return FileName;
    }
    @Override
    public void Display() {
        if(Service==null)
            Service=new RealImage(FileName);
        Service.Display();
    }
}

//This Class Act as Service
class RealImage implements Image{
    private String FileName;
    public RealImage(String FN){
        this.FileName=FN;
        LoadFromDisk(FileName);
    }

    @Override
    public void Display(){
        System.out.println("Displaying "+ FileName);
    }

    private void LoadFromDisk(String fileName) {
        System.out.println("Loading "+fileName+" From Disk" );
    }
}

public class ProxyDP {
    public static void main(String args[]){
        Image IMG=new RealImage("TestFile.jpg");
        IMG.Display();

        IMG=new RealImage("TestFile.jpg");
        IMG.Display();

        System.out.println("======================");


        Image ProxyImage=new ProxyImage("TestFile.jpg");
        //Now Image Will be Loaded From Disk
        ProxyImage.Display();

        System.out.println("======================");

        //Now Image Will not be Loaded From Disk
        ProxyImage.Display();
    }
}
