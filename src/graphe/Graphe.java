package graphe;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;

public class Graphe {

	private Map<Character,Integer> nodeToInt;
	private char[] intToNode = {'a','b','c','d','e','f','g','h'};
	private int[][] matAd;
	private Map<Integer,HashSet<Integer>> listAd;

	Graphe(){  
		nodeToInt = new HashMap<>();
		nodeToInt.put('a',0);
		nodeToInt.put('b',1);
		nodeToInt.put('c',2);
		nodeToInt.put('d',3);
		nodeToInt.put('e',4);
		nodeToInt.put('f',5);
		nodeToInt.put('g',6);
		nodeToInt.put('h',7);
		
		matAd = new int[8][8];
		
		this.initMatAd();

		//System.out.println(nodeToInt.get('a'));
	}

	public void initMatAd(){
		int n = matAd.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matAd[i][j] = 0;
			}
		}
	}
	public void showMatAd(){
		int n = matAd.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matAd[i][j]+"\t");
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
	
	public void buildMatAd(){
		matAd[0][3] = 1;
		matAd[1][2] = 1;
		matAd[1][3] = 1;
		matAd[2][4] = 1;
		matAd[3][4] = 1;
		matAd[3][6] = 1;
		matAd[3][7] = 1;
		matAd[4][7] = 1;
		matAd[5][6] = 1;
		matAd[6][7] = 1;

		matAd[3][0] = 1;
		matAd[2][1] = 1;
		matAd[3][1] = 1;
		matAd[4][2] = 1;
		matAd[4][3] = 1;
		matAd[6][3] = 1;
		matAd[7][3] = 1;
		matAd[7][4] = 1;
		matAd[6][5] = 1;
		matAd[7][6] = 1;
	}

	public void buildListAd(){
		listAd.put(0,list(3));
		listAd.put(1,list(2,3));
		listAd.put(2,list(4));
		listAd.put(3,list(4,6,7));
		listAd.put(4,list(2,3,7));
		listAd.put(5,list(6));
		listAd.put(6,list(3,5,7));
		listAd.put(7,list(3,4,6));
	}

	//Hashset
	public ArrayList<Integer> list(Integer ... list) {
		return (ArrayList<Integer>) Arrays.asList(list);
	}

	public ArrayList<Double> list(Double ... list) {
		return (ArrayList<Double>) Arrays.asList(list);
	}

	public ArrayList<String> list(String ... list) {
		return (ArrayList<String>) Arrays.asList(list);
	}

	public boolean adjMatAd(int n1, int n2){
		return (matAd[n1][n2]==1 || matAd[n2][n1]==1) ? true : false ;
	}

	public boolean adjMatAd(char n1, char n2){
		return adjMatAd(nodeToInt.get(n1), nodeToInt.get(n2));
	}

	public boolean adjListAd(int n1, int n2) {
		return listAd.get(n1).contains(n2);
	}
	
	public boolean adjListAd(char n1, char n2) {
		return listAd.get(nodeToInt.get(n1)).contains(nodeToInt.get(n2));
	}

	public int degree(){
		int degree = 0, n = matAd.length; 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				degree += matAd[i][j];
			}
		}
		return degree;
	}

	public int nodeDegree(int node){
		int degree = 0, n = matAd.length; 
		for (int i = 0; i < n; i++) {
			degree += matAd[node][i];
		}
		return degree;
	}

	public int nodeDegree(char node){
		return nodeDegree(nodeToInt.get(node));
	}

	public boolean isMultiGraphe(){
		int n = matAd.length;
		boolean result = false;
		for (int i = 0; i < n; i++) {
			if (matAd[i][i]==1) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Integer> neighbour(int node){
		int n = matAd.length;
		//int[] neighbour = new int[nodeDegree(node)];
		//System.out.println("Les voisins de "+node+" sont : ");
		ArrayList<Integer> neighbour = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (matAd[node][i]==1) {
				neighbour.add(i);
			}			
		}
		return neighbour;
	}

	public ArrayList<Character> neighbour(char node){
		ArrayList<Integer> neighbourhood =
			neighbour(nodeToInt.get(node));
		int n = neighbourhood.size();
		ArrayList<Character> neighbour = new ArrayList<>();
		for (int val : neighbourhood) {
			neighbour.add(intToNode[val]);
		}
		return neighbour;
	}

	public ArrayList precedentList(int start) {
		ArrayList<Integer> fifo = new ArrayList<>();
		ArrayList<Integer> precedent = new ArrayList<>();
		ArrayList<Integer> distance = new ArrayList<>();
		HashSet<Integer> marked = new HashSet<>();

		int n = getOrder();
		int l;
		//init
		for (int i = 0; i < n; i++) {
			distance.set(i, Integer.MAX_VALUE);
		}
		distance.set(start,0);
		fifo.add(start);
		int exploreNode;
		ArrayList<Integer> neighboorList;
		while(fifo.size()!=0){
			exploreNode = fifo.get(0);
			neighboorList = neighbour(exploreNode);
			int dist0;
			
		}
	
		return null;
	}

}
