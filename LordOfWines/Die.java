package LordOfWines;

public class Die {
    private int[] values;

    public Die(String name)
    {
        if (name.equals("Hieratic"))
        {
            int[] values = {1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5};
            this.values = values;

        }
        else if (name.equals("Graceful"))
        {
            int[] values = {1, 1, 1, 2, 3, 4, 5, 6 ,7, 8, 8};
            this.values = values;
        }
        else
        {
            int[] values = {1, 2, 3, 4, 5, 6}; 
            this.values = values; 
        }
    }

    public int roll()
    {
        return values[(int)(Math.random()*values.length)];
    }
}