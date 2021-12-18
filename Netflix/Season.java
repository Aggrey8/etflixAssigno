import java.util.ArrayList;
import java.time.Duration;

public class Season
{
    //Atributes
    private int number;
    private ArrayList<Episode> episodes;
    
    //Constructor, creates a new object with an emtpy ArrayList of Episode objects
    public Season(int number)
    {
        this.number = number;
        this.episodes = new ArrayList<>();
    }
    
    //Getters and Setters
    public int getNumber()
    {
        return this.number;
    }
    
    public ArrayList getEpisodes()
    {
        return this.episodes;
    }
    
    public void setNumber(int number)
    {
        this.number = number;
    }
    
    //Method to add an Episode object to the ArrayList 
    public void addEpisode(Episode episode)
    {
        this.episodes.add(episode);
    }
    
    //Method to get the total runtime of all the Episodes available in the episodes ArrayList, in seconds;
    public long getSeasonRuntimeInSeconds()
    {
        long seconds = 0;
        
        for(Episode episode : episodes)
        {
            seconds += episode.getRuntimeInSeconds();
        }
        return seconds;
    }
    
    //Method to format the total runtime of a season (HH:MM:SS)
    public String getSeasonRuntimeFormatted()
    {
        return Util.stringFormatter(this.getSeasonRuntimeInSeconds());
    }
    
    
    //Methods to get most liked/dislikes episode from the season
    //pass in TRUE to get most liked episode
    //or pass in FALSE to get most disliked epsiode
    public Episode getMostLikedEpisode(Boolean type)
    {
        Episode toFind = null;
        int maxValue = 0;
        int valueToFind = 0;
        
        for (Episode episode : episodes)
        {
            //likes = episode.getLikes();
            if (type == true)
            {
            valueToFind = episode.getLikes();
            }
            else 
            {
                valueToFind = episode.getDislikes();
            }
            
            if (valueToFind > maxValue)
            {
                maxValue = valueToFind;
                toFind = episode;
            }
        }
        return toFind;
    }
    
    public Episode getMostDislikedEpisode()
    {
        Episode mostDisliked = null;
        int maxDislikes = 0;
        int dislikes = 0;
        
        for (Episode episode : episodes)
        {
            dislikes = episode.getLikes();
            if (dislikes > maxDislikes)
            {
                maxDislikes = dislikes;
                mostDisliked = episode;
            }
        }
        return mostDisliked;
    }
}
