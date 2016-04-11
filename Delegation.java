
	public class Delegation {
		public static void main(String args[]) {
			C c = new C();
			System.out.println(c.r());
			D d = new D();
			System.out.println(d.r());
			
			C2 c2 = new C2();
			System.out.println(c2.r());
			D2 d2 = new D2();
			System.out.println(d2.r());
		}
	}

	 abstract class A {
		int a1 = 1;
		int a2 = 2;

		public int f() {
			return a1 + p(100) + q(100);
		}

        protected abstract int p(int m);
        protected abstract int q(int m);
	 }
	 
	 class A2 implements IA{
		 int a1=1;
		 int a2=2;
		 public A2(IA p){				//Constructor which gets initialized to the reference sent as a parameter to the constructor
			 this2=p;
		 }
		 public int f(){
			 return a1+this2.p(100)+this2.q(100);
		 }
		 public int p(int m){
			 return this2.p(m); 
		 }
		 public int q(int m){
			 return this2.q(m);
		 }
		 public int geta1(){
			 return a1;
		 }
		 public int geta2(){
			 return a2;
		 }
		 IA this2;
	 }
	
	 
	 interface IA{
		 int f();
		 int p(int m);
		 int q(int m);
		 public int geta1();			// getter method to get the value of variable a1
		 public int geta2();			// getter method to get the value of variable a2
	 }
	 
	 class B extends A {
		int b1 = 10;
		int b2 = 20;

		public int g() {
			return f() + this.q(200);
		}

		public int p(int m) {
			return m + b1;
		}

		public int q(int m) {
			return m + b2;
		}
	}
	 
	interface IB extends IA{
		public int g();
		public int getb1();				// getter method to get the value of variable b1
		public int getb2();				// getter method to get the value of variable b2
	}
	
	class B2 implements IB{
		int b1 = 10;
		int b2 = 20;
		
		B2(){
			//this2=new A2(this);
			super2=new A2(this);			//Sending reference of B2 to A2
			this2=this;
		}
		
		B2(IA p){
			super2=new A2(p);				//Sending reference sent as parameter to B2 constructor such that it is sent to A2
			this2=p;
		}
		
		public int f(){
			return super2.f(); 
		}

		public int g() {
			return f() + this2.q(200);
		}

		public int p(int m) {
			return m + b1;
		}

		public int q(int m) {
			return m + b2;
		}		
		
		public int geta1() {
			return super2.geta1();
		}
		
		public int geta2() {
			return super2.geta2();
		}
		public int getb1(){
			return b1;
		}
		public int getb2(){
			return b2;
		}		
		IA super2;
		IA this2;
	}
	 

	class C extends B {
		int c1 = 100;
		int c2 = 200;

		public int r() {
			return f() + g() + c1;
			}
		
		public int p(int m) {
			return super.p(m) + super.q(m) + c2;
		}
		
		public int q(int m) {
			return m + a2 + b2 + c2;
		}
	}
	
	interface IC extends IB{
		public int r();
		public int getc1();				// getter method to get the value of variable c1
		public int getc2();				// getter method to get the value of variable c2
	}
	
	class C2 implements IC{
		int c1 = 100;
		int c2 = 200;
		C2(){
			super2=new B2(this);			//Sending reference of C2 to B2
		}
//		C2(IB p){
//			super2=p;						
//		}
		public int r(){
			return super2.f()+super2.g()+c1; 
		}
		public int p(int m){
			return super2.p(m)+super2.q(m)+c2;
		}
		public int q(int m){
			return m+super2.geta2()+super2.getb2()+this.getc2();
		}
		public int getc1(){
			return c1;
		}
		public int getc2(){
			return c2;
		}
		public int g() {
			return super2.g();
		}
		public int getb1() {
			return super2.getb1();
		}
		public int getb2() {
			return super2.getb2();
		}
		public int f() {
			return super2.f();
		}
		public int geta1() {
			return super2.geta1();
		}
		public int geta2() {
			return super2.geta2();
		}
		IB super2;
		//IB super3;
	}

	class D extends B {
		int d1 = 300;
		int d2 = 400;
		
		public int p(int m) {
			return m + a1 + b1 + d1;
			
		}
		public int r() {
			return f() + g() + d2;
		}

	}
	
	class D2 implements ID{
		int d1 = 300;
		int d2 = 400;
		
		D2(){
			super2=new B2(this);				//Sending reference of D2 to B2
			//super3=new A2(this);
		}
		
		public int p(int m) {
			return m + super2.geta1() + super2.getb1() + this.getd1();
			
		}
		public int r() {
			return super2.f() + super2.g() + this.d2;
		} 
		public int g() {
			return super2.g();
		}
		public int q(int m) {
			return super2.q(m);
		}
		public int getb1() {
			return super2.getb1();
		}
		public int getb2() {
			return super2.getb2();
		}
		public int f() {
			return super2.f();
		}
		public int geta1() {
			return super2.geta1();
		}
		public int geta2() {
			return super2.geta2();
		}
		public int getd1() {
			return d1;
		}
		public int getd2() {
			return d2;
		}
		
		IB super2;
		//IA super3;
	}

	interface ID extends IB{
		public int p(int m);
		public int r();
		public int getd1();				// getter method to get the value of variable d1
		public int getd2();				// getter method to get the value of variable d2
	}
 