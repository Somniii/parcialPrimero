package parcial;

public class Pedido {

    private int id;
    private Articulo[] articulo;
    private double cotizacionTotal;
    private String fechaCotizacion;

    public Pedido() {
    }

    public Pedido(int id, Articulo[] articulo, double cotizacionTotal, String fechaCotizacion) {
        this.id = id;
        this.articulo = articulo;
        this.cotizacionTotal = cotizacionTotal;
        this.fechaCotizacion = fechaCotizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Articulo[] getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo[] articulo) {
        this.articulo = articulo;
    }

    public double getCotizacionTotal() {
        return cotizacionTotal;
    }

    public void setCotizacionTotal(double cotizacionTotal) {
        this.cotizacionTotal = cotizacionTotal;
    }

    public String getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(String fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }
}
