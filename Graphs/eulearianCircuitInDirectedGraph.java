/*
https://practice.geeksforgeeks.org/problems/euler-circuit-in-a-directed-graph/1
Eulerian Path is a path in graph that visits every edge exactly once.
Eulerian Circuit is an Eulerian Path which starts and ends on the same
vertex.

how to check whether graph contains eulerian circuit or not in case of directed graph? 
=> if all the vertices have indegree  == outdegree
if graph contains eulerian circuit then it also contains eulerian path but the reverse is not true

how to check whether graph contains eulerian path or not (in case of directed graph) => if exactly V - 2  vertices have 
indegree == outdegree
and exactly once have indegree greater than outdegree and exaclty one have outdegree greater than indegree
*/
class eulearianCircuitInDirectedGraph{
}