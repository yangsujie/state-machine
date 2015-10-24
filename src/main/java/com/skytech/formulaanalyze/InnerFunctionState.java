package com.skytech.formulaanalyze;


import com.skytech.formulaanalyze.exeception.FormulaNotCompleteException;
import com.skytech.formulaanalyze.exeception.LeftBracketNeededException;

/**
 * Created by Administrator on 2015/10/22.
 */
public class InnerFunctionState extends FormulaState {

    public InnerFunctionState(FormulaStateMachine machine){
        super(machine);
    }


    @Override
    protected FormulaState nextLeftBracket() {
        return new InnerBracketState(machine);
    }

    @Override
    protected FormulaState nextRightBracket() {
        throw new LeftBracketNeededException(machine.getFormula());
    }

    @Override
    protected FormulaState nextNoneMinusOperate() {
        throw new LeftBracketNeededException(machine.getFormula());
    }

    @Override
    protected FormulaState nextMinus() {
        throw new LeftBracketNeededException(machine.getFormula());
    }

    @Override
    protected FormulaState nextNormalCharacter() {
        throw new LeftBracketNeededException(machine.getFormula());
    }

    @Override
    protected FormulaState nextFunctionCharacter() {
        throw new LeftBracketNeededException(machine.getFormula());
    }

    @Override
    public void endWith() {
        throw new FormulaNotCompleteException(machine.getFormula());
    }
}
