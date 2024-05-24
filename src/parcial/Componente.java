package parcial;

public class Componente extends Articulo{
    private String marca;

    public Componente() {
    }

    public Componente(int id, String nombre, double precio, String marca) {
        super(id, nombre, precio);
        this.marca = marca;
    }



    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    @Override
    public String toString(){
        return "-----------------------" +
                "----\n\"COMPONENTE:\nID:"+getId()+"\nMARCA:"+getMarca()+"\nNOMBRE:"+getNombre()+"\nPRECIO"+getPrecio();
    }
}
