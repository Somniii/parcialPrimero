package parcial;


public class Tienda extends Empresa implements Comprador, Facturacion {
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

    public void agregarArticulo(Articulo articulo){
        System.out.println("ENTRANDO A LA FUNCION ELIMINAR ARTICULO\n");
<<<<<<< HEAD
        for(int i=0;i< inventario.length;i++){
            Articulo artAux = inventario[i];
=======
        for(int i = 0; i < inventario.length ; i++){
            Articulo inventarioRecorrida = inventario[i];
            if(inventarioRecorrida == null){
                //VERIFICAR POR TIPO DE ARTICULO FALTA SETEARLO
                inventario[i] = articulo;
            }
            break;
            //VER DE ALGUNA MANERA SI NO SE PUDO AGREGAR POR EL TAMANIO DEL ARREGLO
>>>>>>> b3882ecd574acfc6cbe010e30809c6ba44eb81a1
        }
    }
    public void eliminarArticulo(Articulo articulo){
        System.out.println("ENTRANDO A LA FUNCION ELIMINAR ARTICULO");
        for(int i = 0; i < inventario.length ; i++){
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
<<<<<<< HEAD
=======
        return articuloAEnviar;

>>>>>>> b3882ecd574acfc6cbe010e30809c6ba44eb81a1
    }

    //EMITIR FACTURA REPERCUTE EN LA CANTIDAD DE ARTICULOS DE TIENDA PONER EL VOID DE ELIMINAR O AGREGAR ARTICULO
    //CORRESPONDIENTE
    //AFECTA UNA PARTE A PROVEEDOR Y OTRA A CLIENTE , OSEA HAY DOS FACTURAS UNA DE COMPRA Y OTRA DE VENTA
    //FIJARSE EN EL MAIN CON INSTANCE OF
    public void emitirFactoura(Transacciones transacciones) {
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
            Transacciones transaccionAuxiliar = new Transacciones(transacciones.getId(), transacciones.getDni() , transacciones.getPedido(), transacciones.getEstado(),transacciones.getFechaPago(), montoTotal);
            for(int i = 0; i <getTransaccion().length;i++){
                Transacciones transaccionRecorrer = getTransaccion()[i];
                if(transaccionRecorrer == null){
                   transaccion[i] = transaccionAuxiliar;
                }
            }
        }

    }

    @Override
<<<<<<< HEAD
    public void despacharPedidos(Pedido [] pedidos) {
        for (int i = 0; i < pedidos.length; i++) {
            Pedido pedidoCliente = pedidos[i];
            Articulo artAux = pedidoCliente.getArticulo()[i];
            if (buscarArticulo(artAux)==pedidoCliente.getArticulo()[i]){

            }
        }
    }
=======
    public  void realizarPedido(Pedido pedido, Empresa empresa){
        
    }

>>>>>>> b3882ecd574acfc6cbe010e30809c6ba44eb81a1
}




