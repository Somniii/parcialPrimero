package parcial;

public class Transacciones {
    private int dni;
    private Pedido pedido;
    private String estado;
    private String fechaPago;
    private double montoTotal;

    public Transacciones() {
    }

    public Transacciones(int dni, Pedido pedido, String estado, String fechaPago, double montoTotal) {
        this.dni = dni;
        this.pedido = pedido;
        this.estado = estado;
        this.fechaPago = fechaPago;
        this.montoTotal = montoTotal;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
