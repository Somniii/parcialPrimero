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
        for(Articulo aux: inventario){
            if(aux == null){
                //VERIFICAR POR TIPO DE ARTICULO FALTA SETEARLO
                aux = new Articulo(articulo.getId(),articulo.getNombre(),articulo.getPrecio());
            }
            //VER DE ALGUNA MANERA SI NO SE PUDO AGREGAR POR EL TAMANIO DEL ARREGLO
        }
    }
    public void eliminarArticulo(Articulo articulo){
        System.out.println("ENTRANDO A LA FUNCION ELIMINAR ARTICULO");
        for(Articulo aux: inventario){
            if(aux.getId() == articulo.getId()){
                //Ya con esto se esta seteando?
                //ELIMINAR EL ARTICULO PONIENDOLO A 0 , O SINO PONERLE AUX = null
                aux = null;

            }
            //LO ROMPO PARA QUE NO SIGA ELIMINANDO
            break;
        }
    }
    public Articulo buscarArticulo(String nombreBuscar){
        if(inventario != null){
            for(Articulo aux: inventario){
                if(aux.getNombre()==nombreBuscar){
                    System.out.println("Se econtro el articulo");
                    //retornar eso con un articulo auxiliar
                    return new Articulo(aux.getId(), aux.getNombre(), aux.getPrecio());
                }
                break;
            }
        }
        else{
            //retornar un articulo vacio
            System.out.println("El inventario esta vacio");
        }

    }
    //EMITIR FACTURA REPERCUTE EN LA CANTIDAD DE ARTICULOS DE TIENDA PONER EL VOID DE ELIMINAR O AGREGAR ARTICULO
    //CORRESPONDIENTE
    //AFECTA UNA PARTE A PROVEEDOR Y OTRA A CLIENTE , OSEA HAY DOS FACTURAS UNA DE COMPRA Y OTRA DE VENTA
    //FIJARSE EN EL MAIN CON INSTANCE OF
    public void emitirFactoura(Transacciones transacciones) {
        System.out.println("----EMITIENDO FACTURA DE TIENDA----");
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
            eliminarArticulo(aux);
        }
        transacciones.setMontoTotal(montoTotal);
        System.out.println("MONTO TOTAL/COTIZACION TOTAL ="+montoTotal);

        Transacciones transaccionAuxiliar = new Transacciones(transacciones.getId(), transacciones.getDni() , transacciones.getPedido(), transacciones.getEstado(),transacciones.getFechaPago(), montoTotal);
    }
    //ESTA FUNCION AGREGA CON UNA TRANSACCION LOS PEDIDOS A LA TIENDA
    public void agregarTransacciones(Transacciones transacciones){
        for(Transacciones aux : transaccion){
            if(aux == null){
                aux = transacciones;
            }
        }
        Pedido pedidoAux = transacciones.getPedido();

        //INVENTARIO TIENDA
        for(Articulo aux : inventario){
            //TRANSACCIONES
            for(Articulo aux2 : pedidoAux.getArticulo()){
                agregarArticulo(aux2);
            }

        }
    }
    @Override
    public void despacharPedidos(Pedido [] pedidos){

    }
    }

}
