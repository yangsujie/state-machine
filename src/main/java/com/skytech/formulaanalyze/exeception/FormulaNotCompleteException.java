package com.skytech.formulaanalyze.exeception;

/**
 * Created by Administrator on 2015/10/21.
 */
public class FormulaNotCompleteException extends FormulaFormatIllegalException {


    public FormulaNotCompleteException(String formula){
        super(formula,"未完成");
    }

    public FormulaNotCompleteException(String formula,String message){
        super(formula,message);
    }

}
