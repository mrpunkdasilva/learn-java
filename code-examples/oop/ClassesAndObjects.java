public class ClassesAndObjects {
    // Exemplo de classe básica
    public class Person {
        // Atributos
        private String name;
        private int age;
        
        // Construtor
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        // Métodos
        public void introduce() {
            System.out.println("Hi, I'm " + name + " and I'm " + age + " years old.");
        }
        
        // Getters e Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
    }
    
    // Exemplo de uso
    public void demonstrateClassesAndObjects() {
        Person person1 = new Person("John", 30);
        Person person2 = new Person("Mary", 25);
        
        person1.introduce();
        person2.introduce();
    }
}