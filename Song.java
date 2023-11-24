package SongsExercise;

public class Song {

    private String typeList;
    private String songName;
    private String time;


    public Song(String typeList, String songName, String time) {

        this.typeList = typeList;
        this.songName = songName;
        this.time = time;

    }

    public String getTypeList() {
        return typeList;
    }

    public String getSongName() {
        return songName;
    }


}
