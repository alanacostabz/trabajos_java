/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloadurlthreaded;

import static downloadurlthreaded.getWebPage.DescargaPaginasEjecutar;

/**
 *
 * @author bryan
 */
public class DownloadURLThreaded {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     String url_base = "https://www.worldcat.org/oclc/";
      String archivo_base = "ebook";
     //1016547817
      DescargaPaginasEjecutar(1000,300, url_base, archivo_base);
        
    }
   
    
    }
    
     
    

