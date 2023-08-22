package temp;


import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TempTree<V> implements Comparable<TempTree> {
    public String nodeName;
    public V node;
    public List<TempTree> childs;
    public TempTree father;
    public int depth;
    public TempTree(String nodeName){
        this.nodeName=nodeName;
        this.node=null;
        this.childs=null;
        this.father=null;
        this.depth=1;
    }

    public TempTree() {
        this.nodeName=null;
        this.node=null;
        this.childs=null;
        this.father=null;
        this.depth=1;
    }

    public void addNode(TempTree obj){
        if(null==childs){
            childs=new ArrayList<>();
        }
        childs.add(obj);
        obj.father=this;
        obj.depth=obj.getDepth();
    }
    //增加树的深度
    public Integer getDepth(){
        if(null!=this.father)
            return 1+father.getDepth();
        else
            return 1;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("nowNode: "+nodeName+"  depth: "+depth+"\n");
        if(null!=childs){
            for(TempTree tree:childs){
                sb.append(tree.toString());
            }
        }
        return sb.toString();
    }
    public TempTree getTreeNode(String treeName){
        if(null!=childs)
            for(TempTree tree:childs){
                if(tree.isTreeName(treeName))
                    return tree;
            }
        return null;
    }
    public Boolean isTreeName(String treeName){
        return this.nodeName.equals(treeName);
    }

    @Override
    public int compareTo(@NotNull TempTree obj) {
        if(this.depth== obj.depth && this.nodeName.equals(obj.nodeName))
            return 1;
        else return -1;
    }
}
