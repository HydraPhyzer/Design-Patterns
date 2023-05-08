import java.util.*;

// Abstract Class For Mac and Win Buttons
interface IButton {
    void PressButton();
}

class WinButton implements IButton {
    public void PressButton() {
        System.out.println("Pressing Win Button");
    }
}

class MacButton implements IButton {
    public void PressButton() {
        System.out.println("Pressing Mac Button");
    }
}

// Abstract Class For Mac and Win Textbox
interface ITextBox {
    void ShowText();
}

class WinText implements ITextBox {
    public void ShowText() {
        System.out.println("Showing Win Text");
    }
}

class MacText implements ITextBox {
    public void ShowText() {
        System.out.println("Showing Mac Text");
    }
}

// Abstract Class For Windows and Macbook Factory
interface WholeFactory {
    IButton CreateButton();
    ITextBox ShowText();
}

class WinFactory implements WholeFactory {
    public IButton CreateButton() {
        return new WinButton();
    }

    public ITextBox ShowText() {
        return new WinText();
    }
}

class MacFactory implements WholeFactory {
    public IButton CreateButton() {
        return new MacButton();
    }

    public ITextBox ShowText() {
        return new MacText();
    }
}

// Mother Class For Factory
class GUIFactory {
    public static WholeFactory CreateFactory(int Ch) {
        if (Ch == 1) {
            return new WinFactory();
        }
        if (Ch == 2) {
            return new MacFactory();
        }
        return null;
    }
}

class AbstractFactory {
    public static void main(String[] args) {
        System.out.println("Press 1) For Windows Factories");
        System.out.println("Press 2) For MacBook Factories");
        System.out.println("==============================");
        System.out.print("Choice >>");
        Scanner sc = new Scanner(System.in);
        int Ch = sc.nextInt();
        if (Ch >= 1 && Ch <= 2) {
            WholeFactory WF = GUIFactory.CreateFactory(Ch);
            IButton IB = WF.CreateButton();
            IB.PressButton();
            ITextBox ST = WF.ShowText();
            ST.ShowText();
        }
    }
}
