package tsp;
import java.util.ArrayList;

public class State {
    private int actions;
    private int states;
    private String fileName;
    private double reward;
    private double utility;
    private boolean terminal;
    private double[][] transitionMatrix;

    //Default Constructor
    public State() {}

    //Overloaded Constructor
    public State(double reward, boolean terminal, String fileName) {
        this.fileName = fileName;
        this.reward = reward;
        this.terminal = terminal;
        initializeState(fileName);
    }

    //handles IO from file and initializes the transition Matrix
    private void initializeState(String fileName){
        ArrayList<String> temp = myFileReader.importFromFile(fileName);
        transitionMatrix = new double[4][11];
        if (temp.size()==0){
            for (int i = 0; i < 44; i++) {
                this.transitionMatrix[i/11][i%11] = 0.0;
            }
            return;
        }
        this.actions = Integer.parseInt(temp.get(0));
        this.states = Integer.parseInt(temp.get(1));
        temp.remove(0);
        temp.remove(0);
        int size = temp.size();
        for (int i = 0; i < size; i++) {
            this.transitionMatrix[i/11][i%11] = Double.parseDouble(temp.get(i));
        }
        }
    

    //Prints all transition coefficients from the matrix
    public void printState() {
        for (double[] ds : transitionMatrix) {
            for (double d : ds) {
                System.out.println(d);
            }
        }
    }

    public double getReward(){
        return this.reward;
    }

    public double[][] getMatrix(){
        return this.transitionMatrix;
    }
    
    public double getUtility(){
        return this.utility;
    }
    public void setUtility(double x){
        this.utility = x;
    }

}
    
