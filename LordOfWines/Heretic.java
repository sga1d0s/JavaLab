package LordOfWines;

public class Heretic {
    private String name; 
    private int level; 
    private int age;
    private int stamina;
    private Die[] dies; 
    private Wine[] bottles; 
    private Time goldenWatch; 
    
    public Heretic (String name, int age, Die[] dies, Wine[] bottles, Time goldenWatch)
    {
        //Objeto incorrecto
        if (name.equals("") || age < 16 || dies == null || bottles == null || goldenWatch == null)
        {
            this.name = "";
            this.level = -1;
            this.age = -1;
            this.stamina = -1;
            this.dies = null;
            this.bottles = null;
            this.goldenWatch = null;
        }
        else
        {
            this.name = name;
            this.age = age;
            this.dies = dies;
            this.bottles = bottles;
            this.goldenWatch = goldenWatch;

            //Calculamos level y stamina
            this.level = (age - 16) / 3 + 1;
            this.stamina = 12 * level;
        }
    }

    public String getName() {
        return name;
    }


    public int getLevel() {
        return level;
    }

    public int getAge() {
        return age;
    }

    public int getStamina() {
        return stamina;
    }

    public String getBottleNames()
    {
        String bottleNames = "";
        for (int i = 0; i < bottles.length; ++i)
        {
            bottleNames += bottles[i].getName();
            if (i != bottles.length - 1)
            {
                bottleNames += ", ";
            }   
        } 

        return bottleNames;
    }

    public void drink()
    {
        // Show day, time and dayTime
        System.out.println(goldenWatch.getTime());
        System.out.println(goldenWatch.getTimeDay());
        System.out.println("------------------------");

        //Escogemos una botella al azar.
        Wine randomWine = bottles[(int)(Math.random()*bottles.length)];

        //Vemos si tiene efectos positivos o negativos
        boolean isPoison = randomWine.isPoison(goldenWatch);

        //Calculamos tP (total Points)
        int tP;
        int rollHieratic = dies[1].roll();
        int rollGraceful1 = dies[0].roll();
        int rollGraceful2 = dies[0].roll();
        int totalRollGraceful = rollGraceful1 + rollGraceful2;
        
        if (isPoison)
        {
            tP = rollHieratic + randomWine.getPoints();
            stamina -= tP;
            System.out.println(name + " the Heretic drinks " + randomWine.getName() + ", rolls the Heretic Die and gets a " + rollHieratic);
       
        }
        else
        {
            tP = rollGraceful1 + rollGraceful2 + randomWine.getPoints();
            stamina += tP;
            System.out.println(name + " the Heretic drinks " + randomWine.getName() + ", rolls the Graceful Dies and gets a " + totalRollGraceful + " in total");
        }

        System.out.println("He loses " + tP + " points");

        // Mostar mensaje Stamina
        System.out.println("Stamina: " + stamina);

        //Esperamos hasta finalizar los efectos del vino
        waitForTime(randomWine.getEffectTime()); 
    }

    private void waitForTime(float hours)
    { 
        final int MAXIMUM_WAIT_MINUTES_PER_REST = 180;

        int remainingRestMinutes = (int)(hours * 60);

        //Tiempos de espera completos de 180 minutos
        while(remainingRestMinutes >= MAXIMUM_WAIT_MINUTES_PER_REST)
        {
            String message = goldenWatch.passBy(MAXIMUM_WAIT_MINUTES_PER_REST);
            System.out.println(message);

            remainingRestMinutes -= MAXIMUM_WAIT_MINUTES_PER_REST;
        }
        
        // Tiempo de espera no completo (parcial)
        if (remainingRestMinutes > 0)
        {
            String message = goldenWatch.passBy(remainingRestMinutes);
            System.out.println(message);
        }
    }
}