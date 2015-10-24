package com.skytech.formulaanalyze.exeception;

/**
 * Created by Administrator on 2015/10/21.
 */
public class UnnecessaryRightBracketException extends FormulaFormatIllegalException {

    public UnnecessaryRightBracketException(String formula) {
        super(formula, "多余的右括号");
    }
}
