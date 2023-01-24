/*
algorithm:
Algorithm:
level graph is one in which value of each node is its shortest distance from source in the residual graph. This
graph constains edges with +ve weight only. Update of Level graph includes removal of edges with full capacity
Removal of nodes that are not sink and are dead ends.

O(ev * v)
1: Initialize flow in all edges to be zero.
2: Construct Level graph
3:  while (sink is reachale from source node in level graph)
		while (there is augmenting path between source and sink){
		: find blocking flow f in the level graph 
		: add blocking flow in total flow
		: update residual network
	go to step 2
*/
class dinics {

}