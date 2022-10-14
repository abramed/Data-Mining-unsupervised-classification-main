package outils;

public class Stat {

    private String moyenne;
    private String mediane;
    private String mode;

    public String getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(String moyenne) {
        this.moyenne = moyenne;
    }

    public String getMediane() {
        return mediane;
    }

    public void setMediane(String mediane) {
        this.mediane = mediane;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Stat(String moyenne, String mediane, String mode) {
        this.moyenne = moyenne;
        this.mediane = mediane;
        this.mode = mode;
    }
}
