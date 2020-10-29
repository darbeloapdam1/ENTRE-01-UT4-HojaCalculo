
/**
 *  Clase con código para probar el resto de clases
 * 
 * @author - Diego Arbeloa
 *  
 */
public class TestHojaCalculo
{

    /**
     * Constructor  
     */
    public TestHojaCalculo()    {
        
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 1
     * incluyendo la hoja duplicada
     * La fila4 que no se podrá guardar puedes crearla con el primer constructor  
     * de fila  
     */
    public void test1() {
        Fecha fecha1 = new Fecha(4,10,2020);
        Fecha fecha2 = new Fecha(5,10,2020);
        Fila fila1 = new Fila("Fila1", fecha1, 25.50, 132);
        Fila fila2 = new Fila("Fila2", fecha2, 300, 350);
        Fila fila3 = new Fila("Fila3");
        Fila fila4 = new Fila("Fila4");
        HojaCalculo hoja = new HojaCalculo("HOJA 1");
        hoja.addFila(fila1);
        hoja.addFila(fila2);
        hoja.addFila(fila3);
        hoja.addFila(fila4);
        HojaCalculo copia = hoja.duplicarHoja();
        System.out.println(hoja.toString());
        System.out.println("Duplicada " + copia.toString());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
         Fecha fecha1 = new Fecha(7,10,2020);
         Fecha fecha2 = new Fecha(8,10,2020);
         Fila fila1 = new Fila("Fila1", fecha1, 260, 125);
         Fila fila2 = new Fila("Fila2", fecha2, 125, 245);
         HojaCalculo hoja = new HojaCalculo("HOJA2");
         hoja.addFila(fila1);
         hoja.addFila(fila2);
         HojaCalculo copia = hoja.duplicarHoja();
         System.out.println(hoja.toString());
         System.out.println("Duplicada " + copia.toString());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
        Fecha fecha1 = new Fecha(8,10,2020);
        Fila fila1 = new Fila("Fila1", fecha1, 670, 234);
        HojaCalculo hoja = new HojaCalculo("HOJA3");
        hoja.addFila(fila1);
        HojaCalculo copia = hoja.duplicarHoja();
        System.out.println(hoja.toString());
        System.out.println("Duplicada " + copia.toString());

    }

}
