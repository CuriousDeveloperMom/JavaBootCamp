public class Constable extends Base{
    public String jurisdiction;

    //Constructor
    public Constable(String name, int strength, int health, int stamina, int speed, int attackPower, String jurisdiction) {
        super(name, strength, health, stamina, speed, attackPower);
        this.jurisdiction = jurisdiction;
    }

    //Methods
    public void arrest(){
        System.out.println("Constable's Arrest Method");
    }
}
