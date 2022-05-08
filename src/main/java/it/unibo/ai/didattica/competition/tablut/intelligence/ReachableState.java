package it.unibo.ai.didattica.competition.tablut.intelligence;

import it.unibo.ai.didattica.competition.tablut.domain.Action;
import it.unibo.ai.didattica.competition.tablut.domain.State;

import java.util.Objects;

public class ReachableState {

    private Action causeAction;
    private State state;

    public ReachableState(Action causeAction, State state) {
        this.causeAction = causeAction;
        this.state = state;
    }

    public ReachableState(State state) {
        this(null, state);
    }

    public Action getCauseAction() {
        return causeAction;
    }

    public void setCauseAction(Action causeAction) {
        this.causeAction = causeAction;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isCausedByAnAction() {
        return causeAction != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReachableState that = (ReachableState) o;
        return Objects.equals(causeAction, that.causeAction) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(causeAction, state);
    }
}
