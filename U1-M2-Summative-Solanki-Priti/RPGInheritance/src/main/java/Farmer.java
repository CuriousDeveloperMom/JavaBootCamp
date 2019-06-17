public class Farmer extends Base {

    //Constructor
    public Farmer(String name, int strength, int health, int stamina, int speed, int attackPower) {
        super(name, strength, health, stamina, speed, attackPower);
    }

    //Methods
    public void plow(){
        System.out.println("Farmer's Plow Method");
    }
    public void harvest(){
        System.out.println("Farmer's Harvest Method");
    }
}
