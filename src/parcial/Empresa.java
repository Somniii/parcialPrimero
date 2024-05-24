package parcial;

public class Empresa {
    private  String nombre,cuit;

    public Empresa() {
    }

    public Empresa(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void despacharPedidos(Pedido [] pedidos){

    }
}
