class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    //listNode sınıfı
}

public class solution147 {
    
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        } // Node un boş olup olmadığını kontrol ediyoruz
        
        ListNode dummy = new ListNode(0); //dummy yeni bir node oluşturuyoruz değeri 0 ama bir önemi yok.
        ListNode current = head; // current ı head yapıyoruz. head sabit kalsın current gezinebileceğimiz ayracımız olacak.
        
        while(current != null) { // node dolu olduğu sürece devam edecek dış döngü
            ListNode nextNode = current.next;  // geri kalan node değerlerini kaybetmemek için nextNode'da saklıyoruz.
            ListNode prev = dummy; // prev dummy içinde gezinmemizi sağlacak ayracımız olacak.
            
            while(prev.next != null && prev.next.val < current.val) {
                prev = prev.next; // dummydeki listede prevden başlayıp sırayla kontrol ediyoruz current'dan küçük mü diye.
            } // current büyükse prev bir sağa kaydırılır. büyük olan current olan değeri dummyde sıralanmış olur.
            
            current.next = prev.next; // prev.next değerimiz nulldır. current ın nextini null yaparız
            prev.next = current; // current değeri ve yanındaki null ı alıp dummy ye ekleriz.
            
            current = nextNode; // yeni currentımız önceden tuttuğumuz nextNode olur.
        }  
        return dummy.next; // ilk baştaki dummy node u hariç olan yani orjinal sıralamayı döndürür.
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        
        // head adında node yapıyoruz 4-2-1-3

        System.out.print("Orijinal Liste:   ");
        printList(head);

        solution147 solution = new solution147();
        ListNode sortedHead = solution.insertionSortList(head);

        System.out.print("Sıralanmış Liste: ");
        printList(sortedHead);
    }
}

