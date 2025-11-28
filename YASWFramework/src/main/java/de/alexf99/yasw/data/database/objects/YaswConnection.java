package de.alexf99.yasw.data.database.objects;

public class YaswConnection {
    private String ip;
    private int port;
    private String database;
    private String username;
    private String password;

    public YaswConnection(String ip, int port, String database , String username, String password){
        this.ip = ip;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public String getIp(){return ip;}
    public void setIp(String ip){this.ip = ip;}

    public int getPort(){return port;}
    public void setPort(int port){this.port = port;}

    public String getDatabase(){return database;}
    public void setDatabase(String database){this.database = database;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}


    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}


}
