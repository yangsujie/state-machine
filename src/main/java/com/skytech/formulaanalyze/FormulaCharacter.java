package com.skytech.formulaanalyze;

import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/10/21.
 */
public class FormulaCharacter {

    private String character;

    public FormulaCharacter(Character character){
        this.character = character.toString();
    }

    public boolean isLeftBracket(){
        return "(".equals(character);
    }

    public boolean isRightBracket(){
        return ")".equals(character);
    }

    public boolean isOperator(){
        switch (character){
            case "+":
                return true;
            case "-":
                return true;
            case "*":
                return true;
            case "/":
                return true;
            default:
                return false;
        }
    }

    public boolean isMinus() {
        return "-".equals(character);
    }

    public boolean isNormalCharacter(){
        Pattern pattern = Pattern.compile("[A-Z|a-z|.|\\d| ]");
        return pattern.matcher(character).matches();
    }

    public boolean isFunctionCharacter(){
        Pattern pattern = Pattern.compile("[Σ|δ|α]");
        return pattern.matcher(character).matches();
    }

    public String getCharacter() {
        return character;
    }
}
