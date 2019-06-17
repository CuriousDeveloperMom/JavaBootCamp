public class Base {

    // Variable Decalaration

    public String name;
    public int strength;
    public int health;
    public int stamina;
    public int speed;
    public int attackPower;

    //Default Constructor
    public Base() {
    }

    //Constructor

    public Base(String name, int strength, int health, int stamina, int speed, int attackPower) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
    }

    //Getters and Setters

    //Methods
    public void run(){
        System.out.println("Run Method");
    }
    public void attack(){
        System.out.println("Attack Method");
    }
    public void heal(){
        System.out.println("Heal Method");
    }
    public void decreaseHealth(){
        System.out.println("Decrease Health Method");

    }
    public void increaseStamina(){
        System.out.println("Increase Stamina Method");
    }
    public void decreaseStamina(){
        System.out.println("Decrease Stamina Method");
    }

}
