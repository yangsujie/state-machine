package com.skytech.formulaanalyze.exeception;

/**
 * Created by Administrator on 2015/10/21.
 */
public class FormulaFormatIllegalException extends RuntimeException {

    public FormulaFormatIllegalException(String formula,String message){
        super("计算公式:"+formula+message);
    }

}
