package second;

public class Graph2 {

	int V;
	int E;
	Edge[] edge;
	
	class Edge{
		int beginV;
		int endV;
	}
	
	public Graph2(int v, int e){
		V = v;
		E = e;
		edge = new Edge[E];
		for(int i=0; i<E; i++){
			edge[i] = new Edge();
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph2 g = new Graph2(4,6);
		
		g.edge[0].beginV = 0;
		g.edge[0].endV = 1;
		
		g.edge[1].endV = 0;
		g.edge[1].endV = 2;
		
		g.edge[0].endV = 1;
		g.edge[0].endV = 1;
		
		g.edge[0].endV = 1;
		g.edge[0].endV = 1;
		
		g.edge[0].endV = 1;
		g.edge[0].endV = 1;
		
		g.edge[0].endV = 1;
		g.edge[0].endV = 1;
		
		
		
		
	}

}
