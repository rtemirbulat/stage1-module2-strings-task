package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;


public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        if (!(signatureString.isEmpty() || signatureString.isBlank())) {
            //Split and replace round brackets
            String[] dividedMethodParts = signatureString.split("\\(");
            String argumentsMethodPart = dividedMethodParts[1].replace(")", "").trim();
            String[] methodKeywords = dividedMethodParts[0].split(" ");
            String methodName = methodKeywords[methodKeywords.length - 1];
            String accessModifier = null;
            String returnType = methodKeywords[0];
            if (methodKeywords.length > 2) {
                accessModifier = methodKeywords[0];
                returnType = methodKeywords[1];
            }
            MethodSignature methodParsed;


            if (argumentsMethodPart.length() > 1) {
                List<String> args = List.of(argumentsMethodPart.split(","));
                List<MethodSignature.Argument> arguments = new ArrayList<>();
                for (String arg : args) {
                    String[] argsSplitted = arg.trim().split(" ");
                    if (argsSplitted.length == 2) {
                        arguments.add(new MethodSignature.Argument(argsSplitted[0], argsSplitted[1]));
                    } else {
                        throw new IllegalArgumentException("Argument should be (type) name");
                    }
                }
                methodParsed = new MethodSignature(methodName, arguments);
                methodParsed.setAccessModifier(accessModifier);
                methodParsed.setReturnType(returnType);
                return methodParsed;
            }
            methodParsed = new MethodSignature(methodName);
            methodParsed.setAccessModifier(accessModifier);
            methodParsed.setReturnType(returnType);
            return methodParsed;
        } else {
            throw new IllegalArgumentException("String is empty");
        }
    }
}
