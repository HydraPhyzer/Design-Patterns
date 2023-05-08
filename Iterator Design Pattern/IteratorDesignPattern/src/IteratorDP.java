interface Iterator{
    boolean HasNext();
    String Next();
}
interface TV{
    Iterator GetIterator();
}
class ConcreteTV implements TV{
    private String[] Channels={"BBC","PTV","ARY","GEO"};
    Iterator I1;
    public ConcreteTV(){
        I1=new ConcreteIterator();
    }
    @Override
    public Iterator GetIterator() {
        return I1;
    }
    class ConcreteIterator implements Iterator{
        int Index=0;
        @Override
        public boolean HasNext() {
            if(Index<Channels.length)
                return true;
            return false;
        }

        @Override
        public String Next() {
            if(HasNext())
                return Channels[Index++];
            return null;
        }
    }
}
public class IteratorDP {
    public static void main(String args[]){
        TV TV1=new ConcreteTV();

        Iterator I1=TV1.GetIterator();
        while (I1.HasNext()){
            System.out.println("TV Is Playing "+I1.Next());
        }

    }
}
