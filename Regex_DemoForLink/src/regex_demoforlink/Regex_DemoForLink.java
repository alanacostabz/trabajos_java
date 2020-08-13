/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex_demoforlink;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bryan
 */
public class Regex_DemoForLink {

        //el indicador ?i indica que no importa mayusculas o minusculas delante de el
        //el primer patron hace referencia a la forma en la que inicia un enlace en html
        //<a href="tag_a,asp">The tag </a>;
        
        String HTML_A_TAG_PATTERN = "(?i)<a([^>]+)>(.+?)</a>";
        String HTML_A_HREF_PATTERN 
                = "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";
        
        Pattern patternTag = Pattern.compile(HTML_A_TAG_PATTERN);
        Pattern patternLink = Pattern.compile(HTML_A_HREF_PATTERN);
        Matcher matcherTag, matcherLink;
        
        public void grabHTMLLinks (final String html) {
            matcherTag = patternTag.matcher(html);
            
            while (matcherTag.find()){
                String href = matcherTag.group(1); //href
                String linkText = matcherTag.group(2); //link text
                
                matcherLink = patternLink.matcher(href);
                
                while (matcherLink.find()){
                    String link = matcherLink.group(1); //link
                    System.out.println("Link is "+ link);
                    System.out.println("Linktext is "+ linkText);
                }
            }
        }
        public static void main(String[] args) {
        String TEST_LINK = "http://www.google.com";
        Regex_DemoForLink htmlLinkExtractor = new Regex_DemoForLink();
        String html = "abc hahaha <a href='" + TEST_LINK + 
                "'>Ir a la pagina de busqueda Google</a>";
        htmlLinkExtractor.grabHTMLLinks(html);
    }
    }
