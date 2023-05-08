#include <iostream>
using namespace std;

class Singleton
{
	private:
		static Singleton *Instance;
		static int Count;
		Singleton()
		{
			Count++;
		}
		Singleton(int Val)
		{
			Data=Val;
			Count++;
		}
	public:
		int Data;
		static Singleton* CreateInstance()
		{
			if(Instance==NULL)
			{
				Instance=new Singleton();
				return Instance;
			}
			else
			{
				return Instance;
			}
		}
		void SetData(int Val)
		{
			Data=Val;
		}
		int GetData()
		{
			return this->Data;
		}
		int GetCount()
		{
			return this->Count;
		}
		~Singleton()
		{
			
		}
		
};
Singleton* Singleton::Instance=NULL;
int Singleton::Count=0;

int main()
{
	Singleton* S1=Singleton::CreateInstance();
	S1->SetData(100);
	
	Singleton *S2=Singleton::CreateInstance();
	S2->SetData(200);
	
	cout<<"The Data Is :"<<S1->GetData() <<" And Total Instance Are : "<<Singleton::GetCount;
	return 0;
}