package com.skytech.formulaanalyze.exeception;

/**
 * Created by admin on 2015/6/3.
 */
public class RightBracketNeededException extends FormulaNotCompleteException {

    public RightBracketNeededException(String formula) {
        super(formula,"缺少右括号");
    }
}
