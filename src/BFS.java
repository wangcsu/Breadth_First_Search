import java.sql.ResultSet;
import java.sql.SQLException;

public class BFS {

	public static void main(String[] args) {
		Queue q = new Queue();
		DataBase db = new DataBase("genDB");
		BFSnode bfs = new BFSnode();
		int parent = 0;
		bfs.setLetter(args[0]);
		bfs.setDepth(parent);
		q.enqueue(bfs);
		while(!q.isEmpty()){
			bfs = (BFSnode) q.dequeue();
			if (bfs.getDepth() > parent){
				System.out.println();
			}
			parent = bfs.getDepth();
			System.out.print(bfs.getLetter() + " ");
			String query = "select CHILD from Letters where PARENT = '" + bfs.getLetter() + "'";
			ResultSet rs = db.execute(query);
			try {
				while (rs.next()){
					bfs = new BFSnode();
					bfs.setLetter(rs.getString("CHILD"));
					bfs.setDepth(parent+1);
					q.enqueue(bfs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("");
	}

}
//output
//A
//B C D
//E F G H
//I J K
//L
