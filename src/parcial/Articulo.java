package parcial;

public class Articulo {
    private int id;
    private String nombre;
    private double precio;

    public Articulo() {
    }

    public Articulo(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }



    public String getNombre() {
        return nombre;
    }



    public double getPrecio() {
        return precio;
    }

    public String toString(){
        return "-----------------------" +
                "----\n\"ARTICULO:\nID:"+getId()+"\nNOMBRE:"+getNombre()+"\nPRECIO"+getPrecio();
    }
}
