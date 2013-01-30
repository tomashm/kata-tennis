package no.finntech.kundefront.kata;

public class Score {
    private int server;
    private int receiver;

    public Score(int server, int receiver) {

        this.server = server;
        this.receiver = receiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        if (receiver != score.receiver) return false;
        if (server != score.server) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = server;
        result = 31 * result + receiver;
        return result;
    }
}
