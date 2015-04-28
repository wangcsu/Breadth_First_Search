
public class Queue {
	
	Node head = null;
	Node tail = null;
	
	Queue(){
		super();
	}
	
	boolean isEmpty(){
		return head == null;
	}
	
	void enqueue(Object obj){
		Node tmp = new Node (obj);
		if (isEmpty()){
			head = tmp;
			tail = tmp;
		} else {
			tail.next = tmp;
			tail = tmp;
		}
	}
	
	Object dequeue(){
		Object el = head.element;
		head = head.next;
		if (isEmpty()){
			tail = null;
		}
		return el;
	}

}