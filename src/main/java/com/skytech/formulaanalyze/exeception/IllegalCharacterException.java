package com.skytech.formulaanalyze.exeception;

import com.skytech.formulaanalyze.FormulaCharacter;

/**
 * Created by Administrator on 2015/10/21.
 */
public class IllegalCharacterException extends FormulaFormatIllegalException {

    public IllegalCharacterException(String formula,FormulaCharacter c){
        super(formula,"读取到不合法字符"+c.getCharacter());
    }
}
