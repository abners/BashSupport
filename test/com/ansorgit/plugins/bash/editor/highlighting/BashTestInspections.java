package com.ansorgit.plugins.bash.editor.highlighting;

import com.ansorgit.plugins.bash.editor.inspections.inspections.ReadOnlyVariableInspection;
import com.intellij.codeInspection.InspectionToolProvider;

/**
 * Provides the inspections which should be enabled in the test cases which explicitely enable them.
 */
public class BashTestInspections implements InspectionToolProvider {
    @Override
    public Class[] getInspectionClasses() {
        return new Class[]{
                com.ansorgit.plugins.bash.editor.inspections.inspections.FixShebangInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.AddShebangInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.SimpleVarUsageInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.GlobalLocalVarDefInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.FunctionDefInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.WrapWordInStringInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.ConvertSubshellInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.DuplicateFunctionDefInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.MissingIncludeFileInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.RecursiveIncludeFileInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.EvaluateExpansionInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.UnresolvedVariableInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.EvaluateArithmeticExpressionInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.FloatArithmeticInspection.class,
                ReadOnlyVariableInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.InternalVariableInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.UnknownFiledescriptorInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.UnusedFunctionParameterInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.ConvertBackquoteInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.UnusedFunctionDefInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.SimpleArrayUseInspection.class,
                com.ansorgit.plugins.bash.editor.inspections.inspections.InternalCommandFunctionOverrideInspection.class
        };
    }
}
