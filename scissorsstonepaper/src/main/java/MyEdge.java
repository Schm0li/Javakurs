public class MyEdge {
    private Neutron firstNode;
    private Neutron secondNode;

    public MyEdge(Neutron firstNode, Neutron secondNode){
        this.firstNode = firstNode;
        this.secondNode = secondNode;
    }

    public Neutron getFirstNode() {
        return firstNode;
    }

    public Neutron getSecondNode() {
        return secondNode;
    }

    public void updateFirstNode(Neutron firstNode){
        this.firstNode = firstNode;
    }

    public void updateSecondNode(Neutron secondNode){
        this.secondNode = secondNode;
    }
}
