package informationClasses;

import java.util.ArrayList;
import java.util.List;

import jsonObjects.BandWithAlbums;

import com.google.gson.Gson;

public class MusicDatabase {
    
    private List<String> bandNames;
    private List<BandWithAlbums> bandsAndAlbums;
    
    
    // Singleton methods
    private static MusicDatabase dbInstance = null;
    
    protected MusicDatabase() {
        bandNames = new ArrayList<>();
        bandsAndAlbums = new ArrayList<>();
    }
    
    public static MusicDatabase getInstance() {
       if(dbInstance == null) {
          dbInstance = new MusicDatabase();
       }
       
       return dbInstance;
    }
    
    
    public void setBandAndAlbums(String bandName, ArrayList<String> bandAlbums) {
        bandNames.add(bandName);
        bandsAndAlbums.add(new BandWithAlbums(bandName, bandAlbums));
    }
    
    public String getBands() {
        return new Gson().toJson(bandNames);
    }
    
    public String getBandsAndAlbums() {
        return new Gson().toJson(bandsAndAlbums);
    }
}
