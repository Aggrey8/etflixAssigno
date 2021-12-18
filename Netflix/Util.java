    //Util class to store methods that are used in more than one class
public class Util
{
    //Method to format the duration(provided in seconds) to the required format (HH:MM:SS)
    public static String stringFormatter(long seconds)
    {
        long absSeconds = Math.abs(seconds);
        String runtime = String.format(
            "%d:%02d:%02d",
            absSeconds / 3600,
            (absSeconds % 3600) / 60,
            absSeconds % 60);
        return runtime; 
    }
}
