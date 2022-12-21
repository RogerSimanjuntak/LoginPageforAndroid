package model;

public class user {

    private String email, name,  password;
    int id;
    public user (int id,  String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email= email;
        this.password=password;
    }

    public user() {

    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
}
}
