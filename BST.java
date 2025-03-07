//-----------------------------------------------------
//Title: BTS Class
//Author: Ege Ottan
//ID: 10168090218
//Section: 02
//Assignment: 3
//Description: This class represents a Binary Search Tree (BST)that supports generic data types extending Comparable. It allows insertion, deletion, and in-order traversal of elements.
//-----------------------------------------------------
import java.util.ArrayList;
import java.util.List;

// BinarySearchTree Class
class BST<ege extends Comparable<ege>> {
    private class Node {
        ege data;
        Node left, right;

        Node(ege data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    /*
    // Summary: Creates an empty Binary Search Tree (BST) instance.
    // Precondition: None
    // Postcondition: Initializes the BST with no elements (root is null).
    */
    public BST() {
        root = null;
    }

    /*
    // Summary: Adds a new element to the BST.
    // Precondition:data is a value of type T (must extend Comparable).
    // Postcondition: The value is inserted at the appropriate location in the tree.
    */
    public void insert(ege data) {
        root = insertRec(root, data);
    }

    /*
    // Summary: Helper method to handle the recursive insertion of an element.
    // Precondition: root is the current node in the tree, and data is the value to be added.
    // Postcondition: Inserts the value at its correct position in the subtree.
    */
    private Node insertRec(Node root, ege data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) >= 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    /*
    // Summary: Removes an element from the BST.
    // Precondition: data is a value of type T (must extend Comparable).
    // Postcondition:  If the value exists, it is removed from the tree.
    */
    public void delete(ege data) {
        root = deleteRec(root, data);
    }

    /*
    // Summary: Helper method to handle the recursive deletion of an element.
    // Preconditions: root is the current node in the tree, and data is the value to be removed.
    // Postconditions: Removes the value if it exists in the subtree.
    */
    private Node deleteRec(Node root, ege data) {
        if (root == null) return root;
        if (data.compareTo(root.data) < 0) {
            root.left = deleteRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    /*
    // Summary:  Identifies the smallest value in the tree or subtree.
    // Preconditions: root is the current node in the tree.
    // Postconditions: Returns the minimum value in the subtree.
    */
    private ege minValue(Node root) {
        ege minValue = root.data;
        while (root.left != null) {  //stopping condition
            root = root.left;
            minValue = root.data;
        }
        return minValue;
    }

    /*
    // Summary: Retrieves all elements in the BST in sorted (in-order) order.
    // Preconditions: None.
    // Postconditions: Returns a list of elements sorted in ascending order.
    */
    public List<ege> inOrderTraversal() {
        List<ege> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    /*
    // Summary: Recursively traverses the BST in in-order and collects elements.
    // Preconditions: root is the current node in the tree, and result is the list to store elements.
    // Postconditions: Adds elements to the result list in sorted order.
    */
    private void inOrderRec(Node root, List<ege> result) {
        if (root != null) {
            inOrderRec(root.left, result);
            result.add(root.data);
            inOrderRec(root.right, result);
        }
    }
}
