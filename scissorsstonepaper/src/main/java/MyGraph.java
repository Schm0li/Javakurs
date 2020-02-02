import java.util.*;

public class MyGraph {
    private Set<Neutron> nodes;
    private Set<MyEdge> edges;

    public MyGraph(Set<Neutron> nodes, Set<MyEdge> edges){
        this.nodes = new HashSet<>(nodes);
        this.edges = new HashSet<>(edges);
    }

    private Set<Neutron> nextNodes(Neutron neutron){
        Set<Neutron> result = new HashSet<>();
        for(MyEdge edge : edges){
            if(neutron.equals(edge.getFirstNode())){
                result.add(edge.getSecondNode());
            }
        }
        return result;
    }

    public void updateGraph(double[] lastPicks, int time){
        if(((int) lastPicks[0] + 1) % 3 == (int) lastPicks[1]){
            Set<Neutron> newNodes = new HashSet<>();
            Set<MyEdge> newEdges = new HashSet<>();

            for(Neutron neutron : nodes){
                neutron.update((lastPicks[1] + 1) % 3, time);
                newNodes.add(neutron);

                for(MyEdge edge : edges){
                    if(neutron.equals(edge.getFirstNode())){
                        edge.updateFirstNode(neutron);
                        newEdges.add(edge);
                    }else if(neutron.equals(edge.getSecondNode())){
                        edge.updateSecondNode(neutron);
                        newEdges.add(edge);
                    }
                }
            }

            nodes = new HashSet<>(newNodes);
            edges = new HashSet<>(newEdges);
        }
    }

    public int result(double[] inputs){
        Set<Neutron> workingNodes = new HashSet<>();
        Map<Integer, List<Double>> inputForNodes = new HashMap<>();

        List<Double> currentInputs = new ArrayList<>();
        for (double input : inputs) {
            currentInputs.add(input);
        }

        boolean needed;

        for(MyEdge edge : edges){
            needed = true;
            for(MyEdge otherEdge : edges){
                if(edge.getSecondNode().equals(otherEdge.getFirstNode())){
                    needed = false;
                    break;
                }
            }
            if(needed){
                workingNodes.add(edge.getFirstNode());
                inputForNodes.put(edge.getFirstNode().getId(), currentInputs);
            }
        }

        double[] output = new double[0];

        while(!workingNodes.isEmpty()){
            output = new double[workingNodes.size()];
            int currentNode = 0;

            Set<Neutron> oldNodes = new HashSet<>(workingNodes);
            Set<Neutron> neutrons = new HashSet<>();

            for(Neutron neutron : workingNodes){
                if(neutron.getNeededInputs() == inputForNodes.get(neutron.getId()).size()){
                    Object[] rawInput = inputForNodes.get(neutron.getId()).toArray();
                    double[] doubleInput = new double[rawInput.length];
                    for(int i = 0; i < rawInput.length; i++){
                        doubleInput[i] = (double) rawInput[i];
                    }

                    output[currentNode] = neutron.result(doubleInput);

                    neutrons.add(neutron);
                    currentNode++;
                }
            }

            workingNodes.removeAll(neutrons);

            for(Neutron neutron : oldNodes){
                workingNodes.addAll(nextNodes(neutron));
            }

            List<Double> outputs = new ArrayList<>();
            for (double v : output) {
                outputs.add(v);
            }

            for(Neutron neutron : workingNodes){
                inputForNodes.put(neutron.getId(), outputs);
            }
        }

        return (int) (output[0]) % 3; //nur ein finalen Output angenommen
    }

    public Set<Neutron> getNodes() {
        return nodes;
    }

    public Set<MyEdge> getEdges() {
        return edges;
    }
}
