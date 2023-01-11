package domain;

public class Usuario {

    private int usuarioId;
    private String user_name;
    private String user_password;

    public Usuario() {

    }

    public Usuario(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario(String user_name, String user_password) {
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public Usuario(int usuarioId, String user_name, String user_password) {
        this.usuarioId = usuarioId;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuarioId=" + usuarioId + ", user_name=" + user_name + ", user_password=" + user_password + '}';
    }

}
