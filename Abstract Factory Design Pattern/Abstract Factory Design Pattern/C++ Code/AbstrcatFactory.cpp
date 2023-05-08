#include<iostream>
using namespace std;


//Abstract Class For Mac and Win Buttons
class IButton {
    public:
    virtual void PressButton()=0; 
};
class WinButton:public IButton{
    public:
    void PressButton(){
        cout<<"Pressing Win Button "<<endl;
    }
};
class MacButton:public IButton{
    public:
    void PressButton(){
        cout<<"Pressing Mac Button "<<endl;
    }
};
// ======================
//Abstract Class For Mac and Win Textbox
class ITextBox {
    public:
    virtual void ShowText()=0;
};
class WinText:public ITextBox{
    public:
    void ShowText(){
        cout<<"Showing  Win Text"<<endl;
    }
};
class MacText:public ITextBox{
    public:
    void ShowText(){
        cout<<"Showing  Mac Text"<<endl;
    }
};

// ======================
//Abstract Class For Windows and Macbook Factory
class WholeFactory{
    public:
        virtual IButton *  CreateButton()=0;
        virtual ITextBox * ShowText()=0;
};
class WinFactory:public WholeFactory{
    public:
        IButton * CreateButton(){
            return new WinButton();
        }
        ITextBox * ShowText(){
            return new WinText();
        }
};
class MacFactory: public WholeFactory{
    public:
        IButton * CreateButton(){
            return new MacButton();
        }
        ITextBox * ShowText(){
            return new MacText();
        }
};

// ======================
//Mother Class For Factory
class GUIFactory{
    public:
    static WholeFactory* CreateFactory(int Ch){
        if(Ch==1){
            return new WinFactory();
        }
        if(Ch==2){
            return new MacFactory();
        }
    }
};


int main(){

    cout<<"Press 1) For Windows Factories"<<endl;
    cout<<"Press 2) For MacBook Factories"<<endl;
    cout<<"=============================="<<endl;
    int Ch;
    cout<<"Choice >>";
    cin>>Ch;

    if(Ch>=1 && Ch<=2){
        WholeFactory *WF=GUIFactory::CreateFactory(Ch);
        IButton *  IB=WF->CreateButton();
        IB->PressButton();
        ITextBox * ST=WF->ShowText();
        ST->ShowText();
    }
    return 0;
}