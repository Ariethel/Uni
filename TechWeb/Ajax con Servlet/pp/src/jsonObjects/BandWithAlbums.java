package jsonObjects;

import java.util.ArrayList;

public class BandWithAlbums {

    String bandName;
    ArrayList<String> bandAlbums;
    
    public BandWithAlbums(String bandName, ArrayList<String> bandAlbums) {
        this.bandName = bandName;
        this.bandAlbums = bandAlbums;
    }
}