class Animal{
void makeSound(){
   System.out.println("Animal is sounding something"); 
}
}
class Dog extends Animal{
    @Override
void makeSound(){
   System.out.println("Dog is Barking"); 
}
}
class Cat extends Animal{
    @Override
void makeSound(){
   System.out.println("Cat is sounding meow, meow"); 
}
}
class Cow extends Animal{
    @Override
void makeSound(){
   System.out.println("cow is sounding moo, moo"); 
}
}
class AnimalCls {
    public static void main(String[] args){
        Animal an = new Animal();
        an.makeSound();
        Dog dog = new Dog();
        dog.makeSound();
        Cat cat = new Cat();
        cat.makeSound();
        Cow cow = new Cow();
        cow.makeSound();
    }
}
