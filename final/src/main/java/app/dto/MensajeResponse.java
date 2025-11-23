package app.dto;

import java.time.LocalDateTime;

public class MensajeResponse {
    private Long id;
    private Long pilarId;
    private String contenidoFragmentado;
    private String contenidoReconstruido;
    private LocalDateTime timestamp;

    public MensajeResponse() {}

    public MensajeResponse(Long id, Long pilarId, String contenidoFragmentado, String contenidoReconstruido, LocalDateTime timestamp) {
        this.id = id;
        this.pilarId = pilarId;
        this.contenidoFragmentado = contenidoFragmentado;
        this.contenidoReconstruido = contenidoReconstruido;
        this.timestamp = timestamp;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPilarId() { return pilarId; }
    public void setPilarId(Long pilarId) { this.pilarId = pilarId; }
    public String getContenidoFragmentado() { return contenidoFragmentado; }
    public void setContenidoFragmentado(String contenidoFragmentado) { this.contenidoFragmentado = contenidoFragmentado; }
    public String getContenidoReconstruido() { return contenidoReconstruido; }
    public void setContenidoReconstruido(String contenidoReconstruido) { this.contenidoReconstruido = contenidoReconstruido; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
