/*
* Clase para las funciones lógicas de una lavadora
 */
package Libreria;

/**
 *
 * @author bryan
 */
public class LLFunciones {
    private int kilos = 0 , llenadoCompleto = 0, tipoDeRopa = 0, lavadoCompleto = 0, secadoCompleto = 0;
    
    public LLFunciones(int kilos, int TipoDeRopa) {
       this.kilos = kilos;
       this.tipoDeRopa = TipoDeRopa;
    }
    
    private void Llenado() {
        if (getKilos() <= 12) {
            setLlenadoCompleto(1);
            System.out.println("Llenando...");
            System.out.println("Llenado completo");
        } else {
            System.out.println("La carga de ropa es muy pesada, prueba con otra");
    }
    }
    
    private void Lavado() {
        Llenado();
        System.out.println(this.tipoDeRopa);
        if(getLlenadoCompleto()==1) {
            if (tipoDeRopa==1) {
                System.out.println("Ropa blanca / Lavado suave");
                System.out.println("Lavando...");
                setLavadoCompleto(1);
            } else if (tipoDeRopa == 2) {
                System.out.println("Ropa de color / Lavado intenso");
                System.out.println("Lavando...");
                setLavadoCompleto(1);
            } else {
                System.out.println("El tipo de ropa no está disponible");
                System.out.println("Se lavará como ropa de color / Lavado intenso");
                setLavadoCompleto(1);
            }
        }
    }
    
    private void Secado() {
        Lavado();
        
        if (getLavadoCompleto() == 1) {
            System.out.println("Secando...");
            setSecadoCompleto(1);
        }
    }
    
    public void CicloFinalizado() {
        Secado();
        
        if (getSecadoCompleto() == 1) {
            System.out.println("Tu ropa está lista");
        }
    }
    
    // Setter y getter
    public int getTipoDeRopa() {
        return tipoDeRopa;
    }
    
    public void setTipoDeRopa(int TipoDeRopa) {
        this.tipoDeRopa = TipoDeRopa;
    }

    /**
     * @return the kilos
     */
    public int getKilos() {
        return kilos;
    }

    /**
     * @param kilos the kilos to set
     */
    public void setKilos(int kilos) {
        this.kilos = kilos;
    }

    /**
     * @return the llenadoCompleto
     */
    public int getLlenadoCompleto() {
        return llenadoCompleto;
    }

    /**
     * @param llenadoCompleto the llenadoCompleto to set
     */
    public void setLlenadoCompleto(int llenadoCompleto) {
        this.llenadoCompleto = llenadoCompleto;
    }

    /**
     * @return the lavadoCompleto
     */
    public int getLavadoCompleto() {
        return lavadoCompleto;
    }

    /**
     * @param lavadoCompleto the lavadoCompleto to set
     */
    public void setLavadoCompleto(int lavadoCompleto) {
        this.lavadoCompleto = lavadoCompleto;
    }

    /**
     * @return the secadoCompleto
     */
    public int getSecadoCompleto() {
        return secadoCompleto;
    }

    /**
     * @param secadoCompleto the secadoCompleto to set
     */
    public void setSecadoCompleto(int secadoCompleto) {
        this.secadoCompleto = secadoCompleto;
    }
}
