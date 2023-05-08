#include<iostream>
#include<conio.h>
using namespace std;

class Hasbro{
    public:
    Hasbro(){

    }
    virtual void ManufactureToy()=0;
    static Hasbro* ToyFectoryMethod(int);
};
class Dolls:public Hasbro{
    public:
    Dolls(){

    }
    void ManufactureToy(){
        cout<<"Dolls is Being Manufactured"<<endl;
    }
};
class Vehicles:public Hasbro{
    public:
    Vehicles(){

    }
    void ManufactureToy(){
        cout<<"Vehicles is Being Manufactured"<<endl;
    }
};
class ActionFigures:public Hasbro{
    public:
    ActionFigures(){

    }
    void ManufactureToy(){
        cout<<"Action Figures is Being Manufactured"<<endl;
    }
};
class Yellies:public Hasbro{
    public:
    Yellies(){

    }
    void ManufactureToy(){
        cout<<"Yellies is Being Manufactured"<<endl;
    }
};
Hasbro * Hasbro::ToyFectoryMethod(int Choice){
    if(Choice==1) return new Dolls();
    if(Choice==2) return new Vehicles();
    if(Choice==3) return new ActionFigures();
    if(Choice==4) return new Yellies();
    else {return nullptr;}
}

int main(){
    Hasbro *H1;

    Main:
    cout<<"========================"<<endl;
    cout<<"Press 1 For Dolls "<<endl;
    cout<<"Press 2 For Vehicles "<<endl;
    cout<<"Press 3 For Action "<<endl;
    cout<<"Press 4 For Yellies "<<endl;
    cout<<"========================"<<endl;

    int Ch=0;
    cout<<"Choice >> ";
    cin>>Ch;

    if(Ch>=1 && Ch<=4) H1=Hasbro::ToyFectoryMethod(Ch) ; H1->ManufactureToy();getch();system("cls"); goto Main;
    return 0;
}