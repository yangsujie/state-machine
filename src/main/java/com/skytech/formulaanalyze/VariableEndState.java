package com.skytech.formulaanalyze;


import com.skytech.formulaanalyze.exeception.OperatorNeededException;

/**
 * Created by Administrator on 2015/10/21.
 */
public class VariableEndState extends FormulaState {

    public VariableEndState(FormulaStateMachine machine){
        super(machine);
    }

    @Override
    protected FormulaState nextLeftBracket(){
        throw new OperatorNeededException(machine.getFormula());
    }

    @Override
    protected FormulaState nextRightBracket(){
        return new VariableEndState(machine);
    }

    @Override
    protected FormulaState nextNoneMinusOperate(){
        return new VariableStartState(machine);
    }

    @Override
    protected FormulaState nextMinus(){
        return new VariableStartState(machine);
    }

    @Override
    protected FormulaState nextNormalCharacter(){
        throw new OperatorNeededException(machine.getFormula());
    }

    @Override
    protected FormulaState nextFunctionCharacter() {
        throw new OperatorNeededException(machine.getFormula());
    }

    @Override
    public void endWith(){
        machine.checkBracketBalance();
    }
}
