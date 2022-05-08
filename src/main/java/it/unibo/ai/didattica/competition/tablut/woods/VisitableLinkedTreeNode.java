package it.unibo.ai.didattica.competition.tablut.woods;

public class VisitableLinkedTreeNode<T, R>
        extends LinkedTreeNode<Visitable<T, R>>
    implements VisitableTreeNode<T, R>
{

    public VisitableLinkedTreeNode(T droplet) {
        super(new VisitableObject<T, R>(droplet));
    }

    public VisitableLinkedTreeNode(VisitableTreeNode<T, R> father, T droplet) {
        super(father, new VisitableObject<T, R>(droplet));
    }

    public VisitableLinkedTree<T, R> newVisitableTree() {
        return new VisitableLinkedTree<T, R>(this);
    }

}
