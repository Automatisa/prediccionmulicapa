/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocimientoletras;


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
    
    public String Entrenar() {
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
            } catch (SQLException ex) {
                Logger.getLogger(mlp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        MultiLayerPerceptron myMlPerceptron = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, 14, 10, 1);
        // learn the training set
        ((LMS) myMlPerceptron.getLearningRule()).setMaxError(0.0000001);
        ((LMS) myMlPerceptron.getLearningRule()).setMaxIterations(5000);
        ((LMS) myMlPerceptron.getLearningRule()).setLearningRate(0.5);
        myMlPerceptron.learnInSameThread(trainingSet);

        // test perceptro
        //testNeuralNetwork(myMlPerceptron, trainingSet);

        // save trained neural network
        myMlPerceptron.save("myMlPerceptron.nnet");
        return "Entrenamiento Finalizado";
    }
    public String provar(double[] t)
    {
        // load saved neural network
        NeuralNetwork loadedMlPerceptron = NeuralNetwork.load("myMlPerceptron.nnet");

        // test loaded neural network
        System.out.println("Testing loaded neural network");
        double tes[]= t;
        String mensaje="";
        double res[]=testNeuralNetwork(loadedMlPerceptron, tes);
        if (res[0]==0 && res[1]==0 && res[2]==0 && res[3]==0 && res[4]==0){mensaje="LETRA A";}
        if (res[0]==0 && res[1]==0 && res[2]==0 && res[3]==0 && res[4]==1){mensaje="LETRA B";}
        if (res[0]==0 && res[1]==0 && res[2]==0 && res[3]==1 && res[4]==0){mensaje="LETRA C";}
        if (res[0]==0 && res[1]==0 && res[2]==0 && res[3]==1 && res[4]==1){mensaje="LETRA D";}
        if (res[0]==0 && res[1]==0 && res[2]==1 && res[3]==0 && res[4]==0){mensaje="LETRA E";}
        if (res[0]==0 && res[1]==0 && res[2]==1 && res[3]==0 && res[4]==1){mensaje="LETRA F";}
        if (res[0]==0 && res[1]==0 && res[2]==1 && res[3]==1 && res[4]==0){mensaje="LETRA G";}
        if (res[0]==0 && res[1]==0 && res[2]==1 && res[3]==1 && res[4]==1){mensaje="LETRA H";}
        if (res[0]==0 && res[1]==1 && res[2]==0 && res[3]==0 && res[4]==0){mensaje="LETRA I";}
        if (res[0]==0 && res[1]==1 && res[2]==0 && res[3]==0 && res[4]==1){mensaje="LETRA J";}
        if (res[0]==0 && res[1]==1 && res[2]==0 && res[3]==1 && res[4]==0){mensaje="LETRA K";}
        if (res[0]==0 && res[1]==1 && res[2]==0 && res[3]==1 && res[4]==1){mensaje="LETRA L";}
        if (res[0]==0 && res[1]==1 && res[2]==1 && res[3]==0 && res[4]==0){mensaje="LETRA M";}
        if (res[0]==0 && res[1]==1 && res[2]==1 && res[3]==0 && res[4]==1){mensaje="LETRA N";}
        if (res[0]==0 && res[1]==1 && res[2]==1 && res[3]==1 && res[4]==0){mensaje="LETRA O";}
        if (res[0]==0 && res[1]==1 && res[2]==1 && res[3]==1 && res[4]==1){mensaje="LETRA P";}
        if (res[0]==1 && res[1]==0 && res[2]==0 && res[3]==0 && res[4]==0){mensaje="LETRA Q";}
        if (res[0]==1 && res[1]==0 && res[2]==0 && res[3]==0 && res[4]==1){mensaje="LETRA R";}
        if (res[0]==1 && res[1]==0 && res[2]==0 && res[3]==1 && res[4]==1){mensaje="LETRA T";}
        if (res[0]==1 && res[1]==0 && res[2]==1 && res[3]==0 && res[4]==0){mensaje="LETRA U";}
        if (res[0]==1 && res[1]==0 && res[2]==1 && res[3]==0 && res[4]==1){mensaje="LETRA V";}
        if (res[0]==1 && res[1]==0 && res[2]==1 && res[3]==1 && res[4]==0){mensaje="LETRA W";}
        if (res[0]==1 && res[1]==0 && res[2]==1 && res[3]==1 && res[4]==1){mensaje="LETRA X";}
        if (res[0]==1 && res[1]==1 && res[2]==0 && res[3]==0 && res[4]==0){mensaje="LETRA Y";}
        if (res[0]==1 && res[1]==1 && res[2]==0 && res[3]==0 && res[4]==1){mensaje="LETRA Z";}
        System.out.println(res[0]);
        System.out.println(res[1]);
        System.out.println(res[2]);
        System.out.println(res[3]);
        System.out.println(res[4]);
        return mensaje;
    }      
    
    public static double[] testNeuralNetwork(NeuralNetwork neuralNet, double[] entrada) {
        double aux[]=new double[5];
           
            neuralNet.setInput(entrada);
            neuralNet.calculate();
            double[] networkOutput = neuralNet.getOutput();
            //System.out.print("Input: " + Arrays.toString(entrada) );
            //System.out.println(" Output: " + Arrays.toString(networkOutput) );            
            for (int cont=0; cont<5; cont++)
            {
                if (networkOutput[cont]>0.5)
                {
                    aux[cont]=1;
                }else
                {
                    aux[cont]=0;
                }
            }            
        
        return aux;
    }
}
