import org.json.JSONObject;

import java.io.FileOutputStream;

public class MyThread extends Thread {
    private MyGraph graph;

    public MyThread(MyGraph graph){
        this.graph = graph;
    }

    @Override
    public void run(){
        try{
            StringBuilder graphData = new StringBuilder("{\"neutrons\":[");
            int neutronNumber = 0;

            for (Neutron neutron : graph.getNodes()) {
                graphData.append("{\"id\":").append(neutron.getId()).append(",");

                StringBuilder weights = new StringBuilder("[");
                double[] neutronWeights = neutron.getWeights();

                for (int i = 0; i < neutronWeights.length; i++) {
                    if (i < neutronWeights.length - 1) {
                        weights.append(neutronWeights[i]).append(",");
                    } else {
                        weights.append(neutronWeights[i]).append("]");
                    }
                }

                if (neutronNumber < 2) {
                    graphData.append("\"weights\":").append(weights).append("},");
                } else {
                    graphData.append("\"weights\":").append(weights).append("}]}");
                }

                neutronNumber++;
            }

            JSONObject jsonGraph = new JSONObject(graphData.toString());
            String parsedJsonGraph = jsonGraph.toString();
            FileOutputStream jsonOutput = new FileOutputStream("src/main/resources/graph.json");

            for (int i = 0; i < parsedJsonGraph.length(); i++) {
                jsonOutput.write(parsedJsonGraph.charAt(i));
            }

            jsonOutput.close();
        }catch(Exception ignored){

        }
    }
}
