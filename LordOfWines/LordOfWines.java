package LordOfWines;

public class LordOfWines {
    public static void main(String[] args) {
        Die dH = new Die("Hieratic");
        Die dG = new Die("Graceful");

        Die[] dies = {dG, dH};

        System.out.println("Hieratic Die");
        System.out.println("------------");
        
        rollDieNTimes(dH, 20);
        
        System.out.println("Graceful Die");
        System.out.println("------------");
        
        rollDieNTimes(dG, 20);

        Time time = new Time(40, 23, 2);

        System.out.println(time.getTime());
        System.out.println(time.passBy(75));
        System.out.println(time.getTime());
        System.out.println(time.getTimeDay());

        Wine opprobrium = new Wine("Opprobrium", "Dusk", 5, 7);
        Wine adventus = new Wine("Adventus", "Afternoon", 7, 2);
        Wine chrysalis = new Wine("Chrysalis", "Morning", 3, 3);
        Wine red = new Wine("Red Wine", "Dawn", 9, 5.5f);

        Wine[] wines = {opprobrium, adventus, chrysalis, red};
        for (int i =0; i < wines.length; ++i)
        {
            showWine(wines[i]);
        }

        Heretic character = new Heretic("X.G", 29, dies, wines, time);
        showCharacter(character);

        for (int i = 0; i < 20; ++i)
        {
            if (character.getStamina() <= 0)
            {
                System.out.println(character.getName() + " the Heretic will not become The Lord of The Wines");
                break;
            } 
            System.out.println("---------------");
            System.out.println("Gulp " + (i+1));
            System.out.println("---------------");
            
            character.drink();
        }
    }

    public static void showCharacter(Heretic heretic)
    {
        System.out.println("name: " + heretic.getName());
        System.out.println("Age: " + heretic.getAge());
        System.out.println("Level: " + heretic.getLevel());
        System.out.println("Stamina: " + heretic.getStamina());
        System.out.println("Bottles: " + heretic.getBottleNames());    
        System.out.println("----------------------------------");
    }

    public static void showWine(Wine wine)
    {
        System.out.println("name: " + wine.getName());
        System.out.println("Poison time: " + wine.getPoisonTime());
        System.out.println("Points: " + wine.getPoints());
        System.out.println("EffecTime: " + wine.getEffectTime());
        System.out.println("----------------------------------");
    }

    public static void rollDieNTimes(Die die, int n)
    {
        for (int i = 0; i < n; i++)
        {
            int value = die.roll();
            System.out.println(value);
        }
    }
}