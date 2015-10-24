package com.skytech.formulaanalyze;

import com.skytech.formulaanalyze.exeception.FormulaFormatIllegalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2015/10/22.
 * 目前只支持一个因子只出现在一种类型的函数中
 * 有需求时再扩展
 */
@Component
public class FormulaAnalyzer {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormulaAnalyzer.class);

    public List<FormulaVariable> analyze(String formula){
        List<FormulaVariable> result = new ArrayList<>();
        Set<FormulaVariable> duplications = new HashSet<>();
        try {
            FormulaStateMachine machine = new FormulaStateMachine(formula);
            List<FormulaVariable> variables = machine.run();
            for(FormulaVariable variable:variables){
                if(!variable.isNumber()&&!duplications.contains(variable)){
                    result.add(variable);
                    duplications.add(variable);
                }
            }
        }catch (FormulaFormatIllegalException exp){
            LOGGER.error("formula illegal the exception is",exp);
            throw exp;
        }

        return result;
    }

}
