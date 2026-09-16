public class Node {
  public int value;
  public Node left;
  public Node right; 

  public Node(int value) {
    this.value = value;
  }
}

public class Tree {
  public Node root;
  
  public void insert(int value) {
    Node node = new Node(value);
    this.append(node);
  }

  private void append(Node newNode) {
    if (root == null) {
      root = newNode;
      return ;
    }

    Node current = root;

    while (true) {
      if (newNode.value >= current.value) {
        if (current.right == null) {
          current.right = newNode;
          break;
        }
        current = current.right;
      } else {
        if (current.left == null) {
          current.left = newNode;
          break;
        }
        current = current.left;
      }
    }
  }

  private void preorderTraversalPrint(Node node) {
    if (node == null) return ;

    System.out.println(node.value);
    preorderTraversalPrint(node.left);
    preorderTraversalPrint(node.right);
  }

  public void printTree() {
    preorderTraversalPrint(this.root);
  }

  public boolean has(int value) { 
    Node current = this.root;
    while (current != null && current.value != value) {
      if (value > current.value) current = current.right;
      else current = current.left;
    }

    if (current == null) return false;
    return true;
  }

  private void replaceChild(Node parent, Node oldChild, Node newChild) {
    if (parent == null) {
      root = newChild;
    } else if (parent.left == oldChild) {
       parent.left = newChild;
    } else {
       parent.right = newChild;
    }
  }

  public void remove(int value) {
    Node current = this.root;
    Node parent = null;

    while (current != null && current.value != value) {
      parent = current;
      if (value >= current.value) current = current.right;
      else current = current.left;
    }

    if (current == null) return ;

    if (current.left == null && current.right == null) {
      replaceChild(parent, current, null);
      return ;
    }
    
    if (current.left == null) {
      replaceChild(parent, current, current.right);
      return ;
    }
    
    if (current.right == null) {
      replaceChild(parent, current, current.left);
      return ;
    }

    Node successorParent = current;
    Node successor = current.left; // Maior à esquerda
    
    while (successor.right != null) {
      successorParent = successor;
      successor = successor.right;
    }

    current.value = successor.value;

    replaceChild(successorParent, successor, successor.left);
  }
}

public class Main {
  public static void main(String[] args) {
    Tree tree = new Tree();

    tree.insert(14); 
    tree.insert(15);
    tree.insert(4); 
    tree.insert(9); 
    tree.insert(7); 
    tree.insert(18); 
    tree.insert(3); 
    tree.insert(5);
    tree.insert(16);
    tree.insert(4);
    tree.insert(20);
    tree.insert(17);
    tree.insert(9);
    tree.insert(14);
    tree.insert(5);

    // Imprimir a arvore
    tree.printTree();

    // Verifica se a arvore contem certos numeros nela
    System.out.println(tree.has(15));
    System.out.println(tree.has(99));

    // Remove um numero da arvore
    tree.remove(9);

    // Imprime de novo para confirmar a exclusao
    tree.printTree();
  }
}
