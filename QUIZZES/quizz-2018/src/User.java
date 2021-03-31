public class User extends Person {
    User(String name) {
        super(name);
    }
    User(String name, int age) {
        super(name, age);
    }
    public String getUsername() {
        return name + age;
    }
}
