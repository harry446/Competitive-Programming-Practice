package second;

public class Graph {

	//Date Member
	int V;
	int E;
	Edge[] edge;
	
	class Edge{
		int beginV;
		int endV;
	}
	public Graph(int v,int e){
		V = v;
		E = e;
		edge = new Edge [E];
		for(int i=0; i<E; i++){
			edge[i] = new Edge();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g = new Graph(3,3);
		
		g.edge[0].beginV = 0;
		g.edge[0].endV = 0;
		
		g.edge[1].beginV = 0;
		g.edge[1].endV = 2;
		
		g.edge[2].beginV = 0;
		g.edge[2].endV = 0;
		
	}

}
