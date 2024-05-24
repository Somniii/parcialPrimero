package parcial;

import javax.swing.JOptionPane;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        comprobacionAutomatica();
    }





    public static  void mostrarInventario(Tienda t){
        for(Articulo auxArt : t.getInventario()){
            System.out.println("Codigo del producto" +auxArt.getId());
            System.out.println("Nombre del prodcuto"+auxArt.getNombre());
            System.out.println("Precio del producto" +auxArt.getPrecio());
        }
    }
    /*public static Pedido cargarPedido(Scanner scan, Tienda t){
        mostrarInventario(t);
        Pedido pedidoCliente = new Pedido();
        System.out.println("Ingrese la codigo del articulo que desea comprar");
        pedidoCliente.setId(scan.nextInt());
        for(Articulo auxArt : t.getInventario()){
            if(pedidoCliente.getId()==auxArt.getId()){
                pedidoCliente.setArticulo();
            }
        }

    }*/
    public static int menuAdministrador(Scanner scan){
        System.out.println("Bienvenido al menu de administrador" +
                "\n¿Que desea realizar?\n1.Comprobacion Automatica del codigo" +
                "\n2.Comprobacion manual del codigo");
                int opc = scan.nextInt();
                while(opc != 1 && opc != 2){
                    System.out.println("Ingreso una opcion incorrecta");
                    System.out.println("¿Que desea realizar?\n1.Comprobacion Automatica del codigo" +
                            "\n2.Comprobacion manual del codigo");
                    opc = scan.nextInt();
                }
                return opc;


    }
    public static int menuManual(Scanner scan){
        System.out.println("Ingrese una el ");
        return 0;
    }
    public static void comprobacionAutomatica(){
        Articulo[] articulo = new Articulo[6];
        articulo[0] = new Computadora(123,"HiviksonPro",900,"Asu","32 gb Ram");
        articulo[1] = new Computadora(124,"HiviksonProMax",1800,"Asu","64 gb Ram");
        articulo[2] = new Computadora(125,"Hivikson",450,"Asu","16 gb Ram");
        articulo[3] = new Periferico(126,"Headphone",50,"Asu","Auricular");
        articulo[4] = new Periferico(127,"G203",100,"Kimovil","Mouse");
        articulo[5] = new Computadora(128,"Viksivon",242,"Usa","2 gb Ram");
        Pedido[] pedido =  new Pedido[4];
        for(int i = 0 ; i < 4; i++){
            pedido[i] = null;
        }
        Transacciones[] transaccion =  new Transacciones[4];
        for(int i = 0 ; i < 4; i++){
            transaccion[i] = null;
        }
        //PARTE DE CLIENTE
        Tienda nuevaTienda = new Tienda("Coto","204250252",5,articulo,pedido,transaccion);
        Cliente cliente = new Cliente("pepe", "perez", 23531332);
        //Creamos un pedido que se pueda realizar
        Articulo[] articuloPedido = new Articulo[1];
        articulo[0]= new Periferico(126,"Headphone",50,"Asu","Auricular");
        articulo[1]= new Computadora(125,"Hivikson",450,"Asu","16 gb Ram");
        //La cotizacion total hacerla con la funcion
        //NO SE COMO REALIZAR EL PEDIDO , COMO CREARLO SI APARTIR DE VENTA O DE PEDIDO
        Pedido pedidoCliente = new Pedido(1,articuloPedido,50,"24/5/2024");
        cliente.realizarPedido(pedidoCliente, nuevaTienda);
        Venta nuevaVenta = new Venta(nuevaTienda, cliente);
        //El array de pedidos pasa a transacciones
        nuevaTienda.despacharPedidos(nuevaTienda.getPedidoCliente());

    }


}

