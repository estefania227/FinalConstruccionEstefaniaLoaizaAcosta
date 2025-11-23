package app.dto;

public class TriangulacionResponse {
    private Double posX;
    private Double posY;
    private Double nivelConfianza; // 0 - 1
    private String descripcion;

    public TriangulacionResponse() {}

    public TriangulacionResponse(Double posX, Double posY, Double nivelConfianza, String descripcion) {
        this.posX = posX; this.posY = posY; this.nivelConfianza = nivelConfianza; this.descripcion = descripcion;
    }

    public Double getPosX() { return posX; }
    public void setPosX(Double posX) { this.posX = posX; }
    public Double getPosY() { return posY; }
    public void setPosY(Double posY) { this.posY = posY; }
    public Double getNivelConfianza() { return nivelConfianza; }
    public void setNivelConfianza(Double nivelConfianza) { this.nivelConfianza = nivelConfianza; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
