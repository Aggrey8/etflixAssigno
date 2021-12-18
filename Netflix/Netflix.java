import java.util.ArrayList;

public class Netflix
{
    //Atributes
    private ArrayList<Serie> series;
    
    //Constructor
    public Netflix()
    {
        series = new ArrayList<>();
    }
    
    //Getters and setters
    public void addSerie(Serie serie)
    {
        this.series.add(serie);
    }
    
    public ArrayList getSeries()
    {
        return this.series;
    }
    
    //Method to get most watched episode global, loops though all the items available in the series ArrayList
    public Episode getMostWatchedEpisode()
    {
        Episode mostWatched = null;
        ArrayList<Season> seasons;
        ArrayList<Episode> episodes;
        int maxViews = 0;
        
        for(Serie serie : this.series)
        {
            seasons = serie.getSeasons();
            for(Season season: seasons)
            {
                episodes = season.getEpisodes();
                for(Episode episode : episodes)
                {
                    if (episode.getViews() > maxViews)
                    {
                        maxViews = episode.getViews();
                        mostWatched = episode;
                    }
                }
            }
        }
        return mostWatched;
    }
    
    //used in removeMostBoringSeris
    private Serie findMostBoringSerie()
    {
        Serie mostBoringSerie = null;
        ArrayList<Season> seasons;
        ArrayList<Episode> episodes;
        int maxDislikes = 0;
        
        for(Serie serie : this.series)
        {
            if (serie.getDislikes() > maxDislikes)
            {
                maxDislikes = serie.getDislikes();
                mostBoringSerie = serie;
            }
        }
        return mostBoringSerie;
    }
    
    public void removeMostBoringSerie()
    {
        this.series.remove(this.findMostBoringSerie());
    }
}

