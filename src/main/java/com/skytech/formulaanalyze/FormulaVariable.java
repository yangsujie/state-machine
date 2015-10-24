package com.skytech.formulaanalyze;

import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/10/21.
 */
public class FormulaVariable {

    private String variable;

    private String functionTag;

    public FormulaVariable(){
        this("");
    }

    public FormulaVariable(String variable){
        this.variable = variable;
    }

    public void addCharacter(FormulaCharacter c){
        variable += c.getCharacter();
    }

    public boolean isLegal(){
        return isNumber()||isAllLetter()||isLetterAndNumber();
    }

    public boolean isNumber(){
        Pattern pattern = Pattern.compile("\\d+(.\\d+)?");
        return pattern.matcher(variable).matches();
    }

    private boolean isAllLetter(){
        Pattern pattern = Pattern.compile("[A-Z|a-z]+");
        return pattern.matcher(variable).matches();
    }

    private boolean isLetterAndNumber(){
        Pattern pattern = Pattern.compile("[A-Z|a-z]+\\d+");
        return pattern.matcher(variable).matches();
    }


    public String getVariable() {
        return variable;
    }

    public int length() {
        return this.variable.length();
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof FormulaVariable){
            FormulaVariable f = (FormulaVariable)o;
            return f.getVariable().equals(variable);
        }else if(o instanceof String){
            return o.equals(variable);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return variable.hashCode();
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getFunctionTag() {
        return functionTag;
    }

    public void tagging(String functionTag) {
        this.functionTag = functionTag;
    }
}
