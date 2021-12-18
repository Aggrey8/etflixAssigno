import java.util.ArrayList;

public class Serie
{
    //Atributes
    private String name;
    private ArrayList<Season> seasons;
    
    //Constructor
    public Serie(String name)
    {
        this.name = name;
        this.seasons = new ArrayList<>();
    }
    
    //Getters and Setters
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public ArrayList getSeasons()
    {
        return this.seasons;
    }
    
    //Method to add Season objects to the seasons ArrayList
    public void addSeason(Season season)
    {
        this.seasons.add(season);
    }
    
    //Method to get a combined runtime of every season (and all the episodes in each season) in seconds
    public Long getSeriesRuntimeInSeconds()
    {
        long seconds = 0;
        
        for (Season season : seasons)
        {
            seconds += season.getSeasonRuntimeInSeconds();
        }
        return seconds;
    }
    
    //Method to return total season runtime formatted as HH:MM:SS
    public String getSeriesRuntimeFormatted()
    {
        return Util.stringFormatter(this.getSeriesRuntimeInSeconds());
    }
    
    //Returns most liked(dislike for next method) episode from this serie (episode with highest count of likes atribute)
    public Episode getMostLikedEpisode()
    {
        Episode mostLiked = null, episode = null;
        int likes = 0, maxLikes = 0;
        
        for(Season season : seasons)
        {
            episode = season.getMostLikedEpisode(true);
            likes = episode.getLikes();
            if (likes > maxLikes)
            {
                mostLiked = episode;
                maxLikes = likes;
            }
        }
        return mostLiked;
    }
    
    public Episode getMostDislikedEpisode()
    {
        Episode mostDisliked = null, episode = null;
        int dislikes = 0, maxDislikes = 0;
        
        for(Season season : seasons)
        {
            episode = season.getMostDislikedEpisode();
            dislikes = episode.getLikes();
            if (dislikes > maxDislikes)
            {
                mostDisliked = episode;
                maxDislikes = dislikes;
            }
        }
        return mostDisliked;
    }
    
    //return serie's total number of dislikes for all episodes
    public int getDislikes()
    {
        int dislikes = 0;
        ArrayList<Episode> episodes;
        
        for(Season season : this.seasons)
        {
            episodes = season.getEpisodes();
            //dislikes += season.getDislikes();
            for(Episode episode : episodes)
            {
                dislikes += episode.getDislikes();
            }
        }
        return dislikes;
    }
}
