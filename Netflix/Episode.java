import java.time.Duration;
import java.time.LocalTime;

public class Episode
{
    //atributes
    private String title;
    private Duration runtime;
    private int likes;
    private int dislikes; 
    private int views;
    
    //Constructor
    public Episode(String title, int runtime)
    {
        this.title = title;
        this.runtime = Duration.ofMinutes(runtime);
        this.likes = 0;
        this.dislikes = 0;
        this.views = 0;
    }
    
    //Getters and setters
    public String getTitle()
    {
        return this.title;
    }
    
    //Returns the runtime as a Duration object
    public Duration getRuntime()
    {
        return this.runtime;
    }
    
    //Returns the runtime in seconds as a long primitive
    public long getRuntimeInSeconds()
    {
        return this.runtime.toSeconds();
    }
    
    //Returns the runtime as a String object, formatted as HH:MM:SS 
    public String getRuntimeFormatted()
    {
        return Util.stringFormatter(this.runtime.getSeconds());
    }
    
    public int getLikes()
    {
        return this.likes;
    }
    
    public int getDislikes()
    {
        return this.dislikes;
    }
    
    public int getViews()
    {
        return this.views;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public void setRuntime(int runtime)
    {
        this.runtime = Duration.ofMinutes(runtime);
    }
    
    //Methods to change attributes
    public void addLike()
    {
        this.likes += 1;
    }
    
    public void addDislike()
    {
        this.dislikes += 1;
    }
    
    public void watchEpisode()
    {
        this.views += 1;
    }    
}
