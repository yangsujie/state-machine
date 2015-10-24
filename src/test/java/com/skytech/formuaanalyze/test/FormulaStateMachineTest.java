package com.skytech.formuaanalyze.test;

import com.skytech.formulaanalyze.FormulaStateMachine;
import org.junit.Test;

/**
 * created by yyang at 27/05/2015 00:35
 */

public class FormulaStateMachineTest {

    @Test
    public void testFunction(){
        String formula = "sum(A*(B-C)-M)-H";
        FormulaStateMachine machine = new FormulaStateMachine(formula);
        machine.run();
    }

}