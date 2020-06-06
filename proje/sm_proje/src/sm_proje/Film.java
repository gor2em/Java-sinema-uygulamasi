package sm_proje;

public class Film {

    private int id;
    private String FilmAdi, FilmKonu, FilmYonetmen, FilmYil, FilmTur, FilmPuan, filmID;
    private byte[] picture;

    public Film(int id, String FilmAdi, String FilmKonu, String FilmYonetmen, String FilmYil, String FilmTur, String FilmPuan, String FilmID, byte[] image) {
        this.id = id;
        this.FilmAdi = FilmAdi;
        this.FilmKonu = FilmKonu;
        this.FilmYonetmen = FilmYonetmen;
        this.FilmYil = FilmYil;
        this.FilmTur = FilmTur;
        this.FilmPuan = FilmPuan;
        this.filmID = FilmID;
        this.picture  = image;
//        this.date = date;
    }
     
    public int getId() {
        return id;
    }

    public String getFilmAdi() {
        return FilmAdi;
    }

    public String getFilmKonu() {
        return FilmKonu;
    }

    public String getFilmYonetmen() {
        return FilmYonetmen;
    }

    public String getFilmTur() {
        return FilmTur;
    }

    public String getFilmPuan() {
        return FilmPuan;
    }

    public String getFilmID() {
        return filmID;
    }

    public String getFilmYil() {
        return FilmYil;
    }

    public byte[] getImage() {
        return picture;
    }
    
//        public String getDate() {
//        return date;
//    }
}
