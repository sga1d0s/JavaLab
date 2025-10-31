package LordOfWines;

public class Time {
    private int minutes;
    private int hours;
    private int day;

    public Time(int minutes, int hours, int day) {
        
        if (hours > 23 || hours < 0 || minutes > 59 || minutes < 0)
        {
            this.hours      = 0;
            this.minutes    = 0;
            this.day        = 1;
        }   
        else
        {
            this.minutes = minutes;      
            this.hours   = hours;
            this.day    = day;
        }   
    }

    public String getTimeDay()
    {
        String message;

        if (hours < 3)
        {
            message = "It is Night";
        }
        else if (hours < 7)
        {
            message = "It is Dawn";
        }
        else if (hours < 12)
        {
            message = "It is Morning";
        }
        else if (hours < 17)
        {
            message =  "It is Afternoon";
        }
        else if (hours < 20)
        {
            message =  "It is Dusk"; 
        }
        else 
        {
            message =  "It is Night";
        }

        return message;

    }

    public String passBy(int totalMinutes)
    {
        String returnMessage;

        //Si nos salimos de los márgenes devolvemos el máximo tiempo posible (3 horas)
        if (totalMinutes < 0 || totalMinutes > 180)
        {
            totalMinutes = 180;
        }    
        
        //Calculamos número de horas y minutos (que no incluyan llevada)
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        returnMessage = "Time passes by " + hours + " hours "+ minutes + " minutes";

        //Calculamos la nueva hora

        //Minutos
        this.minutes += minutes;

        //Añadimos la llevada (carry) a las horas
        if (this.minutes > 59)
        {
            this.hours++;
            this.minutes = this.minutes - 60; // también this.minutes % 60
        }

        //Horas
        this.hours += hours;
        
        //Añadimos la llevada (carry) a los días
        if (this.hours > 23)
        {
            this.day++;
            this.hours = this.hours - 24; //también this.hours % 24
        }

        return returnMessage;
        
    }

    public String getTime()
    {
        return "Day " + day + ", " + hours + " hours " + minutes + " minutes";
    }
}
