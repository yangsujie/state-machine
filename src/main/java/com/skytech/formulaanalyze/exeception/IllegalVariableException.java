package com.skytech.formulaanalyze.exeception;


import com.skytech.formulaanalyze.FormulaVariable;

/**
 * Created by Administrator on 2015/10/22.
 */
public class IllegalVariableException extends FormulaFormatIllegalException {

    public IllegalVariableException(String formula,FormulaVariable variable){
        super(formula,"解析到不合法因子"+variable.getVariable());
    }
}
