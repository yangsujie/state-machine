package com.skytech.formulaanalyze;

import java.util.*;

/**
 * Created by Administrator on 2015/10/23.
 */
public class Function {

    private String function;

    private Stack<Character> brackets;

    public Function(String alias){
        brackets = new Stack<>();
        function = FunctionAlias.findFunction(alias);
    }

    public static Map<String,String> compileTemplates(){
        Map<String,String> result = new HashMap<>();
        for(FunctionAlias alias:FunctionAlias.values()){
            result.put(alias.name(),alias.getAlias());
        }
        return result;
    }

    public void pushBracket(){
        //逐层寻找嵌套方法
        brackets.push('(');
    }

    public void popBracket(){
        brackets.pop();
    }

    public boolean isBalance(){
        return brackets.isEmpty();
    }

    public String getFunction() {
        return function;
    }

    private enum  FunctionAlias {

        sum("Σ"),div("δ"),mul("α");

        private String alias;

        FunctionAlias(String alias){
            this.alias = alias;
        }

        public String getAlias() {
            return alias;
        }

        public static String findFunction(String targetAlias){
            for(FunctionAlias alias:values()){
                if(targetAlias.equals(alias.getAlias())){
                    return alias.name();
                }
            }
            return null;
        }
    }
}
