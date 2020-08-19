/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quienesquien.modelo;

/**
 *
 * @author Sara Monzó Bravo
 */
public class QuienEsQuienCartas 
{
    /*
    private String[] Sexo = {"hombre", "mujer"};
    private String[] Pelo = {"rubio", "moreno", "castaño", "pelirrojo", "canoso", "calvo"};
    private String[] Ojos = {"azules", "verdes", "marrones"};
    private String[] Nariz = {"grande", "mediana", "pequeña"};
    private String[] Boca = {"grande", "mediana", "pequeña"};
    */
    private String nombre;
    private String sexo;
    private String pelo;
    private String ojos;
    private String nariz;
    private String boca;
    private boolean gafas;
    private boolean sombrero;
    private boolean bigote;

    
    public QuienEsQuienCartas(String nombre, String sexo, String pelo, String ojos, String nariz, String boca, boolean gafas, boolean sombrero, boolean bigote )
    {
        this.nombre = nombre;
        this.sexo = sexo;
        this.pelo = pelo;
        this.ojos = ojos;
        this.nariz = nariz;
        this.boca = boca;
        this.gafas = gafas;
        this.sombrero = sombrero;
        this.bigote = bigote;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public String getSexo()
    {
        return sexo;
    }
    
    public String getPelo()
    {
        return pelo;
    }
    
    public String getOjos()
    {
        return ojos;
    }
    
    public String getNariz()
    {
        return nariz;
    }
    
    public String getBoca()
    {
        return boca;
    }
    
    public boolean getGafas()
    {
        return gafas;
    }
    
    public boolean getSombrero()
    {
        return sombrero;
    }
    
    public boolean getBigote()
    {
        return bigote;
    }
    
}
