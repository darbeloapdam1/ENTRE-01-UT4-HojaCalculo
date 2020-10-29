
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author -  Diego Arbeloa
 *  
 */
public class HojaCalculo
{
    private String nombre;
    private Fila fila1;
    private Fila fila2;
    private Fila fila3;

    /**
     * Constructor  
     * Crea la hoja de cálculo con el nombre indicado 
     * e inicializa las filas al valor null (inicialmente
     * la hoja se crea sin filas)
     */
    public HojaCalculo(String nombre)    {
        this.nombre = nombre;
        this.fila1 = null;
        this.fila1 = null;
        this.fila1 = null;

    }

    /**
     * accesor para el nombre de la hoja
     */
    public String getNombre() {
        return this.nombre;

    }

    /**
     * accesor para la fila1
     */
    public Fila getFila1() {
        return fila1;

    }

    /**
     * accesor para la fila2
     */
    public Fila getFila2() {
        return fila2;

    }

    /**
     * accesor para la fila3
     */
    public Fila getFila3() {
        return fila3;

    }

    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {
        int contador = 0;
        if(getFila1() == null){
            contador++;
        }
        if(getFila2() == null){
            contador++;
        }
        if(getFila3() == null){
            contador++;
        }
        return contador;

    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        boolean completa = true;
        if(getFila1() == null){
            completa = false;
        }
        if(getFila2() == null){
            completa = false;
        }
        if(getFila3() == null){
            completa = false;
        }
        return true;

    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if(hojaCompleta()){
            System.out.println("FilaX no se puede añadir en HOJAX");
        }else{
            if(getFila1() == null){
                fila1 = fila;
            }else if(getFila2() == null){
                fila2 = fila;
            }else if(getFila3() == null){
                fila3 = fila;
            }
        }
    }
    
    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila fila = new Fila(id, fecha, ingresos, gastos);
        addFila(fila);
    }
    
    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        double total = fila1.getIngresos() + fila2.getIngresos() + fila3.getIngresos();
        return total;
    }
    
    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double gastos = fila1.getGastos() + fila2.getGastos() + fila3.getGastos();
        return gastos;

    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double beneficio = fila1.getBeneficio() + fila2.getBeneficio() + fila3.getBeneficio();
        return beneficio;

    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String representacion = "Hoja 1\n" + String.format("%s23 %s15 %s15 %s15","FECHA","INGRESOS","GASTOS","BENEFICIO") + 
        fila1.toString() + fila2.toString() + fila3.toString() + "\n------------------------------------------------------------" + 
        String.format("%d38.02€ %d15.02€ %d15.02€", getTotalIngresos(), getTotalGastos(), getBeneficio());
        return representacion;

    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        HojaCalculo copia = new HojaCalculo(this.nombre);
        copia.addFila(fila1.duplicar());
        copia.addFila(fila2.duplicar());
        copia.addFila(fila3.duplicar());
        return copia;
    }

}
