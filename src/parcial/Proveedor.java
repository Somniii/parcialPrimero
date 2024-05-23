package parcial;

public class Proveedor extends  Empresa{
    private String nombreContancto,telefonoContacto;
    private Pedido[] pedidosTienda;

    public Proveedor() {
    }

    public Proveedor(String nombre, String cuit, String nombreContancto, String telefonoContacto, Pedido[] pedidosTienda) {
        super(nombre, cuit);
        this.nombreContancto = nombreContancto;
        this.telefonoContacto = telefonoContacto;
        this.pedidosTienda = pedidosTienda;
    }

    public String getNombreContancto() {
        return nombreContancto;
    }

    public void setNombreContancto(String nombreContancto) {
        this.nombreContancto = nombreContancto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public Pedido[] getPedidosTienda() {
        return pedidosTienda;
    }

    public void setPedidosTienda(Pedido[] pedidosTienda) {
        this.pedidosTienda = pedidosTienda;
    }
}
