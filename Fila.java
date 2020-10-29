
/**
 *  Representa a una fila de la hoja de cálculo
 *  Toda fila tiene un identificador y en ella
 *  se anotan la fecha, los ingresos y los gastos correspondientes a un
 *  apunte  contable  de una empresa
 * 
 * @author - Diego Arbeloa
 *  
 */
public class Fila
{
    private String id;
    private Fecha fecha;
    private double ingresos;
    private double gastos;

    /**
     * Constructor  
     */
    public Fila(String id)    {
         this.id = id;
         fecha = new Fecha(1,1,2020);
         ingresos = 0;
         gastos = 0;

    }

    /**
     * Constructor  
     */
    public Fila(String id, Fecha fecha, double ingresos, double gastos)    {
        this.id = id;
        this.fecha = fecha;
        this.ingresos = ingresos;
        this.gastos = gastos;

    }
    
    /**
     * accesor para el id de la fila
     */
    public String getId() {
        return this.id;

    }


    /**
     * accesor para la fecha
     */
    public Fecha getFecha() {
        return this.fecha;

    }

    /**
     * accesor para los ingresos
     */
    public double getIngresos() {
        return this.ingresos;

    }

    /**
     * accesor para los gastos
     */
    public double getGastos() {
        return this.gastos;

    }

    /**
     * calcula y devuelve el beneficio
     */
    public double getBeneficio() {
        return this.ingresos - this.gastos;

    }
    
    /**
     * obtiene una copia idéntica a la fila actual.
     * La fecha que incluye la fila duplicada también es una copia
     * 
     */
    public Fila duplicar() {
        Fecha cFecha = fecha.obtenerCopia();
        Fila copia = new Fila(this.id,cFecha, this.ingresos, this.gastos);
        return copia;

    }

    /**
     * Representación textual de una fila
     * (leer enunciado)
     */
    public String toString() {
        String beneficio = String.format("%15.02f€",getBeneficio());
        if(getBeneficio() < 0){
            beneficio += " **";
        }
        String repFila = String.format("\n%8s %15s %15.02f€ %15.02f€ %s", 
        this.id, fecha.toString(), this.ingresos, this.gastos, beneficio);
        return repFila;
    }

     

}
