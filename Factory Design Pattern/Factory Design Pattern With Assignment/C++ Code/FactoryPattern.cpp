#include<iostream>
using namespace std;

class Vehicle{
    public:
        Vehicle(){

        };

        virtual void PrintVehicle()=0;
        static Vehicle* FactoryMethod(int);
        ~Vehicle (){

        }
};
class Bike:public Vehicle{
    public:
        Bike(){

        }
        void PrintVehicle(){
            cout<<"I Am Bike"<<endl;
        }
};
class Car:public Vehicle{
    public:
        Car(){

        }
        void PrintVehicle(){
            cout<<"I Am Car"<<endl;
        }
};
Vehicle * Vehicle::FactoryMethod(int Choice){
    if(Choice==1){
        return new Car();
    }
    if(Choice==2){
        return new Bike();
    }
}
// There We Have Implemented The FactoryMethod in Base Class, But We Can also Complete This 
// Functionality in Another Temprary Class, Where We Can Write this Whole FactoryMethod Function 
// and Then Just Call His Constructor in the Main , Thats it

int main()
{
    // This is The Customery Method, That is nor Recommended Because it is Bad for Customer
    // Cause it is Overwhelming


    // Vehicle *VI=new Car();
    // VI->PrintVehicle(); //I am Car

    // VI=new Bike();
    // VI->PrintVehicle(); //I Am Bike


    // This is New Factory Method 
    // Vehicle *VT=Vehicle::FactoryMethod(1);
    Vehicle *VT=Vehicle::FactoryMethod(2);
    VT->PrintVehicle();
    return 0;
}