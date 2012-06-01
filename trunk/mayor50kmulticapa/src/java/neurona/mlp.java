/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neurona;


import javax.swing.JOptionPane;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.SupervisedTrainingElement;
import org.neuroph.core.learning.TrainingSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.LMS;
import org.neuroph.util.TransferFunctionType;
import Datos.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author INGENIERIA
 */
public class mlp {
    static private double[] tes;
    static MultiLayerPerceptron myMlPerceptron;
    public static String Entrenar() {
        serviciosDB.conectar("persona", "root", "jony1989");
        int reg=Transacciones.cuentaRegistros("datos");
        float edad;
            double fnlwgt;
            float claseTrabajadora;
            float educacion;
            float educacion_num;
            float estadoCivil;
            float ocupacion;
            float rolFamiliar;
            float raza;
            float sexo;
            double capitalGanado;
            double capitalPerdido;
            float horasps;
            float paisdn;
            int salida;
            long tiempo = System.currentTimeMillis();
        TrainingSet trainingSet = new TrainingSet(14, 1);
        if(Transacciones.cargarDatos("datos"))
        {
            try {
                
                while(serviciosDB.resultado.next())
                {
                    edad=serviciosDB.resultado.getFloat(2);
                    claseTrabajadora=serviciosDB.resultado.getFloat(3);
                    fnlwgt=serviciosDB.resultado.getFloat(4);
                    educacion=serviciosDB.resultado.getFloat(5);
                    educacion_num=serviciosDB.resultado.getFloat(6);
                    estadoCivil=serviciosDB.resultado.getFloat(7);
                    ocupacion=serviciosDB.resultado.getFloat(8);
                    rolFamiliar=serviciosDB.resultado.getFloat(9);
                    raza=serviciosDB.resultado.getFloat(10);
                    sexo=serviciosDB.resultado.getFloat(11);
                    capitalGanado=serviciosDB.resultado.getFloat(12);
                    capitalPerdido=serviciosDB.resultado.getFloat(13);
                    horasps=serviciosDB.resultado.getFloat(14);
                    paisdn=serviciosDB.resultado.getFloat(15);
                    trainingSet.addElement(new SupervisedTrainingElement(new double[]{edad,claseTrabajadora,fnlwgt,educacion,educacion_num, //LETRA A
                                                                          estadoCivil,ocupacion,rolFamiliar,raza,sexo,
                                                                          capitalGanado,capitalPerdido,horasps,paisdn}, new double[]{serviciosDB.resultado.getInt(16)}));    
                };
                
                // llamada a tu algoritmo
                
            } catch (SQLException ex) {
                Logger.getLogger(mlp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        myMlPerceptron = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, 14,12, 1);
        // learn the training set
        ((LMS) myMlPerceptron.getLearningRule()).setMaxError(0.00001);
        ((LMS) myMlPerceptron.getLearningRule()).setMaxIterations(5000);
        ((LMS) myMlPerceptron.getLearningRule()).setLearningRate(0.5);
        myMlPerceptron.learnInSameThread(trainingSet);

        // test perceptro
        //testNeuralNetwork(myMlPerceptron, trainingSet);

        // save trained neural network
        myMlPerceptron.save("Perceptron.net");
        tiempo -= System.currentTimeMillis();
//        return myMlPerceptron;
        return ("Entrenado en " + (-tiempo/1000f) + " segundos.");
    }
    public static String provar(double[] t)
    {
        // load saved neural network
        try{
        // test loaded neural network
        myMlPerceptron.setInput(t);
        myMlPerceptron.calculate();
        double[] networkOutput = myMlPerceptron.getOutput();
        if (networkOutput[0]>0.5)
                {
                    return ">50K";
                }else
                {
                    return "<=50K";
                }
        }
        catch(Exception e){
            return e.getLocalizedMessage();
        }
    }      
    
    public double testNeuralNetwork(NeuralNetwork neuralNet, double[] entrada) {
        double aux;
            
            return tes[1];/*
            
            
                        
                
        return aux;*/
    }
}
