package com.sunchao.ahocorasick;

   /*
    * LinkedList implementation of EdgeList  should be more memory-intensive 
    * 
    */

    class SparseEdgeList implements EdgeList {

    	private Crons head;
    	
    	
    	public SparseEdgeList(){
    		
    		head = null;
    		
    	}
		
		public State get(byte ch) {
			
			Crons c = head;
			
			while(c != null){
				
				if(c.b ==  ch)
					
					return c.s;
				
				c = c.next;
				
			}
			
			return null;
		}

	
		public void put(State state, byte ch) {
			
			this.head = new Crons(ch,state,head);
		}

	
		public byte[] keys() {
			
			int length = 0;
			
			Crons  c = head;
			
			while(c != null){
				
				length++;
				
				c = c.next;
				
			}
			
			byte[]  b = new byte[length];
			c = head ;
			int j = 0 ;
			while(c != null){
				
				b[j] = c.b;
				j++;
				c = c.next;
			}
			
			return b;
		}
		
		
		private static class Crons{
			
			byte b;
			
			State s;
			
			Crons next;
			
			public  Crons(byte b , State s , Crons next){
				
				this.b = b;
				
				this.s = s;
				
				this.next = next;
				
			}
		}

}
