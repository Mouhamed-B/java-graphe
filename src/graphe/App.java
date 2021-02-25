package graphe;

import java.util.ArrayList;

public class App {
	static Graphe g = new Graphe();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		g.buildMatAd();
		g.showMatAd();
		see(g.adjMatAd(0, 3));
		see(g.adjMatAd('a', 'd'));
		see(g.adjMatAd('a', 'g'));
		see(g.isMultiGraphe());
		//see((ArrayList<Object>)g.neighbourhood('d'));;
		/* double a=Math.PI;
		System.out.println(a); */
	}

	public static void see(String str){
		System.out.println(str);
	}

	public static void see(boolean a){
		System.out.println(a);
	}

	public static void see(int a){
		System.out.println(a);
	}

	public static void see(double a){
		System.out.println(a);
	}

	public static void see(ArrayList<Object> list) {
		System.out.println("[\t");
		for (Object node : list) {
			System.out.print(node.toString()+"\t");
		}
		System.out.println("]");
	}

}
