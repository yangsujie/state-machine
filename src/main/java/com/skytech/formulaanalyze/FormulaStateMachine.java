package com.skytech.formulaanalyze;

import com.skytech.formulaanalyze.exeception.IllegalVariableException;
import com.skytech.formulaanalyze.exeception.RightBracketNeededException;
import com.skytech.formulaanalyze.exeception.UnnecessaryRightBracketException;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Administrator on 2015/10/21.
 * 公式状态机
 */
public class FormulaStateMachine {

    private String formula;
    private String compiledFormula;
    private FormulaState currentState;
    private Stack<Character> formulaBrackets;
    private List<FormulaVariable> variables;
    private FormulaVariable variableInReading;
    private Stack<Function> functions;

    private FormulaState lastState;

    private static final String template = "@function\\(";


    public FormulaStateMachine(String formula){
        if(!StringUtils.hasText(formula)){
            throw new RuntimeException("计算公式为空");
        }
        this.formula = formula;
        compileFormula();
        formulaBrackets = new Stack<>() ;
        variables = new ArrayList<>();
        variableInReading = new FormulaVariable();
        functions = new Stack<>();
    }

    /**
     * 将公式中预定的多字符方法编译成单字符
     */
    private void compileFormula(){
        compiledFormula = formula.replaceAll("\\s","");
        Map<String,String> functions = Function.compileTemplates();
        for (String function: functions.keySet()){
            String reg = template.replace("@function",function);
            compiledFormula = compiledFormula.replaceAll(reg, functions.get(function) + "(");
        }
    }

    public List<FormulaVariable> run() {
        currentState = new VariableStartState(this);
        for (char c : compiledFormula.toCharArray()) {
            lastState = currentState;
            currentState = currentState.nextState(new FormulaCharacter(c));
        }
        currentState.endWith();
        return variables;
    }

    public void detectLeftBracket(){
        formulaBrackets.push('(');
        if(!functions.isEmpty()){
            functions.peek().pushBracket();
        }
    }

    public void detectRightBracket(){
        if(formulaBrackets.isEmpty()){
            throw new UnnecessaryRightBracketException(formula);
        }
        formulaBrackets.pop();

        if(!functions.isEmpty()){
            functions.peek().popBracket();
        }

        if(funcSystemIsBalance()&& lastState instanceof VariableEndState){
            functions = new Stack<>();
        }
    }

    //检查当前栈中的函数是否都达到平衡
    private boolean funcSystemIsBalance(){
        for(Function function:functions){
            if(!function.isBalance()){
                return false;
            }
        }
        return true;
    }

    public void detectFunction(String alias){
        functions.push(new Function(alias));
    }

    public void readCharacter(FormulaCharacter character){
        variableInReading.addCharacter(character);
    }

    public void readVariable() {
        if(!variableInReading.isLegal()){
            throw new IllegalVariableException(formula,variableInReading);
        }

        if(!functions.isEmpty()){
            Function function = functions.peek();
            //给解析出来的因子打上函数标签
            variableInReading.tagging(function.getFunction());
            if(function.isBalance()){
                functions.pop();
            }
        }
        variables.add(variableInReading);
        variableInReading = new FormulaVariable();
    }

    public void checkBracketBalance() {
        if (!formulaBrackets.isEmpty()) {
            throw new RightBracketNeededException(formula);
        }
    }

    public String getFormula() {
        return formula;
    }

}
