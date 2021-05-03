package singly.array;


public class SListUsingArray {
	public class SListNode {
		int data;
		int next;
		boolean isUsed;
	}
	private int size;
	private SListNode[] nodes;
	private int head;

	public SListUsingArray(int n) {
		size = n;
		nodes = new SListNode[size];
		head = -1;
		for (int i = 0; i < size; ++i) {
			nodes[i] = new SListNode();
			nodes[i].isUsed = false;
		}
	}
	private int getFreeNode() {
		for (int i = 0; i < size; ++i) {
			if (!nodes[i].isUsed) {
				nodes[i].isUsed = true;
				return i;
			}
		}
		return -1;
	}
	public void insert(int elem) {
		int n = getFreeNode(); // 1. Create new node.
		/* if (n == -1) {
		 * return;
		 * }
		 * 
		 * n = new SListNode()
		 * if (n == null) {
		 * return;
		 * }
		 */
		// 2. Set data to new node and next to null.
		nodes[n].data = elem;
		nodes[n].next = -1;
		// 3. If list is empty
		if (head == -1) {
			// 3.1 Make new node as first node.
			head = n;
			return;
		}
		// 4. Set prev to null and curr to head.
		int prev = -1;
		int curr = head;
		// 5. Loop
		while ((curr != -1) && (nodes[curr].data < nodes[n].data)) {
			// 5.1 Set prev to curr
			prev = curr;
			// 5.2 Set curr to curr's next node.
			curr = nodes[curr].next;
		}
		// 6. Adding at start?
		if (prev == -1) {
			// 6.1 Make head come after new node.
			nodes[n].next = head;
			// 6.2 Make new node as head node.
			head = n;
			return;
		}
		// 7. Adding at end?
		if (curr == -1) {
			// 7.1 Set new node as prev node's next.
			nodes[prev].next = n;
			return;
		}
		// 8. Set new node come after prev node.
		nodes[prev].next = n;
		// 9. Set curr node come after new node.
		nodes[n].next = curr;
	}
	public void print() {
		int curr = head;
		while (curr != -1) {
			System.out.println(nodes[curr].data);
			curr = nodes[curr].next;
		}
	}
	public void delete(int num) {

		int curr = head;
		int prev = -1;
		while ((curr != -1) && (nodes[curr].data != num)) {
			prev = curr;
			curr = nodes[curr].next;
		}

		if (curr == -1) {
			return;
		}
		if (prev == -1) {
			head = nodes[curr].next;
			return;
		}

		nodes[prev].next = nodes[curr].next;

	}
}
