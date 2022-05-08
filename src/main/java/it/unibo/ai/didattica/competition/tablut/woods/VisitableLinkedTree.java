package it.unibo.ai.didattica.competition.tablut.woods;

public class VisitableLinkedTree<T, R>
        extends LinkedTree<Visitable<T, R>>
    implements VisitableTree<T, R>
{

    public VisitableLinkedTree(VisitableLinkedTreeNode<T, R> root) {
        super(root);
    }

}
