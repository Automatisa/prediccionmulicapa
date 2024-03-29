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
        serviciosDB.conectar("persona", "root", "");
        int reg=Transacciones.cuentaRegistros("datos");
        float edad;
            float claseTrabajadora;
            float educacion;
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
        TrainingSet trainingSet = new TrainingSet(12, 1);
        if(Transacciones.cargarDatos("datos"))
        {
            try {
                
                while(serviciosDB.resultado.next())
                {
                    edad=serviciosDB.resultado.getFloat(2);
                    claseTrabajadora=serviciosDB.resultado.getFloat(3);
                    educacion=serviciosDB.resultado.getFloat(4);
                    estadoCivil=serviciosDB.resultado.getFloat(5);
                    ocupacion=serviciosDB.resultado.getFloat(6);
                    rolFamiliar=serviciosDB.resultado.getFloat(7);
                    raza=serviciosDB.resultado.getFloat(8);
                    sexo=serviciosDB.resultado.getFloat(9);
                    capitalGanado=serviciosDB.resultado.getFloat(10);
                    capitalPerdido=serviciosDB.resultado.getFloat(11);
                    horasps=serviciosDB.resultado.getFloat(12);
                    paisdn=serviciosDB.resultado.getFloat(13);
                    trainingSet.addElement(new SupervisedTrainingElement(new double[]{edad,claseTrabajadora,educacion,
                                                                          estadoCivil,ocupacion,rolFamiliar,raza,sexo,
                                                                          capitalGanado,capitalPerdido,horasps,paisdn}, new double[]{serviciosDB.resultado.getInt(14)}));    
                };                 
            } 
            
            catch (SQLException ex) {
                Logger.getLogger(mlp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        myMlPerceptron = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, 12,20,1);
        // learn the training set
        ((LMS) myMlPerceptron.getLearningRule()).setMaxError(0.05);
        ((LMS) myMlPerceptron.getLearningRule()).setMaxIterations(3000);
        ((LMS) myMlPerceptron.getLearningRule()).setLearningRate(0.5);
        myMlPerceptron.learnInSameThread(trainingSet);

        // test perceptro
        //testNeuralNetwork(myMlPerceptron, trainingSet);

        // save trained neural network
        myMlPerceptron.save("Perceptron.net");
        tiempo -= System.currentTimeMillis();
//        return myMlPerceptron;
        return ("Entrenado en " + (-tiempo/1000f) + " segundos " + trainingSet.getRecordCount());
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
                    return ">50K "+String.valueOf(networkOutput[0]);
                }else
                {
                    return "<=50K "+String.valueOf(networkOutput[0]);
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
