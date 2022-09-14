package requests;

public class DeletePlace {
    private String token;

    public DeletePlace(){}

    public DeletePlace(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
