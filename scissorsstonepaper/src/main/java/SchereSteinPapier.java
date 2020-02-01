import javax.swing.*;
import java.io.FileInputStream;
import java.util.*;
import java.util.Timer;

import org.graphstream.ui.graphicGraph.GraphicGraph;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import org.json.JSONArray;
import org.json.JSONObject;

public class SchereSteinPapier {
    private static MyGraph graph;
    private static GraphicGraph showGraph;
    private static ViewPanel view;

    private static HashMap<String, Integer> statistics;

    public static void main(String[] args){
        statistics = new HashMap<>();
        statistics.put("wins", 0);
        statistics.put("loses", 0);
        statistics.put("draws", 0);

        MyScheduler scheduler = new MyScheduler(statistics); //da statistics static ist, wird keine Aktualisierung benötigt
        Timer timer = new Timer();
        timer.schedule(scheduler, 0, 10000); //in Spring mit @EnableScheduling

        Neutron n0;
        Neutron n1;
        Neutron n2;

        try{
            Neutron[] neutrons = loadGraph();
            if(neutrons != null){
                if(neutrons.length == 3){
                    n0 = neutrons[0];
                    n1 = neutrons[1];
                    n2 = neutrons[2];
                }else{
                    throw new NullPointerException();
                }
            }else{
                throw new IllegalArgumentException();
            }
        }catch(Exception e){
            n0 = new Neutron(0, 2);
            n1 = new Neutron(1, 2);
            n2 = new Neutron(2, 2);
        }

        MyEdge e0 = new MyEdge(n0, n2);
        MyEdge e1 = new MyEdge(n1, n2);

        Set<Neutron> neutrons = new HashSet<>();
        Set<MyEdge> edges = new HashSet<>();

        neutrons.add(n0);
        neutrons.add(n1);
        neutrons.add(n2);

        edges.add(e0);
        edges.add(e1);

        graph = new MyGraph(neutrons, edges);

        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        showGraph = new GraphicGraph("AI");
        showGraph();
        Viewer viewer = new Viewer(showGraph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.disableAutoLayout();
        view = viewer.addDefaultView(false);
        view.setBounds(10, 110, 400, 400);
        //view.getCamera().setAutoFitView(false);
        //view.getCamera().setViewCenter(0, 0, 0);
        //view.getCamera().setViewPercent(1);

        double[] inputs = {0.0, 0.0};

        JFrame window = new JFrame();
        window.setLayout(null);
        window.setSize(430,560);

        JTextField in = new JTextField();
        in.setBounds(10,10,400,25);

        JTextField out = new JTextField();
        out.setBounds(10,80,400,25);

        JButton schere = new JButton("Schere");
        schere.setBounds(10,40,120,30);

        JButton stein = new JButton("Stein");
        stein.setBounds(150,40,120,30);

        JButton papier = new JButton("Papier");
        papier.setBounds(290,40,120,30);

        window.getContentPane().add(in);
        window.getContentPane().add(out);
        window.getContentPane().add(schere);
        window.getContentPane().add(stein);
        window.getContentPane().add(papier);
        window.add(view);
        window.setVisible(true);

        schere.addActionListener(e -> {
            String text = "Schere gegen ";
            int number = graph.result(inputs);
            inputs[0] = number;
            inputs[1] = 0;
            switch(number){
                case 0:
                    text += "Schere";
                    out.setText("Unentschieden.");
                    statistics.put("draws", statistics.get("draws") + 1);
                    break;
                case 1:
                    text += "Stein";
                    out.setText("Computer hat gewonnen.");
                    statistics.put("loses", statistics.get("loses") + 1);
                    break;
                default:
                    text += "Papier";
                    out.setText("Spieler hat gewonnen.");
                    statistics.put("wins", statistics.get("wins") + 1);
                    break;
            }
            graph.updateGraph(inputs);
            in.setText(text);
            showGraph();
            view.display(showGraph, true);
        });

        stein.addActionListener(e -> {
            String text = "Stein gegen ";
            int number = graph.result(inputs);
            inputs[0] = number;
            inputs[1] = 1;
            switch(number){
                case 0:
                    text += "Schere";
                    out.setText("Spieler hat gewonnen.");
                    statistics.put("wins", statistics.get("wins") + 1);
                    break;
                case 1:
                    text += "Stein";
                    out.setText("Unentschieden.");
                    statistics.put("draws", statistics.get("draws") + 1);
                    break;
                default:
                    text += "Papier";
                    out.setText("Computer hat gewonnen.");
                    statistics.put("loses", statistics.get("loses") + 1);
                    break;
            }
            graph.updateGraph(inputs);
            in.setText(text);
            showGraph();
            view.display(showGraph, true);
        });

        papier.addActionListener(e -> {
            String text = "Papier gegen ";
            int number = graph.result(inputs);
            inputs[0] = number;
            inputs[1] = 2;
            switch(number){
                case 0:
                    text += "Schere";
                    out.setText("Computer hat gewonnen.");
                    statistics.put("loses", statistics.get("loses") + 1);
                    break;
                case 1:
                    text += "Stein";
                    out.setText("Spieler hat gewonnen.");
                    statistics.put("wins", statistics.get("wins") + 1);
                    break;
                default:
                    text += "Papier";
                    out.setText("Unentschieden.");
                    statistics.put("draws", statistics.get("draws") + 1);
                    break;
            }
            graph.updateGraph(inputs);
            in.setText(text);
            showGraph();
            view.display(showGraph, true);
        });
    }

    private static void showGraph(){
        showGraph.clear();

        for(int i = 0; i < 3; i++){
            showGraph.addNode(String.valueOf(i));
            if(i < 2){
                showGraph.getNode(String.valueOf(i)).setAttribute("xy", 200, 100 + i * 200);
            }else{
                showGraph.getNode(String.valueOf(i)).setAttribute("xy", 300, 200);
            }
            showGraph.getNode(String.valueOf(i)).setAttribute("ui.style",
                    "fill-color: rgb(0,180,30);" +
                            "size: 30px;");
        }

        showGraph.addNode("-1");
        showGraph.getNode("-1").setAttribute("xy", 150, 100);
        showGraph.getNode("-1").setAttribute("ui.style",
                "fill-color: rgb(10,10,10);" +
                        "size: 10px;");
        //showGraph.getNode("-1").setAttribute("ui.hide");
        showGraph.addNode("-2");
        showGraph.getNode("-2").setAttribute("xy", 150, 300);
        showGraph.getNode("-2").setAttribute("ui.style",
                "fill-color: rgb(10,10,10);" +
                        "size: 10px;");
        //showGraph.getNode("-2").setAttribute("ui.hide");

        for(MyEdge edge : graph.getEdges()){
            String firstNode = String.valueOf(edge.getFirstNode().getId());
            String secondNode = String.valueOf(edge.getSecondNode().getId());
            showGraph.addEdge(firstNode + secondNode, firstNode, secondNode, true);
            for(Neutron neutron : graph.getNodes()){
                if(secondNode.equals(String.valueOf(neutron.getId()))){
                    double weight = neutron.getWeights()[edge.getFirstNode().getId()];
                    //showGraph.getEdge(firstNode + secondNode).setAttribute("ui.label", weight);
                    showGraph.getEdge(firstNode + secondNode).setAttribute("ui.style",
                                    "fill-color: rgb(200,30,40);" +
                                            "size: " + (3*weight+1) + "px;" +
                                            "arrow-shape: arrow;" +
                                            "arrow-size: " + (20*weight+1) + "px, " + (10*weight+1) + "px;");
                }
            }
        }

        showGraph.addEdge("-10", "-1", "0", true);
        showGraph.addEdge("-20", "-2", "0", true);
        showGraph.addEdge("-11", "-1", "1", true);
        showGraph.addEdge("-21", "-2", "1", true);

        List<Neutron> neutrons = new ArrayList<>(graph.getNodes());
        for(Neutron neutron : graph.getNodes()){
            for(MyEdge edge : graph.getEdges()){
                if(neutron.equals(edge.getSecondNode())){
                    neutrons.remove(neutron);
                }
            }
        }
        /*
        showGraph.getEdge("-10").setAttribute("ui.label", neutrons.get(0).getWeights()[0]);
        showGraph.getEdge("-20").setAttribute("ui.label", neutrons.get(0).getWeights()[1]);
        showGraph.getEdge("-11").setAttribute("ui.label", neutrons.get(1).getWeights()[0]);
        showGraph.getEdge("-21").setAttribute("ui.label", neutrons.get(1).getWeights()[1]);
        */
        showGraph.getEdge("-10").setAttribute("ui.style",
                "fill-color: rgb(200,30,40);" +
                        "size: " + (3*neutrons.get(0).getWeights()[0]+1) + "px;" +
                        "arrow-shape: arrow;" +
                        "arrow-size: " + (20*neutrons.get(0).getWeights()[0]+1) + "px, " +
                        (10*neutrons.get(0).getWeights()[0]+1) + "px;");
        showGraph.getEdge("-20").setAttribute("ui.style",
                "fill-color: rgb(200,30,40);" +
                        "size: " + (3*neutrons.get(0).getWeights()[1]+1) + "px;" +
                        "arrow-shape: arrow;" +
                        "arrow-size: " + (20*neutrons.get(0).getWeights()[1]+1) + "px, " +
                        (10*neutrons.get(0).getWeights()[1]+1) + "px;");
        showGraph.getEdge("-11").setAttribute("ui.style",
                "fill-color: rgb(200,30,40);" +
                        "size: " + (3*neutrons.get(1).getWeights()[0]+1) + "px;" +
                        "arrow-shape: arrow;" +
                        "arrow-size: " + (20*neutrons.get(1).getWeights()[0]+1) + "px, " +
                        (10*neutrons.get(1).getWeights()[0]+1) + "px;");
        showGraph.getEdge("-21").setAttribute("ui.style",
                "fill-color: rgb(200,30,40);" +
                        "size: " + (3*neutrons.get(1).getWeights()[1]+1) + "px;" +
                        "arrow-shape: arrow;" +
                        "arrow-size: " + (20*neutrons.get(1).getWeights()[1]+1) + "px, " +
                        (10*neutrons.get(1).getWeights()[1]+1) + "px;");

        try{
           saveGraph();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void saveGraph(){
        //showGraph.write("src/main/resources/graph.dgs"); //nicht mit GraphicGraph möglich

        MyThread thread = new MyThread(graph);
        thread.start();

        showGraph.setAttribute("ui.screenshot", "src/main/resources/graph.png");
    }

    private static Neutron[] loadGraph() throws Exception{
        FileInputStream jsonInput = new FileInputStream("src/main/resources/graph.json");
        StringBuilder jsonString = new StringBuilder();
        int temp;

        while((temp = jsonInput.read()) != -1){
            jsonString.append((char) temp);
        }

        jsonInput.close();

        JSONObject jsonObject = new JSONObject(jsonString.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("neutrons");
        Neutron[] result = new Neutron[3];

        for(int i = 0; i < jsonArray.length(); i++){
            String stringNeutron = jsonArray.get(i).toString();
            JSONObject jsonNeutron = new JSONObject(stringNeutron);
            JSONArray jsonWeights = jsonNeutron.getJSONArray("weights");
            double[] weights = new double[jsonWeights.length()];

            for(int j = 0; j < jsonWeights.length(); j++){
                weights[j] = jsonWeights.getDouble(j);
            }

            Neutron neutron = new Neutron(jsonNeutron.getInt("id"), weights);
            result[jsonNeutron.getInt("id")] = neutron;
        }

        return result;
    }
}
