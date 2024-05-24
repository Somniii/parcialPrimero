package parcial;


public class Tienda extends Empresa implements Comprador, Facturacion {
    private int sucursal;
    private Articulo[] inventario;
    private Pedido[] pedidoCliente;
    private Transacciones[] transaccion;
    private static int sumadorIdTransaccion = 0;



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

    public void agregarArticulo(Articulo articulo){
        System.out.println("ENTRANDO A LA FUNCION ELIMINAR ARTICULO\n");
        for(int i = 0; i < inventario.length ; i++){
            Articulo inventarioRecorrida = inventario[i];
            if(inventarioRecorrida == null){
                //VERIFICAR POR TIPO DE ARTICULO FALTA SETEARLO
                inventario[i] = articulo;
            }
            break;
            //VER DE ALGUNA MANERA SI NO SE PUDO AGREGAR POR EL TAMANIO DEL ARREGLO
        }
    }
    public void eliminarArticulo(Articulo articulo){
        System.out.println("ENTRANDO A LA FUNCION ELIMINAR ARTICULO");
        for(int i = 0; i < inventario.length ;i++){
            Articulo inventarioAuxiliar =  inventario[i];
            if(inventarioAuxiliar.getId() == articulo.getId()){
                //ELIMINAR EL ARTICULO PONIENDOLO A 0 , O SINO PONERLE AUX = null
                inventario[i] = null;
            }
            //LO ROMPO PARA QUE NO SIGA ELIMINANDO
            break;
        }
    }
    public Articulo buscarArticulo(String nombreBuscar){
        Articulo articuloAEnviar = new Articulo();
        if(inventario != null){

            for(Articulo aux: inventario){
                if(aux.getNombre()==nombreBuscar){
                    //retornar eso con un articulo auxiliar
                    articuloAEnviar = aux;
                    break;
                }
                //Si no se encontraron articulos retorna null
            }
        }
        else{
            //retornar un articulo vacio
            System.out.println("El inventario esta vacio");
            articuloAEnviar=null;
        }
        return articuloAEnviar;

    }

    //EMITIR FACTURA REPERCUTE EN LA CANTIDAD DE ARTICULOS DE TIENDA PONER EL VOID DE ELIMINAR O AGREGAR ARTICULO
    //CORRESPONDIENTE
    //AFECTA UNA PARTE A PROVEEDOR Y OTRA A CLIENTE , OSEA HAY DOS FACTURAS UNA DE COMPRA Y OTRA DE VENTA
    //FIJARSE EN EL MAIN CON INSTANCE OF
    public void emitirFactura(Transacciones transacciones) {
        System.out.println("----EMITIENDO FACTURA DE TIENDA----");

        if(transacciones instanceof Venta){
            Tienda tiendaAux = ((Venta) transacciones).getTienda();
            //Aca abajo tengo que colocar la transaccion hecha en la tienda
            Pedido auxPedido = transacciones.getPedido();
            auxPedido.actualizarCotizacion();
            double montoTotal = auxPedido.getCotizacionTotal();
            //Este for elimina los articulos que se van encontrando que son iguales a los que pide el cliente
            for (Articulo aux : auxPedido.getArticulo()){
                //eliminarArticulo(aux);
                tiendaAux.eliminarArticulo(aux);
            }
            transacciones.setPedido(auxPedido);
            transacciones.setMontoTotal(montoTotal);
            //esta es la transaccion que se pone en la tienda
            //NO SE PONEN LAS TRANSACCIONES DE LA TIENDA EN EMITIR FACTURA
            Transacciones transaccionAuxiliar = new Transacciones(transacciones.getId(), transacciones.getPedido(), transacciones.getEstado(),transacciones.getFechaPago(), montoTotal);
            for(int i = 0; i <getTransaccion().length;i++){
                //ESTO BUSCA EL IDENTIFICADOR DE LA TRANSACCIONS QUE SE ESTA AÑADIENDO EL MONTO TOTAL Y LUEGO SE LO AGREGA
                Transacciones transaccionRecorrer = getTransaccion()[i];
                /*if(transaccionRecorrer.getId() == transacciones.getId()){
                   transaccion[i] = transaccionAuxiliar;
                }*/
                if(transaccionRecorrer == null ){
                    transaccion[i] = transaccionAuxiliar;
                    break;
                }
            }
        }

    }

    @Override
    public void realizarPedido(Pedido pedido, Empresa empresa) {
        if(empresa instanceof Tienda){
            for(int i=0;i< pedidoCliente.length;i++){
                ((Tienda) empresa).pedidoCliente[i]=pedido;
            }
        }
    }
//DIVIDIRLO EN DOS PARTES PARA PODER CREAR LA TRANSACCION DE TIPO VENTA Y PASARLO A EL EMITIR FACTURA
    @Override
    /*public void despacharPedidos(Pedido[] pedidos){
        int comprobacion = 0;
        for (int i = 0; i < pedidos.length; i++) {
            Pedido pedidoAux = pedidos[i];
            for(int z = 0; z< pedidoAux.getArticulo().length; z++){
                Articulo artAux = pedidoAux.getArticulo()[z];
                if(buscarArticulo(artAux.getNombre())!=null){
                    comprobacion++;
                }
                if(comprobacion== pedidoAux.getArticulo().length){
                    pedidoCliente[i]=pedidoAux;
                    sumadorIdTransaccion++;
                    Transacciones transaccionAEnviar = new Transacciones(sumadorIdTransaccion,pedidoAux,"ENTREGADO","24/5/2024",0);
                    //LA BUSCO EN TIENDA POR EL ID, LA MODIFICO CON EMITIR FACTURA Y LA REMPLAZO POR UNA DE TIPO VENTA
                    for(int j = 0; i <getTransaccion().length;j++){
                        Transacciones transaccionRecorrer = getTransaccion()[i];
                        if(transaccionRecorrer == null ){
                            transaccion[i] = transaccionAEnviar;
                            break;
                        }
                    }
                    //LO BUSCO EN EL MAIN Y LE PASO EMITIR FACTURA CON LA VENTA emitirFactura(transaccionAEnviar);
                }
                else if(comprobacion != pedidoAux.getId()&&z==pedidoAux.getArticulo().length){
                    //EN CASO QUE SEA CANCELADO SE ENVIA CANCELADO
                    Transacciones transaccionAEnviar = new Transacciones(sumadorIdTransaccion,pedidoAux,"CANCELADO","24/5/2024",0);
                    for(int j = 0; i <getTransaccion().length;j++){
                        Transacciones transaccionRecorrer = getTransaccion()[i];
                        if(transaccionRecorrer == null ){
                            transaccion[i] = transaccionAEnviar;
                            break;
                        }
                    }
                    //lo mismo emitirFactura(transaccionAEnviar);
                }
            }

        }
    }*/
    public void despacharPedidos(Pedido[] pedidos) {
        int comprobacion = 0;
        for (int i = 0; i < pedidos.length; i++) {
            Pedido pedidoAux = pedidos[i];
            for (int z = 0; z < pedidoAux.getArticulo().length; z++) {
                Articulo artAux = pedidoAux.getArticulo()[z];
                if (buscarArticulo(artAux.getNombre()) != null) {
                    comprobacion++;
                }
                if (comprobacion == pedidoAux.getArticulo().length) {
                    pedidoCliente[i] = pedidoAux;
                    sumadorIdTransaccion++;
                    Transacciones transaccionAEnviar = new Transacciones(sumadorIdTransaccion, pedidoAux, "ENTREGADO", "24/5/2024", 0);
                    emitirFactura(transaccionAEnviar);
                } else if (comprobacion != pedidoAux.getId() && z == pedidoAux.getArticulo().length) {
                    //EN CASO QUE SEA CANCELADO SE ENVIA CANCELADO
                    Transacciones transaccionAEnviar = new Transacciones(sumadorIdTransaccion, pedidoAux, "CANCELADO", "24/5/2024", 0);
                    emitirFactura(transaccionAEnviar);
                }
            }
        }


    
    }
}




