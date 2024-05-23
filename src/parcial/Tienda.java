package parcial;


public class Tienda extends Empresa implements Comprador{
    private int sucursal;
    private Articulo[] inventario;
    private Pedido[] pedidoCliente;
    private Transacciones[] transaccion;


    public Tienda() {
    }

    public Tienda(String nombre, String cuit, int sucursal, Articulo[] inventario, Pedido[] pedidoCliente, Transacciones[] transaccion) {
        super(nombre, cuit);
        this.sucursal = sucursal;
        this.inventario = inventario;
        this.pedidoCliente = pedidoCliente;
        this.transaccion = transaccion;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public Articulo[] getInventario() {
        return inventario;
    }

    public void setInventario(Articulo[] inventario) {
        this.inventario = inventario;
    }

    public Pedido[] getPedidoCliente() {
        return pedidoCliente;
    }

    public void setPedidoCliente(Pedido[] pedidoCliente) {
        this.pedidoCliente = pedidoCliente;
    }

    public Transacciones[] getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transacciones[] transaccion) {
        this.transaccion = transaccion;
    }



    public static void eliminarArticulo(Articulo articulo){
        System.out.println("Que articulo desea eliminar?");


    }
}
