import java.util.ArrayList;

public class Account{
    private final String name;
    private final String email;
    private final int password;
    private Picture profilePicture = new Picture("STANDARD",this);
    private ArrayList<Picture> pictures = new ArrayList<>();

    public Account(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password.hashCode();
    }

    public boolean login(String name, String password){
        return name.equals(this.name) && password.hashCode() == this.password;
    }

    public boolean uploadPicture(String path){
        try {
            pictures.add(new Picture(path, this));
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Picture> showPictures(){
        return pictures;
    }

    public void setProfilePicture(String path){
        profilePicture = new Picture(path, this);
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getProfilePicture(){
        return profilePicture.getPath();
    }

}
