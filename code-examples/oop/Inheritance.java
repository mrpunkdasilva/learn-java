public class Inheritance {
    // Classe base
    public class Animal {
        protected String name;
        protected int age;
        
        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public void makeSound() {
            System.out.println("Some generic sound");
        }
    }
    
    // Classe derivada
    public class Dog extends Animal {
        private String breed;
        
        public Dog(String name, int age, String breed) {
            super(name, age);
            this.breed = breed;
        }
        
        @Override
        public void makeSound() {
            System.out.println("Woof!");
        }
        
        public void fetch() {
            System.out.println(name + " is fetching the ball!");
        }
    }
    
    // Outra classe derivada
    public class Cat extends Animal {
        private boolean isIndoor;
        
        public Cat(String name, int age, boolean isIndoor) {
            super(name, age);
            this.isIndoor = isIndoor;
        }
        
        @Override
        public void makeSound() {
            System.out.println("Meow!");
        }
    }
}