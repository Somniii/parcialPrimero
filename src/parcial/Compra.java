package parcial;

public class Compra extends Transacciones {
    private Tienda tienda;
    private Proveedor proveedor;

    public Compra() {
    }

    public Compra(Tienda tienda, Proveedor proveedor) {
        this.tienda = tienda;
        this.proveedor = proveedor;
    }

    public Compra(int id,int dni, Pedido pedido, String estado, String fechaPago, double montoTotal, Tienda tienda, Proveedor proveedor) {
        super(id, dni, pedido, estado, fechaPago, montoTotal);
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
