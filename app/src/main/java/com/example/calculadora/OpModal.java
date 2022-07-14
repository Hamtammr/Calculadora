package com.example.calculadora;

public class OpModal {
    private String opTxt;
    private String resultTxt;

    public String getOpTxt() {
        return opTxt;
    }

    public void setOpTxt(String courseName) {
        this.opTxt = opTxt;
    }

    public String getResultTxt() {
        return resultTxt;
    }

    public void setResultTxt(String courseDuration) {
        this.resultTxt = resultTxt;
    }

    public OpModal(String opTxt, String resultTxt) {
        this.opTxt = opTxt;
        this.resultTxt = resultTxt ;

    }
}
