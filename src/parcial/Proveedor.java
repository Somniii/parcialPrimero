package parcial;

public class Proveedor extends  Empresa implements Facturacion, Comprador{
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


    @Override
    public void realizarPedido(Pedido pedido, Empresa empresa) {
        Pedido[] pedidoAuxiliar = pedidosTienda;
        for(int i = 0; i<pedidosTienda.length; i++){
            Pedido pedidoAux = pedidosTienda[i];
            if(pedidoAux == null){
                pedidosTienda[i] = pedido;
            }
        }
    }

    @Override
    public void emitirFactoura(Transacciones transacciones) {

    }
}
