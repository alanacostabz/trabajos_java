/*
 This file is part of JFontChooser v0.1

 JFontChooser is free software: you can redistribute it and/or modify
 it under the terms of the GNU Lesser General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 JFontChooser is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public License
 along with JFontChooser.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.deepak.jfontchooser.sample;

import com.deepak.jfontchooser.JFontChooser;

/**
 *
 * @author deepak
 */

/*
 * this class provides a simple usage example
 */
public class Sample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFontChooser jtc = new JFontChooser();

        int result = jtc.showTextChooserDialog();

        if (result == JFontChooser.APPROVE_OPTION) {
            System.out.println("Text:" + jtc.getText());
            System.out.println("Font Name:" + jtc.getSelectedFontName());
            System.out.println("Font Size:" + jtc.getSelectedFontSize());
            System.out.println("Font Style:" + jtc.getSelectedFontStyle());
            System.out.println("Text Color:" + jtc.getSelectedTextColor());
        } else if (result == JFontChooser.CANCEL_OPTION) {
            System.out.println("Selection Canceled!");
        }
    }
}
