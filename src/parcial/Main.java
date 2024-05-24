package parcial;

import javax.swing.JOptionPane;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

    }





    public static  void mostrarInventario(Tienda t){
        for(Articulo auxArt : t.getInventario()){
            System.out.println("Codigo del producto" +auxArt.getId());
            System.out.println("Nombre del prodcuto"+auxArt.getNombre());
            System.out.println("Precio del producto" +auxArt.getPrecio());
        }
    }
    public static Pedido cargarPedido(Scanner scan, Tienda t){
        mostrarInventario(t);
        Pedido pedidoCliente = new Pedido();
        System.out.println("Ingrese la codigo del articulo que desea comprar");
        pedidoCliente.setId(scan.nextInt());
        for(Articulo auxArt : t.getInventario()){
            if(pedidoCliente.getId()==auxArt.getId()){
                pedidoCliente.setArticulo();
            }
        }

    }
    public int menuAdministrador(Scanner scan){
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
    public int menuManual(Scanner scan){
        System.out.println("Ingrese una el ");
    }
    public void comprobacionAutomatica(){
        for()
        Articulo articulo = new Articulo()[];
        Tienda nuevaTienda = new Tienda("Coto","204250252",5,,,)
    }


}

