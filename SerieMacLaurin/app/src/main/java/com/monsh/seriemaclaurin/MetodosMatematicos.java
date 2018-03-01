package com.monsh.seriemaclaurin;

/**
 * Created by monsh on 19/02/2018.
 * @author Jacob, Fernanda
 */

public class MetodosMatematicos {
    String polinomioSinEvaluar, polinomioSustituido, polinomioEvaluado;
    double resultadoEvaluado, eA, eR, eP, rE, p;
    double resultadoReal;

    //Para evaluar las funciones calc 0.5 c
    //double evaluar=0.5;


    //public static final double DX = 0.01;
    static final int OPCION_SENO = 1;
    static final int OPCION_COSENO = 2;
    static final int OPCION_EXPONENCIAL = 3;
    static final String[] ARRAY_SENO = {"Sen(x)", " + Cos(x)", " - Sen(x)", " - Cos(x)"};
    static final String[] ARRAY_COSENO = {"Cos(x)", " - Sen(x)", " - Cos(x)", " + Sen(x)"};
    static final String[] ARRAY_SENO_VALUE = {"Sen(0)", " + Cos(0)", " - Sen(0)", " - Cos(0)"};
    static final String[] ARRAY_COSENO_VALUE = {"Cos(0)", " - Sen(0)", " - Cos(0)", " + Sen(0)"};
    static final int[] SENO = {0, 1, 0, -1};
    static final int[] COSENO = {1, 0, -1, 0};


    MetodosMatematicos(){
        polinomioSinEvaluar = "";
        polinomioSustituido = "";
        polinomioEvaluado = "";
        resultadoEvaluado = 0;
    }

    public int factorial(int x) {
        if (x == 0) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }

    public void e(int fac, int i, double evaluar) {
        polinomioSinEvaluar += "e^x";
        polinomioSustituido += "e^0";
        polinomioEvaluado += String.valueOf(1);
        resultadoEvaluado += 1 * Math.pow(evaluar, i) / fac;
        resultadoReal = Math.pow(Math.E, evaluar);
    }

    public void coseno(int fac, int i, double evaluar) {
        polinomioSinEvaluar += ARRAY_COSENO[i % 4];
        polinomioSustituido += ARRAY_COSENO_VALUE[i % 4];
        polinomioEvaluado += String.valueOf(COSENO[i % 4]);
        resultadoEvaluado += COSENO[i % 4] * Math.pow(evaluar, i) / fac;
        resultadoReal = Math.cos(evaluar);
    }

    void seno(int fac, int i,double evaluar) {
        polinomioSinEvaluar += ARRAY_SENO[i % 4];
        polinomioSustituido += ARRAY_SENO_VALUE[i % 4];
        polinomioEvaluado += String.valueOf(SENO[i % 4]);
        resultadoEvaluado += SENO[i % 4] * Math.pow(evaluar, i) / fac;
        System.out.println(resultadoEvaluado);
        resultadoReal = Math.sin(evaluar);
    }

    void resultados(int fac, int i) {
        polinomioSinEvaluar += "(x^" + i + ")/" + fac + "  ";
        polinomioEvaluado += "(x^" + i + ")/" + fac + "  ";
        polinomioSustituido += "(x^" + i + ")/" + fac + "  ";
    }


    public String getPolinomioSinEvaluar() {  return polinomioSinEvaluar;  }
    public String getPolinomioSustituido() {  return polinomioSustituido;  }
    public String getPolinomioEvaluado() {  return polinomioEvaluado;  }
    public double getResultadoEvaluado() {  return resultadoEvaluado;  }
    public double getResultadoReal() {  return resultadoReal;  }

}
