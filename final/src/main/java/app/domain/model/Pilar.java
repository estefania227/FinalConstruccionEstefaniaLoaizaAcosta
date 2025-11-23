package app.domain.model;

public class Pilar {
    private Long id;
    private String nombre;
    private Integer posX;
    private Integer posY;
    private String estado;

    public Pilar() {}

    public Pilar(Long id, String nombre, Integer posX, Integer posY, String estado) {
        this.id = id; this.nombre = nombre; this.posX = posX; this.posY = posY; this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getPosX() { return posX; }
    public void setPosX(Integer posX) { this.posX = posX; }
    public Integer getPosY() { return posY; }
    public void setPosY(Integer posY) { this.posY = posY; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
