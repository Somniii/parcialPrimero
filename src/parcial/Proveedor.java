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
    //FALTA EL ESTADO QUE LUEGO SE METE ADENTRO
    public void emitirFactoura(Transacciones transacciones) {
        System.out.println("----EMITIENDO FACTURA DE PROVEEDOR----");
        if(transacciones instanceof  Compra){
            Pedido pedidoAux = transacciones.getPedido();
            pedidoAux.actualizarCotizacion();
            //TOTAL PARA EL MONTO TOTAL
            double totalParaMT = pedidoAux.getCotizacionTotal();
            transacciones.setPedido(pedidoAux);
            double montoTotal = 0;
            if(totalParaMT <100000){
                transacciones.setMontoTotal(totalParaMT*0.05);
            }
            else if(totalParaMT >100000 && totalParaMT <600000){
                transacciones.setMontoTotal(totalParaMT*0.10);
            }
            else if(totalParaMT >600000 && totalParaMT <1200000){
                transacciones.setMontoTotal(totalParaMT*0.20);
            }
            else if(totalParaMT>1200000){
                transacciones.setMontoTotal(totalParaMT*0.30);
            }
        }
    }
    @Override
    public void despacharPedidos(Pedido [] pedidos){

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


}
