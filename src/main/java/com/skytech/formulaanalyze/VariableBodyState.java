package com.skytech.formulaanalyze;


import com.skytech.formulaanalyze.exeception.OperatorNeededException;

/**
 * Created by Administrator on 2015/10/21.
 */
public class VariableBodyState extends FormulaState {

    public VariableBodyState(FormulaStateMachine machine){
        super(machine);
    }

    @Override
    protected FormulaState nextLeftBracket()  {
        throw new OperatorNeededException(machine.getFormula());
    }

    @Override
    protected FormulaState nextRightBracket()  {
        machine.readVariable();
        return new VariableEndState(machine);
    }

    @Override
    protected FormulaState nextNoneMinusOperate()  {
        machine.readVariable();
        return new VariableStartState(machine);
    }

    @Override
    protected FormulaState nextMinus()  {
        machine.readVariable();
        return new VariableStartState(machine);
    }

    @Override
    protected FormulaState nextNormalCharacter()  {
        return new VariableBodyState(machine);
    }

    @Override
    protected FormulaState nextFunctionCharacter() {
        throw new OperatorNeededException(machine.getFormula());
    }

    @Override
    public void endWith()  {
        machine.checkBracketBalance();
        machine.readVariable();
    }
}
