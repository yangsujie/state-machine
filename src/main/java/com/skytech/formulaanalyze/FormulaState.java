package com.skytech.formulaanalyze;


import com.skytech.formulaanalyze.exeception.IllegalCharacterException;

/**
 * Created by Administrator on 2015/10/21.
 */
public abstract class FormulaState {

    protected FormulaStateMachine machine;

    protected FormulaState(FormulaStateMachine machine){
        this.machine = machine;
    }

    public final FormulaState nextState(FormulaCharacter c){
        if(c.isLeftBracket()){
            machine.detectLeftBracket();
            return nextLeftBracket();
        }else if(c.isRightBracket()){
            machine.detectRightBracket();
            return nextRightBracket();
        }else if(c.isOperator()&&!c.isMinus()){
            return nextNoneMinusOperate();
        }else if(c.isMinus()){
            return nextMinus();
        }else if (c.isNormalCharacter()){
            machine.readCharacter(c);
            return nextNormalCharacter();
        }else if(c.isFunctionCharacter()){
            //read a function symbol
            machine.detectFunction(c.getCharacter());
            return nextFunctionCharacter();
        }else{
            throw new IllegalCharacterException(machine.getFormula(),c);
        }
    }

    //返回读取左括号后的状态
    protected abstract FormulaState nextLeftBracket();

    //返回读取右括号后的状态
    protected abstract FormulaState nextRightBracket();

    //返回读取运算符（非负号）后的状态
    protected abstract FormulaState nextNoneMinusOperate();

    //返回读取减号（负号）后的状态
    protected abstract FormulaState nextMinus();

    //返回读取普通字符后的状态
    protected abstract FormulaState nextNormalCharacter();

    protected abstract FormulaState nextFunctionCharacter();

    //读取到公式末尾后执行的操作
    public abstract void endWith();

}
