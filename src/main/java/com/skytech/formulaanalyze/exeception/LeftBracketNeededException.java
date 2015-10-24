package com.skytech.formulaanalyze.exeception;

/**
 * Created by admin on 2015/6/3.
 */
public class LeftBracketNeededException extends FormulaNotCompleteException {

    public LeftBracketNeededException(String formula) {
        super(formula,"缺少左括号");
    }
}
