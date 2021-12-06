public class Picture {
    private String path;
    private int likes;
    private final Account creator;

    public Picture(String path, Account creator){
        this.path = path;
        this.likes = 0;
        this.creator = creator;
    }

    public int like(){
        likes++;
        return likes;
    }

    public String getPath(){
        return path;
    }

    public int getLikes(){
        return likes;
    }
}
