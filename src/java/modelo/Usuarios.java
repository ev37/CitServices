package modelo;


public class Usuarios{

  private int id_usuario = 0;
  private String nombre = null;
  private String contraseña = null;
  private int tipo_usuario = 0;

  public Usuarios() {
    id_usuario = 0;
    nombre = null;
    contraseña = null;
    tipo_usuario = 0;

  }

  public int getId_usuario() {
    return id_usuario;
  }

  public void setId_usuario(int id_usuario) {
    this.id_usuario = id_usuario;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getContraseña() {
    return contraseña;
  }

  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }

  public int getTipo_usuario() {
    return tipo_usuario;
  }

  public void setTipo_usuario(int tipo_usuario) {
    this.tipo_usuario = tipo_usuario;
  }

}
