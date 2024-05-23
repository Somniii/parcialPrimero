package parcial;


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


}

