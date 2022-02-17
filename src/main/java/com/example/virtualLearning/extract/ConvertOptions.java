package com.example.virtualLearning.extract;

public class ConvertOptions {

    public static String getConcatenatedOptions(String optionA, String optionB, String optionC, String optionD) {
        return optionA + "!@#" + optionB + "!@#" + optionC + "!@#" + optionD;
    }

    public static String[] getOptions(String options) {
        return options.split("!@#");
    }
}
