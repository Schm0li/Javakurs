public class Neutron {
    private int id;
    private int neededInputs;
    private double[] weights;

    public Neutron(int id, int weights){
        this.id = id;
        neededInputs = weights;
        this.weights = new double[weights];
        for(int i = 0; i < weights; i++){
            this.weights[i] = Math.random() * 3;
        }
    }

    public Neutron(int id, double[] weights){
        this.id = id;
        neededInputs = weights.length;
        this.weights = weights;
    }

    public double result(double[] inputs){
        double result = 0;

        for(int i = 0; i < inputs.length; i++){
            result += inputs[i] * weights[i];
        }

        return result;
    }

    public int getId() {
        return id;
    }

    public int getNeededInputs() {
        return neededInputs;
    }

    public double[] getWeights(){
        return weights;
    }

    public void update(double expected){
        for(int i = 0; i < weights.length; i++){
            weights[i] += weights[i] * (1 / (expected + 1));
            if(weights[i] < 0){
                weights[i] += 3;
            }else if(weights[i] > 3){
                weights[i] -= 3;
            }
        }
    }

    @Override
    public boolean equals(Object other){
        Neutron neutron = (Neutron) other;
        return id == neutron.getId();
    }
}
