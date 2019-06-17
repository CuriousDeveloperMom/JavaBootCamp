public class Warrior extends Base{

    public int shieldStrength;

    //Constructor
    public Warrior(String name, int strength, int health, int stamina, int speed, int attackPower, int shieldStrength) {
        super(name, strength, health, stamina, speed, attackPower);
        this.shieldStrength = shieldStrength;
    }

    //Methods
        public void decreaseShieldStrength(){
             System.out.println("Warrior's Decrease Shield Strength Method");
        }
}
