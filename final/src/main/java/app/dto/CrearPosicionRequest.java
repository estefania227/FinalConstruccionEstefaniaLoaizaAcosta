package app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CrearPosicionRequest {
    @NotNull
    private Long pilarId;
    @NotNull
    private Integer posX;
    @NotNull
    private Integer posY;
    @NotBlank
    private String estado;

    public CrearPosicionRequest() {}

    public Long getPilarId() { return pilarId; }
    public void setPilarId(Long pilarId) { this.pilarId = pilarId; }
    public Integer getPosX() { return posX; }
    public void setPosX(Integer posX) { this.posX = posX; }
    public Integer getPosY() { return posY; }
    public void setPosY(Integer posY) { this.posY = posY; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
