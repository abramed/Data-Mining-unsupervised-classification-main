package sample;

public class CompRow {

    private int k;
    private String cout_algo;
    private String temps_exe;

    public CompRow(int k, String cout_algo, String temps_exe) {
        this.k = k;
        this.cout_algo = cout_algo;
        this.temps_exe = temps_exe;
    }

    public int getK() {
        return k;
    }

    public String getCout_algo() {
        return cout_algo;
    }


    public String getTemps_exe() {
        return temps_exe;
    }

    public void setK(int k) {
        this.k = k;
    }

    public void setCout_algo(String cout_algo) {
        this.cout_algo = cout_algo;
    }


    public void setTemps_exe(String temps_exe) {
        this.temps_exe = temps_exe;
    }
}
