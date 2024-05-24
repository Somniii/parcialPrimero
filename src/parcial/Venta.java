package parcial;

public class Venta extends Transacciones{
    private Tienda tienda;
    private Cliente cliente;

    public Venta() {
    }

    public Venta(Tienda tienda, Cliente cliente) {
        this.tienda = tienda;
        this.cliente = cliente;
    }
    //VENTA ES DE TIENDA A CLIENTE
    public Venta(int id, int dni, Pedido pedido, String estado, String fechaPago, double montoTotal, Tienda tienda, Cliente cliente ) {
        super(id, dni, pedido, estado, fechaPago, montoTotal);
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
