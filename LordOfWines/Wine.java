package LordOfWines;

public class Wine {
    private String name;
    private String poisonTime;
    private int points;
    private float effectTime;

    public Wine(String name, String poisonTime, int points, float effectTime)
    {
        this.name = name;
        this.poisonTime = poisonTime;
        this.points = points;
        this.effectTime = effectTime;
    }

    public boolean isPoison(Time time)
    {
        boolean isPoison = false;
        String timeDay = time.getTimeDay().substring(6);
        if (timeDay.equals(poisonTime))  
        {
            isPoison = true;
        } 
             
        return isPoison;
    }

    public String getName()
    {
        return name;
    }

    public String getPoisonTime()
    {
        return poisonTime;
    }

    public float getEffectTime()
    {
        return effectTime;
    }

    public int getPoints()
    {
        return points;
    }
}