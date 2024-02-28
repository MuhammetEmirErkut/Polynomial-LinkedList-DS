package Project;

public class Polynomial {
	private Node head; // Bağlı listenin başlangıç düğümü
	
	//Constructers
	
	// Polinomu temsil eden bir obje oluşturur
	public Polynomial() {
		this.head = null; 
	}
	// Parametre olarak verilen bağlı listeyi temsil eden bir obje oluşturur
	public Polynomial(Node head) {
		this.head = head;
	}
	
	public static Polynomial add(Polynomial p1, Polynomial p2) {
	    Node resultHead = null; // Sonucun başlangıç düğümü
	    Node resultTail = null; // Sonucun son düğümü

	    Node current1 = p1.head; // İlk polinomun başlangıç düğümü
	    Node current2 = p2.head; // İkinci polinomun başlangıç düğümü

	    // Her iki polinomun da sonuna kadar işlem yap
	    while (current1 != null || current2 != null) {
	        // İlgili terimlerin katsayıları ve üsleri
	    	int coeff1 = (current1 != null) ? current1.coefficient : 0;// Bu kısımda yapılan işlemi kısaca anlatıyorum aslında biraz daha uzun yazılabilir ancak kotlin kullanırken oğrendiğim, okunabilirlik açısından çok daha iyi olan bir yontem.
            int exp1 = (current1 != null) ? current1.exponent : 0;     // Aslında teknik olarak bir if/else:return yapısı; Eğer verilen polinomda katsayı "null" ise 0 dondürüyor, değilse current'ın katsayısına veya kuvvetine yani üs değerine ulaşıyor.
            int coeff2 = (current2 != null) ? current2.coefficient : 0;// Diğer metodlarda da aynı şekilde kullanıyorum.
            int exp2 = (current2 != null) ? current2.exponent : 0;

	        // Terimlerin farklı üsleri varsa, katsayıları toplamaya gerek olmadığından sırayla ekliyorum
	        if (exp1 != exp2) {
	            if (coeff1 != 0) {
	                Node newNode1 = new Node(coeff1, exp1);
	                if (resultHead == null) {
	                    resultHead = newNode1;
	                    resultTail = newNode1;
	                } else {
	                    resultTail.next = newNode1;
	                    resultTail = newNode1;
	                }
	            }

	            if (coeff2 != 0) {
	                Node newNode2 = new Node(coeff2, exp2);
	                if (resultHead == null) {
	                    resultHead = newNode2;
	                    resultTail = newNode2;
	                } else {
	                    resultTail.next = newNode2;
	                    resultTail = newNode2;
	                }
	            }
	        } else {
	            // Terimlerin toplam katsayısı
	            int sumCoeff = coeff1 + coeff2;

	            // Katsayısı 0 olmayan terimi sonuca ekle
	            if (sumCoeff != 0) {
	                Node newNode = new Node(sumCoeff, exp1);
	                if (resultHead == null) {
	                    resultHead = newNode;
	                    resultTail = newNode;
	                } else {
	                    resultTail.next = newNode;
	                    resultTail = newNode;
	                }
	            }
	        }

	        // İlk polinomun düğümünü bir sonrakine taşı
	        if (current1 != null) {
	            current1 = current1.next;
	        }

	        // İkinci polinomun düğümünü bir sonrakine taşı
	        if (current2 != null) {
	            current2 = current2.next;
	        }
	    }

	    // Oluşturulan sonucu içeren yeni bir polinom döndürür
	    return new Polynomial(resultHead);
	}




	
	// İki polinomu çıkaran ve sonucu döndüren static metod
	public static Polynomial subtract(Polynomial p1, Polynomial p2) {
	    Node resultHead = null; // Sonucun başlangıç düğümü
	    Node resultTail = null; // Sonucun son düğümü

	    Node current1 = p1.head; // İlk polinomun başlangıç düğümü
	    Node current2 = p2.head; // İkinci polinomun başlangıç düğümü

	    // Her iki polinomun da sonuna kadar işlem yap
	    while (current1 != null || current2 != null) {
	        // İlgili terimlerin katsayıları ve üsleri
	        int coeff1 = (current1 != null) ? current1.coefficient : 0;
	        int exp1 = (current1 != null) ? current1.exponent : 0;
	        int coeff2 = (current2 != null) ? current2.coefficient : 0;
	        int exp2 = (current2 != null) ? current2.exponent : 0;

	        // Terimlerin farklı üsleri varsa, katsayıları çıkarma işlemine gerek olmadığından sırayla ekliyorum
	        if (exp1 != exp2) {
	            if (coeff1 != 0) {
	                Node newNode1 = new Node(coeff1, exp1);
	                if (resultHead == null) {
	                    resultHead = newNode1;
	                    resultTail = newNode1;
	                } else {
	                    resultTail.next = newNode1;
	                    resultTail = newNode1;
	                }
	            }

	            if (coeff2 != 0) {
	                Node newNode2 = new Node(-coeff2, exp2); // Çıkarma işlemi
	                if (resultHead == null) {
	                    resultHead = newNode2;
	                    resultTail = newNode2;
	                } else {
	                    resultTail.next = newNode2;
	                    resultTail = newNode2;
	                }
	            }
	        } else {
	            // Terimlerin farkı katsayısı
	            int diffCoeff = coeff1 - coeff2;

	            // Katsayısı 0 olmayan terimi sonuca ekliyorum
	            if (diffCoeff != 0) {
	                Node newNode = new Node(diffCoeff, exp1);
	                if (resultHead == null) {
	                    resultHead = newNode;
	                    resultTail = newNode;
	                } else {
	                    resultTail.next = newNode;
	                    resultTail = newNode;
	                }
	            }
	        }

	        // İlk polinomun düğümünü bir sonrakine taşı
	        if (current1 != null) {
	            current1 = current1.next;
	        }

	        // İkinci polinomun düğümünü bir sonrakine taşı
	        if (current2 != null) {
	            current2 = current2.next;
	        }
	    }

	    // Oluşturulan sonucu içeren yeni bir polinom döndür
	    return new Polynomial(resultHead);
	}
	
	public static Polynomial multiply(Polynomial p1, Polynomial p2) {
	    Node resultHead = null; // Çarpımın başlangıç düğümü
	    Node resultTail = null; // Çarpımın son düğümü

	    Node current1 = p1.head; // İlk polinomun başlangıç düğümü
	    Node current2; // İkinci polinomun başlangıç düğümü

	    while (current1 != null) {
	        current2 = p2.head; // Her bir terim için ikinci polinomu başa al

	        while (current2 != null) {
	            // İlgili terimlerin katsayıları ve üsleri
	            int coeff1 = current1.coefficient;
	            int exp1 = current1.exponent;
	            int coeff2 = current2.coefficient;
	            int exp2 = current2.exponent;

	            // Terimlerin çarpım katsayısı ve toplam kuvveti
	            int productCoeff = coeff1 * coeff2;
	            int sumExp = exp1 + exp2;

	            // Katsayısı 0 olmayan terimi sonuca ekle
	            if (productCoeff != 0) {
	                Node newNode = new Node(productCoeff, sumExp);
	                if (resultHead == null) {
	                    resultHead = newNode;
	                    resultTail = newNode;
	                } else {
	                    resultTail.next = newNode;
	                    resultTail = newNode;
	                }
	            }

	            // İkinci polinomun düğümünü bir sonrakine taşı
	            current2 = current2.next;
	        }

	        // İlk polinomun düğümünü bir sonrakine taşı
	        current1 = current1.next;
	    }

	    // Oluşturulan çarpımı içeren yeni bir polinom döndür
	    return new Polynomial(resultHead);
	}
	
	
	public void print() {
		Node current = head;

        while (current != null) {
            System.out.print(current.coefficient);
            System.out.print("*x^" + current.exponent);

            if (current.next != null) {
                System.out.print(" + ");
            }

            current = current.next;
        }

        System.out.println();
    }
	
	public static void main(String[] args) {
		Polynomial p1 = new Polynomial(new Node(0, 0));
        p1.head.next = new Node(3, 0);
        p1.head.next.next = new Node(1, 1);
        p1.head.next.next.next = new Node(1, 3);
        p1.head.next.next.next.next = new Node(7, 6);
        

        Polynomial p2 = new Polynomial(new Node(1, 2));
        p2.head.next = new Node(1000, 4);

        Polynomial sum = Polynomial.add(p1, p2);
        System.out.print("Toplama Sonucu: ");
        sum.print();
        
        Polynomial substarct = Polynomial.subtract(p1, p2);
        System.out.print("Çıkarma Sonucu: ");
        substarct.print();

      Polynomial multiplicationResult = Polynomial.multiply(p1, p2);
        System.out.print("Çarpma Sonucu: ");
        multiplicationResult.print();
    }
	
}

class Node {
	int coefficient;// Katsayılar
	int exponent;   // Kuvvetler (Üs)
	Node next;      // Bağlı liste içerisindeki düğümler için
	
	//Node constructer
	Node(int coefficient, int exponent){
		this.coefficient = coefficient;
		this.exponent = exponent;
		this.next = null; //Başka bir düğüme işaret etmemesi için next referansı null olarak yapıyoruz.
	}
}
