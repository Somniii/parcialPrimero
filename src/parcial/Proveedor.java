package parcial;
import java.util.Scanner;
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
            Tienda tiendaAux = ((Compra) transacciones).getTienda();

            Pedido pedidoAux = transacciones.getPedido();
            pedidoAux.actualizarCotizacion();
            //COLOCAR LOS ARTICULOS INGRESADOS EN TIENDA QUE REALIZA LA TRANSACCION

            for (Articulo aux : pedidoAux.getArticulo()){
                //agregarArticulo(aux);
                tiendaAux.agregarArticulo(aux);
            }
            //TOTAL PARA EL MONTO TOTAL
            double totalParaMT = pedidoAux.getCotizacionTotal();
            transacciones.setPedido(pedidoAux);
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
            Transacciones[] transaccionAuxiliar = new Transacciones[tiendaAux.getTransaccion().length];
            transaccionAuxiliar = tiendaAux.getTransaccion();
            for(int i = 0; i <tiendaAux.getTransaccion().length;i++) {
                Transacciones transaccionRecorrer = tiendaAux.getTransaccion()[i];
                if (transaccionRecorrer == null) {
                    transaccionAuxiliar[i] = transacciones;
                }
                break;
            }
            tiendaAux.setTransaccion(transaccionAuxiliar);

        }
    }
    @Override
    public void despacharPedidos(Pedido [] pedidos){
        for(int i=0; i< pedidos.length;i++){
            Transacciones transAux = new Transacciones();
            Pedido pedidoAux = pedidos[i];
            transAux.setPedido(pedidoAux);
            transAux.setId(i);
            transAux.setEstado("Agregado");
            transAux.setMontoTotal(pedidoAux.getCotizacionTotal());
            transAux.setFechaPago("24/05/2024");
            emitirFactoura(transAux);
        }

    }



    @Override
    public void realizarPedido(Pedido pedido, Empresa empresa) {
        if(empresa instanceof Proveedor){
            for(int i = 0; i< pedidosTienda.length; i++){
                if(((Proveedor) empresa).pedidosTienda[i]==null){
                    ((Proveedor) empresa).pedidosTienda[i]=pedido;
                    break;
                }
            }
        }
    }


}
