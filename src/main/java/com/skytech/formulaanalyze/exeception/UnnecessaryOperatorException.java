package com.skytech.formulaanalyze.exeception;

/**
 * Created by admin on 2015/6/2.
 */
public class UnnecessaryOperatorException extends FormulaFormatIllegalException {

    public UnnecessaryOperatorException(String formula) {
        super(formula, "多余的运算符");
    }
}
