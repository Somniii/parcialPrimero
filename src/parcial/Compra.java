package parcial;

public class Compra extends Transacciones {
    private Tienda tienda;
    private  Cliente cliente;

    public Compra() {
    }

    public Compra(Tienda tienda, Cliente cliente) {
        this.tienda = tienda;
        this.cliente = cliente;
    }

    public Compra(int dni, Pedido pedido, String estado, String fechaPago, double montoTotal, Tienda tienda, Cliente cliente) {
        super(dni, pedido, estado, fechaPago, montoTotal);
        this.tienda = tienda;
        this.cliente = cliente;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
