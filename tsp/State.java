package tsp;
import java.util.ArrayList;

public class State {
    private int actions;
    private int states;
    private String fileName;
    private double[][] transitionMatrix;

    public State() {}

    public State(String fileName) {
        initializeState(fileName);
    }

    private void initializeState(String fileName){
        ArrayList<String> temp = myFileReader.importFromFile(fileName);
        this.actions = Integer.parseInt(temp.get(0));
        this.states = Integer.parseInt(temp.get(1));
        temp.remove(0);
        temp.remove(0);
        int size = temp.size();
        transitionMatrix = new double[4][11];
        for (int i = 0; i < size; i++) {
            this.transitionMatrix[i/11][i%11] = Double.parseDouble(temp.get(i));
        }
        }
    

    public void printState() {
        for (double[] ds : transitionMatrix) {
            for (double d : ds) {
                System.out.println(d);
            }
        }
    }

}
    
