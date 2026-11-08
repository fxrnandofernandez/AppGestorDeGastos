/** Un gasto conserva el identificador del usuario al que pertenece. */
public class Gasto
{
    private Dinero monto;
    private String descripcion;
    private String fechaDelGasto;
    private String categoria;
    private int idUsuario;

    /** Constructor compatible con los gastos sin categoría. */
    public Gasto(Dinero monto, String descripcion, int idUsuario) {
        this(monto, descripcion, "", idUsuario);
    }

    public Gasto(Dinero monto, String descripcion, String categoria, int idUsuario) {
        this(monto, descripcion, Fecha.obtenerFechaYHora(), categoria, idUsuario);
    }

    /** Permite recuperar la fecha original al leer un registro. */
    public Gasto(Dinero monto, String descripcion, String fechaDelGasto,
                 String categoria, int idUsuario) {
        this.monto = java.util.Objects.requireNonNull(monto, "El monto es obligatorio");
        this.descripcion = java.util.Objects.requireNonNull(descripcion, "La descripción es obligatoria");
        this.fechaDelGasto = java.util.Objects.requireNonNull(fechaDelGasto, "La fecha es obligatoria");
        this.categoria = java.util.Objects.requireNonNull(categoria, "La categoría es obligatoria");
        this.idUsuario = idUsuario;
    }

    public Dinero getMonto() { return monto; }
    public String getDescripcion() { return descripcion; }
    public String getFechaDelGasto() { return fechaDelGasto; }
    public String getCategoria() { return categoria; }
    public int getIdUsuario() { return idUsuario; }

    public String obtenerInformacionCompleta() {
        return monto + ", " + descripcion + ", " + fechaDelGasto + ", " + categoria + ", " + idUsuario;
    }

    @Override
    public String toString() {
        return monto + ", " + descripcion + ", " + (categoria.isEmpty() ? idUsuario : categoria);
    }
}
