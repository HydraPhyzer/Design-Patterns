class User{
    String FName;
    String LName;
    int Age;
    String MobileNo;
    String Gender;

    private User(UserBuilder UB){
        this.FName=UB.FName;
        this.LName=UB.LName;
        this.Age=UB.Age;
        this.MobileNo=UB.MobileNo;
        this.Gender=UB.Gender;
    }
    void Display(){
        System.out.println("First Name    : "+FName);
        System.out.println("Last Name     : "+LName);
        System.out.println("Age           : "+Age);
        System.out.println("Mobile Number : "+MobileNo);
        System.out.println("Gender        : "+Gender);
        System.out.println("========================");
    }
    public static class UserBuilder{
        String FName;
        String LName;
        int Age;
        String MobileNo;
        String Gender;

        public UserBuilder(){}
        public UserBuilder SetFName(String FName){
            this.FName=FName;
            return this;
        }
        public UserBuilder SetLName(String LName){
            this.LName=LName;
            return this;
        }
        public UserBuilder SetAge(int Age){
            this.Age=Age;
            return this;
        }
        public UserBuilder SetMob(String Mob){
            this.MobileNo=Mob;
            return this;
        }
        public UserBuilder SetGen(String Gen){
            this.Gender=Gen;
            return this;
        }
        public User Build(){
            User US=new User(this);
            return US;
        }
    }
}
public class BuilderPattern {
    public static void main(String[] args){
        User U1=new User.UserBuilder().SetFName("Zubair").SetLName("Gujjar").SetAge(20).SetMob("0321").Build();
        U1.Display();

        User U2=new User.UserBuilder().SetFName("Talha").SetLName("Gujjar").Build();
        U2.Display();
    }
}
