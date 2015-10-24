package com.skytech.formulaanalyze;


import com.skytech.formulaanalyze.exeception.FormulaNotCompleteException;
import com.skytech.formulaanalyze.exeception.UnnecessaryOperatorException;
import com.skytech.formulaanalyze.exeception.UnnecessaryRightBracketException;

/**
 * Created by Administrator on 2015/10/21.
 */
public class InnerBracketState extends FormulaState {

    public InnerBracketState(FormulaStateMachine machine){
        super(machine);
    }

    @Override
    protected FormulaState nextLeftBracket()  {
        return new InnerBracketState(machine);
    }

    @Override
    protected FormulaState nextRightBracket() {
        throw new UnnecessaryRightBracketException(machine.getFormula());
    }

    @Override
    protected FormulaState nextNoneMinusOperate() {
        throw new UnnecessaryOperatorException(machine.getFormula());
    }

    @Override
    protected FormulaState nextMinus() {
        return new VariableStartState(machine);
    }

    @Override
    protected FormulaState nextNormalCharacter(){
        return new VariableBodyState(machine);
    }

    @Override
    protected FormulaState nextFunctionCharacter() {
        return new InnerFunctionState(machine);
    }

    @Override
    public void endWith(){
        throw new FormulaNotCompleteException(machine.getFormula());
    }
}
