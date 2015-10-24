package com.skytech.formulaanalyze.exeception;

/**
 * Created by fengding on 2015/6/3.
 */
public class OperatorNeededException extends FormulaFormatIllegalException {

    public OperatorNeededException(String formula) {
        super(formula, "缺少运算符");
    }
}
