package tsp;

import java.util.ArrayList;

public class Maze {
    State[] stateList = new State[11];
    double gamma;

    public Maze(){
        this.createStateList();
    }

    public void createStateList(){
        ArrayList<String> temp = myFileReader.importFromFile("reinforcement_maze.txt");
        //Removes the number of actions
        temp.remove(0);
        //Removes the number of states
        temp.remove(0);
        //takes the value of gamma then removes that entry
        gamma = Double.parseDouble( temp.get(0));
        temp.remove(0);
        //Sets stateList according to the State constructor
        for (int i = 0; i < 11; i++) {
           State tempState = new State(Double.parseDouble(temp.get(0)),
                                       Boolean.parseBoolean(temp.get(1)), 
                                       temp.get(2));
            //removes the first 3 elements just used.
            temp.remove(0);temp.remove(0);temp.remove(0);
            stateList[i] = tempState;
        }
    }

    public void calculateStateUtility(int x){
        //Captures state x where x is 1,2... to 11 states
        State state = stateList[x];
        //A copy of the matrix from state x
        double[][] tmatrix = state.getMatrix();
        //An array of doubles to be used for each state in an action (up,down,etc)
        double[] utility = new double[4];
        //puts all action utilities at baseline from reward
        for (int i = 0; i < utility.length; i++) {
            utility[i] = state.getReward();
        }
        //fori moves through both utility and the tmatrix Action value
        //forj moves through the state values
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 11; j++) {
                    utility[i] += (tmatrix[i][j] * stateList[j].getUtility());
                }
            }    
        }

    public void printStateList(){
        for (State state : stateList) {
            state.printState();
        }
    }
}
