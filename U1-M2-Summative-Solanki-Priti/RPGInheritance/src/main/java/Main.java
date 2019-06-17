public class Main {

    public static void main(String[] args) {

        System.out.println("############################# Farmer ##############################");

        Farmer f = new Farmer("Farmer",75,100,75,10,1);
        System.out.println("Farmer's Name : " + f.name);
        System.out.println("Farmer's Strength : " + f.strength);
        System.out.println("Farmer's Health : " + f.health);
        System.out.println("Farmer's Stamina : " + f.stamina);
        System.out.println("Farmer's Speed : " + f.speed);
        System.out.println("Farmer's AttackPower : " + f.attackPower);
        f.plow();
        f.harvest();
        System.out.print("Farmer's "); f.run();
        System.out.print("Farmer's "); f.attack();
        System.out.print("Farmer's "); f.heal();
        System.out.print("Farmer's "); f.decreaseHealth();
        System.out.print("Farmer's "); f.increaseStamina();
        System.out.print("Farmer's "); f.decreaseStamina();

        System.out.println("############################# Constable ##############################");
        Constable c = new Constable("Constable", 60,100,60,20,5,"Jurisdiction");
        System.out.println("Constable's Name : " + c.name);
        System.out.println("Constable's Strength : " + c.strength);
        System.out.println("Constable's Health : " + c.health);
        System.out.println("Constable's Stamina : " + c.stamina);
        System.out.println("Constable's Speed : " + c.speed);
        System.out.println("Constable's AttackPower : " + c.attackPower);
        System.out.println("Constable's Jurisdiction : " + c.jurisdiction);
        c.arrest();
        System.out.print("Constable's "); c.run();
        System.out.print("Constable's "); c.attack();
        System.out.print("Constable's "); c.heal();
        System.out.print("Constable's "); c.decreaseHealth();
        System.out.print("Constable's "); c.increaseStamina();
        System.out.print("Constable's "); c.decreaseStamina();

        System.out.println("############################# Warrior ##############################");
        Warrior w = new Warrior("Warrior",75,100,100,50,10,100);
        System.out.println("Warrior's Name : " + w.name);
        System.out.println("Warrior's Strength : " + w.strength);
        System.out.println("Warrior's Health : " + w.health);
        System.out.println("Warrior's Stamina : " + w.stamina);
        System.out.println("Warrior's Speed : " + w.speed);
        System.out.println("Warrior's AttackPower : " + w.attackPower);
        System.out.println("Warrior's Shield Strength : " + w.shieldStrength);
        w.decreaseShieldStrength();
        System.out.print("Warrior's "); w.run();
        System.out.print("Warrior's "); w.attack();
        System.out.print("Warrior's "); w.heal();
        System.out.print("Warrior's "); w.decreaseHealth();
        System.out.print("Warrior's "); w.increaseStamina();
        System.out.print("Warrior's "); w.decreaseStamina();

    }
}
