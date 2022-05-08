package it.unibo.ai.didattica.competition.tablut.intelligence;

public abstract class AbstractTimedGameIntelligence
        implements GameIntelligence {

    public static final long DEFAULT_MAX_THINK_MILLIS = 59000;

    private long thinkMillis = DEFAULT_MAX_THINK_MILLIS;

    public AbstractTimedGameIntelligence(long thinkMillis) {
        this.thinkMillis = thinkMillis;
    }

    public AbstractTimedGameIntelligence() {
        this(DEFAULT_MAX_THINK_MILLIS);
    }

    public long getThinkMillis() {
        return thinkMillis;
    }

    public void setThinkMillis(long thinkMillis) {
        this.thinkMillis = thinkMillis;
    }
}
