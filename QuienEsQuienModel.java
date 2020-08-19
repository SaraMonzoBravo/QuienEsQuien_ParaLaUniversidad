/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quienesquien.modelo;

import java.util.Random;

/**
 *
 * @author Sara Monzó Bravo
 */
public class QuienEsQuienModel 
{
    private QuienEsQuienCartas Alex;
    private QuienEsQuienCartas Alfred;
    private QuienEsQuienCartas Anita;
    private QuienEsQuienCartas Anne;
    private QuienEsQuienCartas Bernard;
    private QuienEsQuienCartas Bill;
    private QuienEsQuienCartas Charles;
    private QuienEsQuienCartas Claire;
    private QuienEsQuienCartas David;
    private QuienEsQuienCartas Eric;
    private QuienEsQuienCartas Frans;
    private QuienEsQuienCartas George;
    private QuienEsQuienCartas Hernan;
    private QuienEsQuienCartas Joe;
    private QuienEsQuienCartas Maria;
    private QuienEsQuienCartas Max;
    private QuienEsQuienCartas Paul;
    private QuienEsQuienCartas Peter;
    private QuienEsQuienCartas Philip;
    private QuienEsQuienCartas Richard;
    private QuienEsQuienCartas Robert;
    private QuienEsQuienCartas Sam;
    private QuienEsQuienCartas Susan;
    private QuienEsQuienCartas Tom;
    private static QuienEsQuienCartas Asesino;
    private QuienEsQuienCartas[] Cartas;    
    
    public QuienEsQuienModel() 
    {
        Alex = new QuienEsQuienCartas("cara1", "hombre", "moreno", "marrones", "mediana", "grande", false, false, true);
        Alfred = new QuienEsQuienCartas("cara2", "hombre", "pelirrojo", "azules", "pequeña", "pequeña", false, false, true);
        Anita = new QuienEsQuienCartas("cara3", "mujer", "rubio", "azules", "mediana", "mediana", false, false, false);
        Anne = new QuienEsQuienCartas("cara4", "mujer", "moreno", "marrones", "grande", "pequeña", false, false,  false);
        Bernard = new QuienEsQuienCartas("cara5", "hombre", "castaño", "marrones", "grande", "pequeña", false, true, false);
        Bill = new QuienEsQuienCartas("cara6", "hombre", "calvo", "azules", "pequeña", "pequeña", false, false, false);
        Charles = new QuienEsQuienCartas("cara7", "hombre", "rubio", "verdes", "pequeña", "grande", false, false, true);
        Claire = new QuienEsQuienCartas("cara8", "mujer", "pelirrojo", "marrones", "mediana", "mediana", true, true, false);
        David = new QuienEsQuienCartas("cara9", "hombre", "rubio", "verdes", "mediana", "mediana", false, false, false);
        Eric = new QuienEsQuienCartas("cara10", "hombre", "rubio", "marrones", "pequeña", "grande", false, true, false);
        Frans = new QuienEsQuienCartas("cara11", "hombre", "pelirrojo", "verdes", "pequeña", "pequeña", false, false, false);
        George = new QuienEsQuienCartas("cara12", "hombre", "canoso", "verdes", "pequeña", "grande", false, true, false);
        Hernan = new QuienEsQuienCartas("cara13", "hombre", "calvo", "verdes", "grande", "mediana", false, false, false);
        Joe = new QuienEsQuienCartas("cara14", "hombre", "rubio", "marrones", "pequeña", "pequeña", true, false, false);
        Maria = new QuienEsQuienCartas("cara15", "mujer", "castaño", "marrones", "pequeña", "mediana", false, true, false);
        Max = new QuienEsQuienCartas("cara16", "hombre", "moreno", "marrones", "grande", "grande", false, false, true);
        Paul = new QuienEsQuienCartas("cara17", "hombre", "canoso", "marrones", "pequeña", "pequeña", true, false, false);
        Peter = new QuienEsQuienCartas("cara18", "hombre", "canoso", "azules", "grande", "grande", false, false, false);
        Philip = new QuienEsQuienCartas("cara19", "hombre", "moreno", "marrones", "pequeña", "grande", false, false, false);
        Richard = new QuienEsQuienCartas("cara20", "hombre", "calvo", "marrones", "pequeña", "pequeña", false, false, true);
        Robert = new QuienEsQuienCartas("cara21", "hombre", "castaño", "azules", "grande", "grande", false, false, false);
        Sam = new QuienEsQuienCartas("cara22", "hombre", "calvo", "marrones", "pequeña", "pequeña", true, false, false);
        Susan = new QuienEsQuienCartas("cara23", "mujer", "canoso", "marrones", "pequeña", "grande", false, false, false);
        Tom = new QuienEsQuienCartas("cara24", "hombre", "calvo", "azules", "mediana", "pequeña", true, false, false);
        
        Cartas = new QuienEsQuienCartas[] {Alex, Alfred, Anita, Anne, Bernard, Bill, Charles, Claire, David, Eric, Frans, George, Hernan, Joe, Maria, Max, Paul, Peter, Philip,  Richard, Robert, Sam, Susan, Tom};
    }

    
    /************************* cartaAleatoria **********************
    * Elije una de las 24 cartas de forma aleatoria usando Random  *
    *                                                              *
    * @return QuienEsQuienCartas                                   *
    ****************************************************************/
    public QuienEsQuienCartas cartaAleatoria()
    {
        Random rand = new Random();
        int randomNum = (int)(rand.nextDouble() * 24);
        
        return Cartas[randomNum];
    }
    
    /************************* comienzaJuego **********************
    * Inicializa el juego                                         *
    *                                                             *
    ***************************************************************/
    public void comienzaJuego()
    {
        Asesino = cartaAleatoria();
        System.out.println(Asesino.getNombre());
    }
    
    
    /************************ compruebaSexo ***************************
    * Comprueba si el sexo del asesino es el mismo que el preguntado  *
    *                                                                 *
    * @param sexo                                                     *
    * @return boolean                                                 *
    *******************************************************************/
    public boolean compruebaSexo(String sexo)
    {
        return (Asesino.getSexo() == sexo);
    }
    
    
    /************************ compruebaPelo ***************************
    * Comprueba si el pelo del asesino es el mismo que el preguntado  *
    *                                                                 *
    * @param pelo                                                     *
    * @return boolean                                                 *
    *******************************************************************/
    public boolean compruebaPelo(String pelo)
    {
        return (Asesino.getPelo() == pelo);
    }
    
    
    /************************* compruebaOjos ***************************
    * Comprueba si los ojos del asesino es el mismo que el preguntado  *
    *                                                                  *
    * @param ojos                                                      *
    * @return boolean                                                  *
    ********************************************************************/
    public boolean compruebaOjos(String ojos)
    {
        return (Asesino.getOjos() == ojos);
    }
    
    
    /************************ compruebaNariz ***************************
    * Comprueba si la nariz del asesino es el mismo que el preguntado  *
    *                                                                  *
    * @param nariz                                                     *
    * @return boolean                                                  *
    ********************************************************************/
    public boolean compruebaNariz(String nariz)
    {
        return (Asesino.getNariz() == nariz);
    }
    
    
    /************************ compruebaBoca ***************************
    * Comprueba si la boca del asesino es el mismo que el preguntado  *
    *                                                                 *
    * @param boca                                                     *
    * @return boolean                                                 *
    *******************************************************************/
    public boolean compruebaBoca(String boca)
    {
        return (Asesino.getBoca() == boca);
    }
    
    
    /************************ compruebaGafas ***************************
    * Comprueba si el asesino y el preguntado llevan gafas             *
    *                                                                  *
    * @param gafas                                                     *
    * @return boolean                                                  *
    ********************************************************************/
    public boolean compruebaGafas(boolean gafas)
    {
        return (Asesino.getGafas() == gafas);
    }
    
    
    /************************ compruebaSombrero ***************************
    * Comprueba si el asesino y el preguntado llevan sombrero             *
    *                                                                     *
    * @param sombrero                                                     *
    * @return boolean                                                     *
    ***********************************************************************/
    public boolean compruebaSombrero(boolean sombrero)
    {
        return (Asesino.getSombrero() == sombrero);
    }
    
    
    /************************ compruebaBigote ***************************
    * Comprueba si el asesino y el preguntado tienen bigote             *
    *                                                                   *
    * @param bigote                                                     *
    * @return boolean                                                   *
    *********************************************************************/
    public boolean compruebaBigote(boolean bigote)
    {
        return (Asesino.getBigote() == bigote);
    }
    
    
    /************************ getVectorCartas ***************************
    * Devuelve el vector de Cartas                                      *
    *                                                                   *
    * @return QuienEsQuienCartas[]                                      *
    *********************************************************************/
    public QuienEsQuienCartas[] getVectorCartas()
    {
        return Cartas;
    }
    
    
    /************************ getNombreAsesino ***************************
    * Devuelve el nombre del asesino                                     *
    *                                                                    *
    * @return String                                                     *
    **********************************************************************/
    public String getNombreAsesino()
    {
        return Asesino.getNombre();
    }
    
    
    
}
