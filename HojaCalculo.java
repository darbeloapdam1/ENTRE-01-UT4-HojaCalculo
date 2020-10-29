
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
        int contador = 3;
        if(getFila1() == null){
            contador--;
        }
        if(getFila2() == null){
            contador--;
        }
        if(getFila3() == null){
            contador--;
        }
        return contador;
    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        boolean completa = true;
        if(fila1 == null){
            completa = false;
        }
        if(fila2 == null){
            completa = false;
        }
        if(fila3 == null){
            completa = false;
        }
        return completa;

    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila) {
        if(hojaCompleta()){
            System.out.println(fila.getId() + " no se puede añadir en " + nombre);
            System.out.println();
        }else{
            if(fila1 == null){
                fila1 = new Fila(fila.getId(), fila.getFecha(), fila.getIngresos(), fila.getGastos());
            }else if(fila2 == null){
                fila2 = new Fila(fila.getId(), fila.getFecha(), fila.getIngresos(), fila.getGastos());
            }else if(fila3 == null){
                fila3 = new Fila(fila.getId(), fila.getFecha(), fila.getIngresos(), fila.getGastos());
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
        double tFila1 = 0;
        double tFila2 = 0;
        double tFila3 = 0;
        if(fila1 != null){
            tFila1 = fila1.getIngresos();
        }
        if(fila2 != null){
            tFila2 = fila2.getIngresos();
        }
        if(fila3 != null){
            tFila3 = fila3.getIngresos();
        }
        double total = tFila1 + tFila2 + tFila3;
        return total;
    }
    
    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double tFila1 = 0;
        double tFila2 = 0;
        double tFila3 = 0;
        if(fila1 != null){
            tFila1 = fila1.getGastos();
        }
        if(fila2 != null){
            tFila2 = fila2.getGastos();
        }
        if(fila3 != null){
            tFila3 = fila3.getGastos();
        }
        double total = tFila1 + tFila2 + tFila3;
        return total;
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double tFila1 = 0;
        double tFila2 = 0;
        double tFila3 = 0;
        if(fila1 != null){
            tFila1 = fila1.getBeneficio();
        }
        if(fila2 != null){
            tFila2 = fila2.getBeneficio();
        }
        if(fila3 != null){
            tFila3 = fila3.getBeneficio();
        }
        double total = tFila1 + tFila2 + tFila3;
        return total;
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String strFila1 = "";
        String strFila2 = "";
        String strFila3 = "";
        if(fila1 != null){
            strFila1 = fila1.toString();
        }
        if(fila2 != null){
            strFila2 = fila2.toString();
        }
        if(fila3 != null){
            strFila3 = fila3.toString();
        }
        String representacion = nombre + "\n" + String.format("%24s %16s %15s %17s","FECHA","INGRESOS","GASTOS","BENEFICIO") + strFila1
         + strFila2 + strFila3 + "\n-------------------------------------------------------------------------------\n" + 
        String.format("%40.02f€ %15.02f€ %15.02f€", getTotalIngresos(), getTotalGastos(), getBeneficio());
        return representacion;

    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        HojaCalculo copia = new HojaCalculo(this.nombre);
        Fila cFila1 = null;
        Fila cFila2 = null;
        Fila cFila3 = null;
        if(fila1 != null){
            cFila1 = fila1.duplicar();
            copia.addFila(cFila1);
        }
        if(fila2 != null){
            cFila2 = fila2.duplicar();
            copia.addFila(cFila2);
        }
        if(fila3 != null){
            cFila3 = fila3.duplicar();
            copia.addFila(cFila3);
        }
        return copia;
    }

}
