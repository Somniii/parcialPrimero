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
        System.out.println();
        Pedido auxPedido = transacciones.getPedido();
        System.out.println("PEDIDO NUMERO:" + auxPedido.getId() + "" +
                "\nCANTIDAD DE ARTICULOS:" + auxPedido.getArticulo().length + "\n" +
                "ESTADO "+transacciones.getEstado()+"\nFECHA PAGO:"+transacciones.getFechaPago()+"\n");
        //int tamanioPedido = auxPedido.getArticulo().length;
        double montoTotal = 0;
        for (Articulo aux : auxPedido.getArticulo()){
            System.out.println("NOMBRE ARTICULO:" + aux.getNombre());
            montoTotal = montoTotal + aux.getPrecio();
        }
            double cotizacionTotal = montoTotal;
        if(montoTotal <100000){
            montoTotal = montoTotal*0.05;
        }
        else if(montoTotal >100000 && montoTotal <600000){
            montoTotal = montoTotal*0.10;
        }
        else if(montoTotal >600000 && montoTotal <1200000){
            montoTotal = montoTotal*0.20;
        }
        else if(montoTotal>1200000){
            montoTotal = montoTotal*0.30;
        }
        transacciones.setMontoTotal(montoTotal);
        System.out.println("Cotizacion total = "+cotizacionTotal);
        System.out.println("MONTO TOTAL CON DESCUENTO="+montoTotal);
        Pedido pedidoAuxiliar = new Pedido(auxPedido.getId(),auxPedido.getArticulo(),cotizacionTotal,auxPedido.getFechaCotizacion());
        Transacciones transaccionAuxiliar = new Transacciones(transacciones.getId(), transacciones.getDni() , pedidoAuxiliar, transacciones.getEstado(),transacciones.getFechaPago(), montoTotal);

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
