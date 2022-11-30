package jokenpo;

public class Players {
    private String name;
    private Integer score;

    public Players(String name) {
        this.name = name;
        this.score = 0;
    }
    public void incrementScore() {
        setScore(getScore() +1);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
