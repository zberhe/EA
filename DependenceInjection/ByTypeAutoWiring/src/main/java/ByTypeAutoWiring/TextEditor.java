/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ByTypeAutoWiring;

/**
 *
 * @author Zehafta M
 */
public class TextEditor {

    private SpellChecker spellChecker;
    private String name;

    public TextEditor() {
          System.out.println("cs544.nameautowiring.TextEditor.setSpellChecker()");
    }

    public void setSpellChecker(SpellChecker spellChecker) {
       
        this.spellChecker = spellChecker;
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
