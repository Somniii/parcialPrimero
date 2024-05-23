package parcial;

public class Venta extends Transacciones{
    private Tienda tienda;
    private Proveedor proveedor;

    public Venta() {
    }

    public Venta(Tienda tienda, Proveedor proveedor) {
        this.tienda = tienda;
        this.proveedor = proveedor;
    }

    public Venta(int dni, Pedido pedido, String estado, String fechaPago, double montoTotal, Tienda tienda, Proveedor proveedor) {
        super(dni, pedido, estado, fechaPago, montoTotal);
        this.tienda = tienda;
        this.proveedor = proveedor;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
