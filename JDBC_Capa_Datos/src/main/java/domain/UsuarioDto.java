package domain;

public class UsuarioDto {

    private int usuarioId;
    private String user_name;
    private String user_password;

    public UsuarioDto() {

    }

    public UsuarioDto(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public UsuarioDto(String user_name, String user_password) {
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public UsuarioDto(int usuarioId, String user_name, String user_password) {
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
