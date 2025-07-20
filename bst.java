

public class bst {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            Node n = new Node(val);
            return n;
        }
        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;

    }
    public static boolean   search(Node r , int val){
        if(r==null){
            return false;
        }
        if(r.data == val){
           return true;
        }
        
        if(r.data > val){
           return  search(r.left, val);
        }else{
           return  search(r.right, val);
        }
       
    }
    public static void inorder(Node r){
        if(r== null){
            return;
        }
        inorder(r.left);
        System.out.print(r.data+" ");
        inorder(r.right);
    }
    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);  // ✅
        } else if (root.data < val) {
            root.right = delete(root.right, val);  // ✅
        }

        else{
            //case: 1 leaf node
            if(root.left == null && root.right ==  null){
                return null;
            }
            // case : 2 single child node
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            // case : 3 double child node
            Node IS = inorderSuccesor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node inorderSuccesor(Node r){
        while(r.left != null){
            r = r.left;
        }
        return r;
    }
    public static void inrange(Node r, int l , int h){
        if(r == null){
            return;
        }
        if(r.data >= l && r.data <= h ){
            inrange(r.left, l, h);
            System.out.println(r.data);
            inrange(r.right, l, h);
        }else if(r.data < l){
            inrange(r.right, l, h);
        }else{
            inrange(r.left, l, h);
        }
    }
    public static boolean isValid(Node r, Node max, Node min){
        if( r == null) return true;

        if( min != null && r.data <= min.data ){
            return false;
        }
        if( max != null && r.data >= max. data){
            return false;
        }
        return isValid(r.left, r, min) && isValid(r.right, max, r);
    }
    public static Node createMirror(Node root){
        if(root == null) return root;
        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }
    public static Node createBST(int arr[], int st , int ed){
        if(st> ed){
            return null;
        }
        int mid = (st+ed)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr ,mid+1, ed);
        return  root;
    }
    public static void main(String[] args) {
        int val[] = {1,55,32,23,56,33};
        Node r = null;
        for(int i=0; i<val.length; i++){
            r = insert(r, val[i]);
        }
        inorder(r);
        System.out.println();
       
        // System.out.print(search(r, 100));
        delete(r, 32);
        inorder(r);
        System.out.println(isValid(r, null, null));
        createMirror(r);
        inorder(r);
    }
}
