
package kohonen;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.SupervisedTrainingElement;
import org.neuroph.core.learning.TrainingSet;
import org.neuroph.nnet.learning.KohonenLearning;
import org.neuroph.nnet.learning.LMS;

/**
 * Kohonen neural network.
 * 
 * @author Zoran Sevarac <sevarac@gmail.com>
 */
public class Kohonen_1{
	ResultSet resultado;        
        private NeuralNetwork neuralNetwork;
        KohonenLearning e_kohonen=new KohonenLearning();
        TrainingSet trainingSet = new TrainingSet(14, 1); 
        laBase.ConexionBD con= new laBase.ConexionBD();
                        
	public Kohonen_1(){
            
        }
        public void ejecutar() throws IOException{
            
            neuralNetwork = new org.neuroph.nnet.Kohonen(14, 1);   /// CREACION DE LA RED         
            neuralNetwork.randomizeWeights();
            System.out.println("Comienza el entrenamiento...");
            TrainingSet trainSet = collectTrainingSet();
            
            neuralNetwork.setLearningRule(e_kohonen);
            (neuralNetwork.getLearningRule()).setNeuralNetwork(neuralNetwork);
                        
            
            neuralNetwork.learnInSameThread(trainSet);
            System.out.println("termina el entrenamiento...");
            this.saveNetwork("kohonen.net");
            try {
                this.graficar("kohonen.net");
            } catch (SQLException ex) {
                Logger.getLogger(Kohonen_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public TrainingSet collectTrainingSet() throws IOException
        {                                  
            String sql="select * from datos"; 
            try { 
                
                resultado = con.ejecutaSQL(sql);                                

                float edad, claseTrabajadora,fnlwgt, educacion_num, estadoCivil, ocupacion, educacion, rolFamiliar, raza
                        , sexo, capitalGanado, capitalPerdido, horasps, paisdn;
                while(resultado.next())
                {
                    edad=resultado.getFloat(2);
                    claseTrabajadora=resultado.getFloat(3);
                    educacion=resultado.getFloat(4);
                    educacion_num=resultado.getFloat(5);
                    estadoCivil=resultado.getFloat(6);
                    ocupacion=resultado.getFloat(7);
                    rolFamiliar=resultado.getFloat(8);
                    raza=resultado.getFloat(9);
                    sexo=resultado.getFloat(10);
                    capitalGanado=resultado.getFloat(11);
                    capitalPerdido=resultado.getFloat(12);
                    horasps=resultado.getFloat(13);
                    paisdn=resultado.getFloat(14);
                    trainingSet.addElement(new SupervisedTrainingElement(new double[]{edad,claseTrabajadora,educacion,educacion_num, //LETRA A
                                                                          estadoCivil,ocupacion,rolFamiliar,raza,sexo,
                                                                          capitalGanado,capitalPerdido,horasps,paisdn}, new double[]{resultado.getInt(15)}));    
                };                                                                       
                
                    //e_kohonen.setNeuralNetwork(createNetwork(14,1));
                    //e_kohonen.learn(trainingSet);                      
            } catch (SQLException ex) {
                Logger.getLogger(Kohonen_1.class.getName()).log(Level.SEVERE, null, ex);
            }   
            return trainingSet;
        } 
	
        public void saveNetwork(String filename) {
        neuralNetwork.save(filename);
        }

        public void loadNetwork(String filename) {
            neuralNetwork.load(filename);
        }
        
        public void graficar(String filename) throws SQLException, IOException{
         String sql="select * from datos";
         resultado = con.ejecutaSQL(sql);
         for (int cont=0; cont<10; cont++){
           resultado.next();
           double[] input = new double[]{resultado.getFloat(2),resultado.getFloat(3),resultado.getFloat(4),resultado.getFloat(5),resultado.getFloat(6),resultado.getFloat(7),resultado.getFloat(8),resultado.getFloat(9),resultado.getFloat(10),resultado.getFloat(11),resultado.getFloat(12),resultado.getFloat(13),resultado.getFloat(14),resultado.getFloat(15)};
           neuralNetwork.setInput(input);
           neuralNetwork.calculate();
           
           double[] output = neuralNetwork.getOutput();
           for (int i=0; i<output.length;i++){
               //neuralNetwork.createConnection(null, null, i)
               System.out.println("Entrada #.. "+i+" res="+output[i]);
           }
         }           
            
        }
       /** private NeuralNetwork createNetwork(int inputNeuronsCount, int outputNeuronsCount) {

		NeuralNetwork red_aux= new NeuralNetwork();
                // specify input neuron properties (use default: weighted sum input with
		// linear transfer)
		NeuronProperties inputNeuronProperties = new NeuronProperties();

		// specify map neuron properties
		NeuronProperties outputNeuronProperties = new NeuronProperties();
		outputNeuronProperties.setProperty("weightsFunction", Difference.class);
		outputNeuronProperties.setProperty("summingFunction", Intensity.class);
		outputNeuronProperties.setProperty("transferFunction", Linear.class);

		// set network type
		red_aux.setNetworkType(NeuralNetworkType.KOHONEN);

		// createLayer input layer
		Layer inLayer = LayerFactory.createLayer(inputNeuronsCount,
				inputNeuronProperties);
		red_aux.addLayer(inLayer);

		// createLayer map layer
		Layer mapLayer = LayerFactory.createLayer(outputNeuronsCount,
				outputNeuronProperties);
		red_aux.addLayer(mapLayer);

		// createLayer full connectivity between input and output layer
	        ConnectionFactory.fullConnect(inLayer, mapLayer);
	
	                // set network input and output cells
	        NeuralNetworkFactory.setDefaultIO(red_aux);
	
	        red_aux.setLearningRule(new KohonenLearning());
                   	
                return red_aux;
	}
        * */

}
