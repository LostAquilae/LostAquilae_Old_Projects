package metier;

public class ChangeHoraire {
    
    private int heures;
    private int minutes;
    
    public ChangeHoraire(int duree)
    {
        this.heures = duree / 60;
        this.minutes = duree % 60;
    }
    
    public int getHeures()
    {
        return this.heures;
    }
    
    public int getMinutes()
    {
        return this.minutes;
    }
}
