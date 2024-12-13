import java.util.*;

public class BinarySearchTree {
	void insert(int object){
		if (root == null)
			root = new Node(object);
		else
			insert(root, object);
	}
	void delete(int object){
		root = delete(root, object);
	}
	Node root = null;
	
	
	
	void insert(Node node, int object){

		/// 1回目
		/// 親と比較して小さい場合
		/// かつ、左がnullの場合は親の左へ配置
		/// かつ、左がnull出ない場合は、親の左へ再帰的にinsert処理を進める
		if (object < node.object) {
			if (node.left == null) {
				node.left = Node(object);
			} else {
				insert(node.left, object);
			}
		} 
		/// そうでない場合は右へ配置
		/// かつ、右がnullの場合は親の右へ配置
		/// かつ、右がnullではない場合は、親の右へ再帰的にinsert処理を進める
		else {
			if (node.right == null) {
				node.right = Node(object);
			} else {
				insert(node.right, object);
			}
		}
		
		/// 疑問その1 もし同じ値が来たときはどうなるのか？
		/// 例えば、[6,4,7,3,8,6,9] の二分木について考える
		/// 新しい値として、3 をinseatしたい場合、上記の処理を回すとどうなるか？
		/// [6,4,7,3,8,6,9,null,3] このようになる
		/// したがって、このに分木構造について最も重要なのは、
		/// if(object < node.object) であり、これが二分木の定義だと理解して良さそう
		/// つまり、親に対して左の子は必ず親未満であり、右の子は親に対して親以上を必ず満たす
		
	}

	Node delete(Node node, int object){

		/// 1回目
		/// わかった気はする
		if (node == null) {
			return null;
		} 
		if (object < node.object) { // 左の子供を辿る
			node.left = delete(node.left, object);
			return node;
		}
		else if(object > node.object) {
			node.right = delete(node.right, object);
			return node;
		}
		else { // この node を削除する
			if (node.left == null && node.right == null) {
				// 子がいない
				return null;
			} 
			else if(node.left == null && node.right != null) {
				// 右の子のみ
				return node.right;
			}
			else if(node.left != null && node.right == null) {
				// 左の子のみ
				return node.left;
			}
			else {
				// 子が二つ
				Node min = delete(node.right, node); // 右の子孫の最小値
				min.right = node.right;
				min.left = node.left;
				return min;
			}
		}
	}
	
	Node deletemin(Node node, Node parent){	

		/// 1回目
		/// deletemin が最小値を返すことは理解している
		/// 子孫のうちの最小値を取ってくる
		/// [8,6,12,3,7,10,15] のようなnode配列の時、最小値3を取得する

		/// 親の左右の子の存在を確認する
		/// 右にしか子がいない場合
		if (node.left == null) {
			if (parent.left == node) {
				parent.left = node.right;
			} else {
				parent.right = node.right;
			}
			return node;
		}
		parent = node;
		node = node.left;
		while (node.left != null) { // 左の子を辿る
			parent = node;
			node = node.left;
		}

		parent.left = node.right;
		return node;
	}	
}


class Node {
	Node left;
	Node right;
	int object;
	Node(int _object){
		object = _object;
	}
}


/*
 * ???
 
public class BinarySearchTree {
	void insert(int object){
		if (root == null)
			root = new Node(object);
		else
			insert(root, object);
	}
	void delete(int object){
		root = delete(root, object);
	}
	Node root = null;
	
	
	void insert(Node node, int object){
		if (object < node.object){
			if (node.left == null)
				node.left = new Node(object); //?V?????m?[?h????
			else
				insert(node.left, object);	//????q??H??
		}
		else {
			if (node.right == null)
			   node.right = new Node(object);  //?V?????m?[?h????
			else
			  insert(node.right, object); 	//?E??q??H??
		}
	}

	// ????R?[?h?B??A?I??~?????????I????????????m?[?h????????B?????????? deletemin??????????B
	Node delete(Node node, int object){
		if (node == null)
			return null;
		if (object < node.object){
			node.left = delete(node.left, object);  //????q??H??
			return node;
		}
		else if (object > node.object){
			node.right =  delete(node.right, object); //?E??q??H??
			return node;
		}
		else {	// ????node????????
			if (node.left == null && node.right == null)	//?@?q???????
				return null;
			else if (node.left == null && node.right != null)  // ?E??q???
				return node.right;
			else if (node.left != null && node.right == null)  // ?E??q???
				return node.left;
			else { 					//?q???Q??
				Node min = deletemin(node.right, node);	//?E??q???????l
				min.right = node.right;
				min.left = node.left;
				return min;
			}
		}
	}
	Node deletemin(Node node, Node parent){	//?q????????????l??????????
		if (node.left == null){	// ?E??????q?????
			if (parent.left == node)	// ???????g?????????E??q??z?u????
				parent.left = node.right;
			else 
				parent.right = node.right;
			return node;	//???????g??????l
		}
		parent = node;
		node = node.left;
		while(node.left != null){	//????q??H??
			parent =node;
			node = node.left;
		}
		parent.left = node.right;
		return node;
	}	
}
*/