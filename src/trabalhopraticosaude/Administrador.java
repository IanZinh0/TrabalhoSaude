package trabalhopraticosaude;

class Administrador {

    private String usuario;
    private String senha;

    public Administrador(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean realizarLogin(String usuario, String senha) {
        return this.getUsuario().equals(usuario) && this.getSenha().equals(senha);
    }

}
