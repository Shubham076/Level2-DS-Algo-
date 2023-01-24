/*
 You are given a complete, balanced N-Ary Tree and must support Q queries. There are 3 kinds of queries. Return true or false depending on whether the query was successful.

Lock(v, id) - Lock vertex v for user - id
Unlock(v, id) - If vertex v is locked by the same id, unlock it.
Upgrade(v, id) - If v is unlocked and has at least one locked vertex in it's subtree and every locked vertex in the subtree of v is locked by id, unlock them and lock v instead.
Further, here are some additional constraints

A vertex cannot be locked if it has any locked ancestors or descendants, by any ID.
When a vertex is upgraded, it's locked descendants are automatically unlocked.
An upgrade operation is not possible if the vertex is already locked or has any locked ancestors
An unlock operation is only possible if the vertex is already locked and locked by the same id
 */
import java.util.*;
public class treeOfSpace {
    static class Vertex {
        int id;
        boolean locked;
        int lockId;
        Vertex parent;
        List<Vertex> children;
        // ...
    
        public boolean lock(int id) {
            if (locked || hasLockedAncestor()) {
                return false;
            }
            locked = true;
            lockId = id;
            return true;
        }
    
        public boolean unlock(int id) {
            if (!locked || lockId != id) {
                return false;
            }
            locked = false;
            lockId = -1;
            return true;
        }
    
        public boolean upgrade(int id) {
            if (locked || hasLockedAncestor()) {
                return false;
            }
            if (!hasLockedDescendant(id)) {
                return false;
            }
            unlockDescendants(id);
            locked = true;
            lockId = id;
            return true;
        }
    
        private boolean hasLockedAncestor() {
            Vertex current = this.parent;
            while (current != null) {
                if (current.locked) { 
                    return true;
                }
                current = current.parent;
            }
            return false;
        }
    
        private boolean hasLockedDescendant(int id) {
            for (Vertex child : children) {
                if (child.locked && child.lockId == id) {
                    return true;
                }
                if (child.hasLockedDescendant(id)) {
                    return true;
                }
            }
            return false;
        }
        
        private void unlockDescendants(int id) {
            for (Vertex child : children) {
                if (child.locked && child.lockId == id) {
                    child.locked = false;
                    child.lockId = -1;
                }
                child.unlockDescendants(id);
            }
        }        
    }
    
    static class NTree {
        Vertex root;
        Map<Integer, Vertex> idToVertex;
    
        public NTree(Vertex root) {
            this.root = root;
            idToVertex = new HashMap<>();
            dfs(root);
        }
    
        private void dfs(Vertex v) {
            idToVertex.put(v.id, v);
            for (Vertex child : v.children) {
                dfs(child);
            }
        }
    
        public boolean lock(int v, int id) {
            return idToVertex.get(v).lock(id);
        }
    
        public boolean unlock(int v, int id) {
            return idToVertex.get(v).unlock(id);
        }
    
        public boolean upgrade(int v, int id) {
            return idToVertex.get(v).upgrade(id);
        }
    }
}
