package parcial;

public class Cliente implements Comprador{
    private String nombre, apellido;
    private int documento;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, int documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public void setDocumento(int documento) {
        this.documento = documento;
    }

    @Override
    public void realizarPedido(Pedido pedido, Empresa empresa){
        if(empresa instanceof Tienda){
            if(((Tienda) empresa).getPedidoCliente()!=null){
                Pedido[] pediAux = ((Tienda) empresa).getPedidoCliente();
                for(int i=0; i<((Tienda) empresa).getPedidoCliente().length;i++){
                    if(((Tienda) empresa).getPedidoCliente()[i]==null){
                        pediAux[i]=pedido;
                        ((Tienda) empresa).setPedidoCliente(pediAux);
                    }
                }
            }

        }
    }
}
