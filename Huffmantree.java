import java.util.*;

class Node {
    int freq;
    char ch;
    Node left, right;

    Node(int freq, char ch) {
        this.freq = freq;
        this.ch = ch;
        left = right = null;
    }
}

class MyComparator implements Comparator<Node> {
    public int compare(Node x, Node y) {
        return x.freq - y.freq;
    }
}

public class HuffmanTree {
    static Map<Character, String> huffmanCodes = new HashMap<>();

    static void generateCodes(Node root, String code) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.ch, code);
            System.out.println(root.ch + " : " + code);
            return;
        }

        generateCodes(root.left, code + "0");
        generateCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freq = new int[n];

        System.out.println("Enter characters:");
        for (int i = 0; i < n; i++) chars[i] = sc.next().charAt(0);

        System.out.println("Enter frequencies:");
        for (int i = 0; i < n; i++) freq[i] = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>(new MyComparator());
        for (int i = 0; i < n; i++) pq.add(new Node(freq[i], chars[i]));

        Node root = null;
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node newNode = new Node(left.freq + right.freq, '-');
            newNode.left = left;
            newNode.right = right;
            root = newNode;
            pq.add(newNode);
        }

        System.out.println("\nHuffman Table:");
        generateCodes(root, "");

        System.out.print("\nEnter a word to encode: ");
        String word = sc.next();

        StringBuilder encodedString = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (huffmanCodes.containsKey(c)) {
                encodedString.append(huffmanCodes.get(c));
            } else {
                System.out.println("\n Character '" + c + "' not in Huffman Tree!");
            }
        }

        System.out.println("Encoded Huffman Code: " + encodedString.toString());
        sc.close();
    }
}
