#include<iostream>
using namespace std;

class Adress
{
    public:
        string City;
        int StreetNo;
        string Province;
        int Postal;
    Adress()
    {
        City="";
        StreetNo=0;
        Province="";
        Postal=0;
    }
    void InsertAdress()
    {
        cout<<"Enter City              : ";
        cin>>City;
        cout<<"Enter Street #          : ";
        cin>>StreetNo;
        cout<<"Enter Province          : ";
        cin>>Province;
        cout<<"Enter Postal Code       : ";
        cin>>Postal;
    }
    void DisplayAdress()
    {
        cout<<"\nAdress          : "<<StreetNo<<", "<<City<<", "<<Province<<" "<<Postal;
        cout<<"\n";
    }

    
};
class Employee
{
    public:
        string Name;
        int Age;
        string NIC;
        Adress* A;
        float Salary;

        Employee()
        {
            Name="";
            Age=0;
            NIC="";
            Salary=0;
            A=new Adress;
        }
};
class SalariedEmployee
{
    ~SalariedEmployee()
    {
        
    }
};

class PartTime
{
    public:
        float Hours;
    PartTime()
    {
        Hours=0;
    }
    float CalcSalary()
    {
        cout<<"How Many Hourse Worked : ";
        cin>>Hours;
        if(Hours>20)
        {
            return (Hours-20)*100;
        }
        else
        {
            return 0;
        }
    }
};
class CommisiopnedEmployee
{
    public:
        float Sales;
    CommisiopnedEmployee()
    {
        Sales=0;
    }
    float CalcSalary()
    {
        float PT=0;
        cout<<"Amount of Your Total Sale : ";
        cin>>Sales;
        cout<<"Percentage You Acquired   : ";
        cin>>PT;

        return (PT/100)*Sales;
    }
};
class SalariedCommisiopnedEmployee
{
    public:
        float Sales;
    SalariedCommisiopnedEmployee()
    {
        Sales=0;
    }
    float CalcSalary()
    {
        float PT=0;
        cout<<"Amount of Your Total Sale : ";
        cin>>Sales;
        cout<<"Percentage You Acquired   : ";
        cin>>PT;

        return (PT/Sales)*100;
    }
};
class Increment
{
    public:
        int Percentage;
        static Increment *I1;
        static Increment* CreateInstance()
            {
                if(I1==NULL)
                {
                    I1=new Increment();
                    return I1;
                }
                else
                {
                    return I1;
                }
            }
    private:
        Increment()
        {
            Percentage=0;
        }
        ~Increment()
        {

        }
};
Increment* Increment::I1=NULL;

class Employees
{
    public:
        Employee* E1;
        int Size=0;
    Employees(int Val)
    {
        Size=Val;
        E1=new Employee[Val]();
    }
    int InsertEmployees()
    {
        for (int I=0 ; I<Size; I++)
        {
            cout<<"=============================\n";
            cout<<"Enter Employee Name     : ";
            cin>>E1[I].Name;
            cout<<"Enter Employee Age      : ";
            cin>>E1[I].Age;
            cout<<"Enter Employee NIC      : ";
            cin>>E1[I].NIC;
            E1[I].A->InsertAdress();
            cout<<"=============================\n";
            cout<<"Select Employement Type     :\n\n";
            int Ch=0;
            cout<<"Enter 1) Salaried Employee            \n";
            cout<<"Enter 2) Part-Time Employee           \n";
            cout<<"Enter 3) Commisioned Employee         \n";
            cout<<"Enter 4) Salaried-Commision Employee  \n";
            cout<<"Choice>>";
            cin>>Ch;
            if(Ch==1)
            {
                cout<<"Enter Employee Salary            : ";
                cin>>E1[I].Salary;
                
                Increment *Inc=Increment::CreateInstance();
                E1[I].Salary+=(Inc->Percentage/E1[I].Salary)*100;
            }
            if(Ch==2)
            {
                cout<<"Enter Employee Salary            : ";
                cin>>E1[I].Salary;
                
                Increment *Inc=Increment::CreateInstance();
                E1[I].Salary+=(Inc->Percentage/100)*E1[I].Salary;

                PartTime PT;

                E1[I].Salary+=PT.CalcSalary();
            }
            if(Ch==3)
            {
                CommisiopnedEmployee CE;

                E1[I].Salary+=CE.CalcSalary();
            }
            if(Ch==4)
            {
                cout<<"Enter Employee Salary            : ";
                cin>>E1[I].Salary;
                
                Increment *Inc=Increment::CreateInstance();
                E1[I].Salary+=(Inc->Percentage/100)*E1[I].Salary;

                SalariedCommisiopnedEmployee SCE;

                E1[I].Salary+=SCE.CalcSalary();
            }
        }
        return 0;
    }
    void DisplayEployees()
    {
        if(Size>0)
        {
            for (int I=0 ; I<Size ; I++)
            {
                cout<<"Employee Name   : "<<E1[I].Name;
                cout<<"\nEmployee Age    : "<<E1[I].Age;
                cout<<"\nEmployee NIC    : "<<E1[I].NIC;
                cout<<"\nEmployee Salary : "<<E1[I].Salary;
                E1[I].A->DisplayAdress();
                cout<<"==================================\n";
            }
        }
    }

};
int main()
{
    cout<<"\nTotal Employees ?        :";
    int Total=0;
    cin>>Total;
    Employees E1(Total);
    Main:
    cout<<"Enter 1 ) To Enter  Employees \n";
    cout<<"=============================\n";
    cout<<"Enter 2 ) To Search Employees \n";
    cout<<"=============================\n";
    cout<<"Enter 3 ) To Add Increent    \n";
    int Choice=0;
    cout<<"=============================\n";
    cout<<"Choice>>";
    cin>>Choice;
    if(Choice==1)
    {
        E1.InsertEmployees();
        goto Main;
    }
    if(Choice==2)
    {
        E1.DisplayEployees();
        goto Main;
    }
    if(Choice==3)
    {
        Increment *Inc=Increment::CreateInstance();
        cout<<"Enter Percentage (In %)  : ";
        cin>>Inc->Percentage;
        system("CLS");
        goto Main;
    }
    else
    {
        return 0;
    }
}

//I Have Implemented Singleton Design Pattern in Increment Class. We Can Aslo Implement Singleton Pattern In Employees Class, But We Din not Iplement it For Nows.