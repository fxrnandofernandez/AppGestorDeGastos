import java.util.ArrayList;
public class HistorialDeGastos{
    private ArrayList<Gasto> listaDeGastos = new ArrayList<>(); 
    public void agregarGasto(Gasto gastoNuevo){
        listaDeGastos.add(gastoNuevo);
    }
    
    public String eliminarGasto(int posicion){
        if(getTamanio() == 0){
            return "Historial vacío";
        }
        if(posicion < 0 || posicion >= getTamanio()){
           return "Posicion invalida";
        }else{
            listaDeGastos.remove(posicion);
            return "Gasto Eliminado";
        }
      }
    
    public int getTamanio(){
        return listaDeGastos.size();
    }
    
    
    //funcion13
    
    public ArrayList<Gasto> filtrarPorRango(String inicio, String fin) {
        ArrayList<Gasto> listaDeGastosFiltrados = new ArrayList<>();
        int desde = convertir(inicio);
        int hasta = convertir(fin);

        for (int indice = 0; indice < listaDeGastos.size(); indice++) {
            Gasto gasto = listaDeGastos.get(indice);
            int fechaDelGasto = convertir(gasto.getFechaDelGasto());

            if (fechaDelGasto >= desde && fechaDelGasto <= hasta) {
                listaDeGastosFiltrados.add(gasto);
            }
        }
        return listaDeGastosFiltrados;
    }
    private int convertir(String fecha) {
        return obtenerAnio(fecha) * 10000 + obtenerMes(fecha) * 100 + obtenerDia(fecha);
    }
    public String validarPorRango(String inicio, String fin){
        if (!esFechaValida(inicio) || !esFechaValida(fin)) {
            return "Fecha incorrecta";
        }
        if (convertir(inicio) > convertir(fin)) {
            return "Rango invalido";
        }
        return "Rango valido";
    }
    private boolean esFechaValida(String fecha){
        int dia = obtenerDia(fecha);
        int mes = obtenerMes(fecha);
        return mes >= 1 && mes <= 12 && dia >= 1 && dia <= 31;
    }
    private int obtenerDia(String fecha) {
         return Integer.parseInt(fecha.substring(0, 2));
    }
    private int obtenerMes(String fecha) {
        return Integer.parseInt(fecha.substring(3, 5));
    }
    private int obtenerAnio(String fecha) {
        return Integer.parseInt(fecha.substring(6, 10));
    }
    
    //funcion14
    
    public String sugerirCategoria(String descripcion){
        String sugerencia = "";
        int mayorCantidad = 0;

        for(int indice = 0; indice < listaDeGastos.size(); indice++){
            Gasto gasto = listaDeGastos.get(indice);
            
            if(tieneDescripcion(gasto, descripcion) && !gasto.getCategoria().isEmpty()){
                int cantidad = contarCategoria(descripcion, gasto.getCategoria());
                if(cantidad > mayorCantidad){
                    mayorCantidad = cantidad;
                    sugerencia = gasto.getCategoria();
                }
            }           
        }
        return sugerencia;
    }
    private int contarCategoria(String descripcion, String categoria){
        int cantidad = 0;
        for(int indice = 0; indice < listaDeGastos.size(); indice++){
            Gasto gasto = listaDeGastos.get(indice);
            if(tieneDescripcion(gasto, descripcion) && gasto.getCategoria().equals(categoria)){
                cantidad++;
            }
        }
        return cantidad;
    }
    private boolean tieneDescripcion(Gasto gasto, String descripcion){
        return gasto.getDescripcion().equals(descripcion);
    }
}

