#include <iostream>

// Duck interface
class Duck {
public:
    virtual void quack() = 0;
    virtual void fly() = 0;
};

// Turkey interface
class Turkey {
public:
    virtual void gobble() = 0;
    virtual void fly() = 0;
};

// Concrete duck implementation
class MallardDuck : public Duck {
public:
    void quack() override {
        std::cout << "Quack!" << std::endl;
    }
    void fly() override {
        std::cout << "I'm flying!" << std::endl;
    }
};

// Concrete turkey implementation
class WildTurkey : public Turkey {
public:
    void gobble() override {
        std::cout << "Gobble gobble!" << std::endl;
    }
    void fly() override {
        std::cout << "I'm flying a short distance!" << std::endl;
    }
};

// Turkey adapter using multiple inheritance
class TurkeyAdapter : public Duck, public WildTurkey {
public:
    void quack() override {
        gobble();
    }
    void fly() override {
        for (int i = 0; i < 5; i++) {
            WildTurkey::fly();
        }
    }
};

// Client code
int main() {
    MallardDuck* duck = new MallardDuck();
    WildTurkey* turkey = new WildTurkey();
    Duck* turkeyAdapter = new TurkeyAdapter();

    std::cout << "The turkey says..." << std::endl;
    turkey->gobble();
    turkey->fly();

    std::cout << "\nThe duck says..." << std::endl;
    duck->quack();
    duck->fly();

    std::cout << "\nThe turkey adapter says..." << std::endl;
    turkeyAdapter->quack();
    turkeyAdapter->fly();

    delete duck;
    delete turkey;
    delete turkeyAdapter;

    return 0;
}
